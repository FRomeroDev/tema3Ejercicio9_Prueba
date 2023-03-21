package pruebas;

import java.util.Scanner;

    class X {
	int i = 1221;

	void methodOfX() {
	    System.out.println(i);
	}
 
	public static void main(String[] args) {
	    X x = new X();
	    System.out.println(x.i);
	    x.methodOfX();
	}
    }
