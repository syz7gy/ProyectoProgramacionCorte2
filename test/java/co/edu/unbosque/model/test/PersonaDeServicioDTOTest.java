package co.edu.unbosque.model.test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import co.edu.unbosque.model.PersonaDeServiciosDTO;

class PersonaDeServicioDTOTest {
	private static int counter = 0;

	public static void start(String name) {
		System.out.println("\n test called: " + name + ", number: " + counter + " starting");
	}

	@BeforeAll

	public static void banner() {

		System.err.println("\n______________ Starting all ParticipantDTO unit tests _____________");

	}

	@Test
	void testPersonaDeServiciosDTO() {
		start("Constructor PersonaDeServicioDTO");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 1010101010L;
		String contrasena = "1234";
		String salario = "poco";
		int sLimpiada = 12;

		PersonaDeServiciosDTO aux = new PersonaDeServiciosDTO(id, nombre, cedula, contrasena, sLimpiada, salario);
		assertEquals(aux, aux);

	}

	@Test
	void testGetSalario() {
		start("GetSalario");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 1010101010L;
		String contrasena = "1234";
		String salario = "poco";
		int sLimpiada = 12;

		PersonaDeServiciosDTO aux = new PersonaDeServiciosDTO(id, nombre, cedula, contrasena, sLimpiada, salario);
		assertEquals("poco", aux.getSalario());
	}

	@Test
	void testGetsLimpiada() {
		start("GetSLimpiada");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 1010101010L;
		String contrasena = "1234";
		String salario = "poco";
		int sLimpiada = 12;

		PersonaDeServiciosDTO aux = new PersonaDeServiciosDTO(id, nombre, cedula, contrasena, sLimpiada, salario);
		assertEquals(12, aux.getsLimpiada());
	}

	@Test
	void testToString() {
		start("ToString");
		counter++;
		PersonaDeServiciosDTO personal = new PersonaDeServiciosDTO();
		personal.setId(1);
		personal.setNombre("manueh");
		personal.setCedula(1L);
		personal.setContrasena("patos");
		personal.setSalario("poco");
		personal.setsLimpiada(12);

		String aux = "\nNombre: " + personal.getNombre() + "\nId: " + personal.getId()  + "\nCedula: " + personal.getCedula()
		+ "\n Contraseña: " + personal.getContrasena() + "\nNumero de sesiones limpiadas: " + personal.getsLimpiada() + "\nSalario: " + personal.getSalario() ;
		assertEquals(aux, personal.toString());
	}
}
