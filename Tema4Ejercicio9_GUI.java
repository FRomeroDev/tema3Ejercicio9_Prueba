package tema3Ejercicio9;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * @author FERNANDO ROMERO DE ÁVILA - 1º DAW 2022-23
 * 
 * author FERNANDO ROMERO DE ÁVILA - 1º DAW 2022-23
 */
public class Tema4Ejercicio9_GUI {

    private JFrame frmCalculadoraBasica;
    private JTextField textFieldNumeroX;
    private JTextField textFieldNumeroY;

    int num1;
    int num2;
    int resultado;

    Pattern pat;
    Matcher matX;
    Matcher matY;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Tema4Ejercicio9_GUI window = new Tema4Ejercicio9_GUI();
		    window.frmCalculadoraBasica.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public Tema4Ejercicio9_GUI() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frmCalculadoraBasica = new JFrame();
	frmCalculadoraBasica.setFont(new Font("Lucida Grande", Font.BOLD, 15));
	frmCalculadoraBasica.setBackground(Color.LIGHT_GRAY);
	frmCalculadoraBasica.setTitle("Calculator de 6 dígitos");
	frmCalculadoraBasica.setBounds(100, 100, 750, 350);
	frmCalculadoraBasica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmCalculadoraBasica.getContentPane().setLayout(null);
	pat = Pattern.compile("^\\d{1,6}$");

