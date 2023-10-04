package co.edu.unbosque.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AlcoholicoDTO;

class AlcoholicoDTOTest {
	private static int counter = 0;

	public static void start(String name) {
		System.out.println("\n test called: " + name + ", number: " + counter + " starting");
	}

	@BeforeAll

	public static void banner() {

		System.err.println("\n______________ Starting all ParticipantDTO unit tests _____________");

	}

	@Test
	void testAlcoholicoDTO() {
		start("Constructor AlcoholicoDTO");
		counter++;
		int id = 1;
		String nombre = "Juan Jose";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		int nSesiones = 0;
		String apodo = "contarracho";

		AlcoholicoDTO aux = new AlcoholicoDTO(id, nombre, cedula, contrasena, nSesiones, apodo);
		assertEquals(aux, aux);
	}

	@Test
	void testGetnSesiones() {
		start("GetSesiones");
		counter++;
		int id = 1;
		String nombre = "Juan Jose";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		int nSesiones = 0;
		String apodo = "contarracho";

		AlcoholicoDTO aux = new AlcoholicoDTO(id, nombre, cedula, contrasena, nSesiones, apodo);
		assertEquals(0, aux.getnSesiones());
	}

	@Test
	void testGetApodo() {
		start("GetApodo");
		counter++;
		int id = 1;
		String nombre = "Juan Jose";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		int nSesiones = 0;
		String apodo = "costarracho";

		AlcoholicoDTO aux = new AlcoholicoDTO(id, nombre, cedula, contrasena, nSesiones, apodo);
		assertEquals("costarracho", aux.getApodo());
	}

	@Test
	void testToString() {
		start("ToString");
		counter++;
		AlcoholicoDTO borracho = new AlcoholicoDTO();
		borracho.setId(1);
		borracho.setNombre("berni");
		borracho.setCedula(1L);
		borracho.setContrasena("patos");
		borracho.setnSesiones(0);
		borracho.setApodo("costarracho");

		String aux = "\nNombre: " + borracho.getNombre() + "\nId: " + borracho.getId() + "\nCedula: "
				+ borracho.getCedula() + "\n Contraseña: " + borracho.getContrasena() + "\nNumero de sesiones: "
				+ borracho.getnSesiones() + "\nApodo" + borracho.getApodo();
		assertEquals(aux, borracho.toString());

	}

}
