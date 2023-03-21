package pruebas;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author FERNANDO ROMERO DE ÁVILA - 1º DAW 2022-23
 */
public class PruebasAleatorias {

    public static void main(String[] args) {

	String nota1;
	double nota2;
	double nota3;
	double medias;
	String nombre;

	try {
	    FileReader reader = new FileReader("medias.txt");
	    Scanner sc = new Scanner(reader);
	    
	    while (sc.hasNext()) {

		nombre = sc.next();
		nota1 = sc.next();
		
		
		System.out.println(nombre + " "+ nota1);


	    }

	} catch (IOException e3) {
	    System.out.println("ERROR: No se ha podido leer del archivo");
	} catch ( java.util.InputMismatchException e3) {
	    System.out.println("ERROR: No se ha podido leer del archivo");

	} finally {
	    System.out.println("Fichero creado");

	}
    }

}


/*
else if (dobNewUser.compareTo(dateNow) > 0) {
	errDobLbl.setVisible(true);
	errDobLbl.setText("Employee date of birth is upper than current date.");
} else {
	errDobLbl.setVisible(false);
}

} catch (DateTimeParseException e2) {

}
*/