	/* Permite mofiicar el aspecto en mac de botones etc */
	try {
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	/** ETIQUETAS DE TEXTO DE INFORMACIÓN FIJA */
	JLabel lblInfoNumeroX = new JLabel("Introduzca un número X:");
	lblInfoNumeroX.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	lblInfoNumeroX.setBounds(144, 49, 171, 16);
	frmCalculadoraBasica.getContentPane().add(lblInfoNumeroX);

	JLabel lblInfoNumeroY = new JLabel("Introduzca un número Y:");
	lblInfoNumeroY.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	lblInfoNumeroY.setBounds(144, 111, 171, 16);
	frmCalculadoraBasica.getContentPane().add(lblInfoNumeroY);

	/** ETIQUETAS DE TEXTO MUESTRA ERROR */
	JLabel lblMuestraErrorNumX = new JLabel("Error: número no válido");
	lblMuestraErrorNumX.setForeground(Color.RED);
	lblMuestraErrorNumX.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	lblMuestraErrorNumX.setBounds(503, 50, 180, 16);
	frmCalculadoraBasica.getContentPane().add(lblMuestraErrorNumX);
	lblMuestraErrorNumX.setVisible(false);

	JLabel lblMuestraErrorNumY = new JLabel("Error: número no válido");
	lblMuestraErrorNumY.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	lblMuestraErrorNumY.setForeground(Color.RED);
	lblMuestraErrorNumY.setBounds(503, 112, 170, 16);
	frmCalculadoraBasica.getContentPane().add(lblMuestraErrorNumY);
	lblMuestraErrorNumY.setVisible(false);

	/** CASILLA ENTRADA TEXTO USUARIO */
	textFieldNumeroX = new JTextField();
	textFieldNumeroX.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	textFieldNumeroX.setBounds(361, 44, 130, 26);
	frmCalculadoraBasica.getContentPane().add(textFieldNumeroX);
	textFieldNumeroX.setColumns(10);

	textFieldNumeroY = new JTextField();
	textFieldNumeroY.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	textFieldNumeroY.setBounds(361, 106, 130, 26);
	frmCalculadoraBasica.getContentPane().add(textFieldNumeroY);
	textFieldNumeroY.setColumns(10);

	/** ETIQUETAS DE TEXTO MUESTRA TEXTO FIJO DE RESULTADO */
	JLabel lblInfoResultado = new JLabel("El resultado es:");
	lblInfoResultado.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	lblInfoResultado.setBounds(246, 241, 111, 16);
	frmCalculadoraBasica.getContentPane().add(lblInfoResultado);

	/** ETIQUETAS DE TEXTO MUESTRA RESULTADO (OCULTA Y VARIABLE) */
	JLabel lblResultado = new JLabel("");
	lblResultado.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	lblResultado.setBounds(361, 241, 130, 16);
	frmCalculadoraBasica.getContentPane().add(lblResultado);

	/** BOTONES DE OPERACIONES */
	JButton btnSumar = new JButton("Sumar");
	btnSumar.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	btnSumar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
	btnSumar.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		/**
		 * EVENTO 1: Comprueba el patrón de texto y si no coincide muestra en label
		 * mensaje de error en rojo
		 */
		matX = pat.matcher(textFieldNumeroX.getText());
		matY = pat.matcher(textFieldNumeroY.getText());
		if (!matX.matches() || (!matY.matches())) {
		    if (!matX.matches()) {
			lblMuestraErrorNumX.setVisible(true);
			lblResultado.setText(null);
		    } else {
			lblMuestraErrorNumX.setVisible(false);
		    }
		    if (!matY.matches()) {
			lblMuestraErrorNumY.setVisible(true);
			lblResultado.setText(null);
		    } else {
			lblMuestraErrorNumY.setVisible(false);
		    }
		} else {
		    lblMuestraErrorNumX.setVisible(false);
		    lblMuestraErrorNumY.setVisible(false);
		    num1 = Integer.parseInt(textFieldNumeroX.getText());
		    num2 = Integer.parseInt(textFieldNumeroY.getText());
		    resultado = num1 + num2;
		    lblResultado.setText(String.valueOf(resultado));

		}
	    }
	});
	btnSumar.setBounds(90, 165, 111, 29);
	frmCalculadoraBasica.getContentPane().add(btnSumar);

	JButton btnRestar = new JButton("Restar");
	btnRestar.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	btnRestar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
	btnRestar.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {

		matX = pat.matcher(textFieldNumeroX.getText());
		matY = pat.matcher(textFieldNumeroY.getText());
		if (!matX.matches() || (!matY.matches())) {
		    if (!matX.matches()) {
			lblMuestraErrorNumX.setVisible(true);
		    } else {
			lblMuestraErrorNumX.setVisible(false);
		    }
		    if (!matY.matches()) {
			lblMuestraErrorNumY.setVisible(true);
		    } else {
			lblMuestraErrorNumY.setVisible(false);
		    }
		} else {
		    lblMuestraErrorNumX.setVisible(false);
		    lblMuestraErrorNumY.setVisible(false);
		    num1 = Integer.parseInt(textFieldNumeroX.getText());
		    num2 = Integer.parseInt(textFieldNumeroY.getText());
		    resultado = num1 - num2;
		    lblResultado.setText(String.valueOf(resultado));
		}
	    }
	});
	btnRestar.setBounds(208, 165, 111, 29);
	frmCalculadoraBasica.getContentPane().add(btnRestar);

	JButton btnMultiplicar = new JButton("Multiplicar");
	btnMultiplicar.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	btnMultiplicar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
	btnMultiplicar.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {

		matX = pat.matcher(textFieldNumeroX.getText());
		matY = pat.matcher(textFieldNumeroY.getText());
		if (!matX.matches() || (!matY.matches())) {
		    if (!matX.matches()) {
			lblMuestraErrorNumX.setVisible(true);
		    } else {
			lblMuestraErrorNumX.setVisible(false);
		    }
		    if (!matY.matches()) {
			lblMuestraErrorNumY.setVisible(true);
		    } else {
			lblMuestraErrorNumY.setVisible(false);
		    }
		} else {
		    lblMuestraErrorNumX.setVisible(false);
		    lblMuestraErrorNumY.setVisible(false);
		    num1 = Integer.parseInt(textFieldNumeroX.getText());
		    num2 = Integer.parseInt(textFieldNumeroY.getText());
		    resultado = num1 * num2;
		    lblResultado.setText(String.valueOf(resultado));
		}
	    }
	});
	btnMultiplicar.setBounds(326, 165, 111, 29);
	frmCalculadoraBasica.getContentPane().add(btnMultiplicar);

	JButton btnDividir = new JButton("Dividir");
	btnDividir.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	btnDividir.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
	btnDividir.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {

		matX = pat.matcher(textFieldNumeroX.getText());
		matY = pat.matcher(textFieldNumeroY.getText());
		if (!matX.matches() || (!matY.matches())) {
		    if (!matX.matches()) {
			lblMuestraErrorNumX.setVisible(true);
		    } else {
			lblMuestraErrorNumX.setVisible(false);
		    }
		    if (!matY.matches()) {
			lblMuestraErrorNumY.setVisible(true);
		    } else {
			lblMuestraErrorNumY.setVisible(false);
		    }
		} else {
		    lblMuestraErrorNumX.setVisible(false);
		    lblMuestraErrorNumY.setVisible(false);
		    num1 = Integer.parseInt(textFieldNumeroX.getText());
		    num2 = Integer.parseInt(textFieldNumeroY.getText());
		    resultado = num1 / num2;
		    lblResultado.setText(String.valueOf(resultado));
		}

	    }
	});
	btnDividir.setBounds(444, 165, 111, 29);
	frmCalculadoraBasica.getContentPane().add(btnDividir);

	JButton btnResto = new JButton("Resto");
	btnResto.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	btnResto.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
	btnResto.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {

		matX = pat.matcher(textFieldNumeroX.getText());
		matY = pat.matcher(textFieldNumeroY.getText());
		if (!matX.matches() || (!matY.matches())) {
		    if (!matX.matches()) {
			lblMuestraErrorNumX.setVisible(true);
		    } else {
			lblMuestraErrorNumX.setVisible(false);
		    }
		    if (!matY.matches()) {
			lblMuestraErrorNumY.setVisible(true);
		    } else {
			lblMuestraErrorNumY.setVisible(false);
		    }
		} else {
		    lblMuestraErrorNumX.setVisible(false);
		    lblMuestraErrorNumY.setVisible(false);
		    num1 = Integer.parseInt(textFieldNumeroX.getText());
		    num2 = Integer.parseInt(textFieldNumeroY.getText());
		    resultado = num1 % num2;
		    lblResultado.setText(String.valueOf(resultado));
		}
	    }
	});
	btnResto.setBounds(562, 165, 111, 29);
	frmCalculadoraBasica.getContentPane().add(btnResto);

	JButton btnReset = new JButton("Limpiar");
	btnReset.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
	btnReset.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
	btnReset.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		/**
		 * EVENTO 2: Limpia valores de casillas de entrada de datos y mensaje error
		 */
		textFieldNumeroX.setText(null);
		textFieldNumeroY.setText(null);
		lblResultado.setText(null);
		lblMuestraErrorNumX.setVisible(false);
		lblMuestraErrorNumY.setVisible(false);
	    }
	});
	btnReset.setBounds(90, 237, 117, 29);
	frmCalculadoraBasica.getContentPane().add(btnReset);

    }
}
