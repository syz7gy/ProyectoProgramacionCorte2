package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

	private Scanner lector;

	public Console() {

		lector = new Scanner(System.in);
	}

	public int leerEntero() {
		int temp = lector.nextInt();
		return temp;

	}

	public long leerLong() {
		long temp = lector.nextLong();
		return temp;

	}

	public float leerFloat() {
		float temp = lector.nextFloat();
		return temp;

	}

	public double leerDouble() {
		double temp = lector.nextDouble();
		return temp;

	}

	public String leerLineaEntera() {
		String temp = lector.nextLine();
		return temp;

	}

	public String leerCadena() {
		String temp = lector.next();
		return temp;

	}

	public char leerCaracter() {
		char temp = leerCadena().charAt(0);
		return temp;

	}

	public boolean leerBooleano() {
		boolean temp = Boolean.valueOf(leerCadena());
		return temp;

	}

	public void quemarLinea() {
		lector.nextLine();
	}

	public void imprimirConSalto(String text) {
		System.out.println(text);

	}

	public void imprimirConSaltoRed(String text) {
		System.err.println(text);

	}

	public void imprimirSinSalto(String text) {
		System.out.println(text);

	}

	public void imprimirSalto() {
		System.out.println();
	}
}