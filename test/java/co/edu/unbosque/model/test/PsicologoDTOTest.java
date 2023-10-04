package co.edu.unbosque.model.test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.PsicologoDTO;


class PsicologoDTOTest {
	private static int counter = 0;

	public static void start(String name) {
		System.out.println("\n test called: " + name + ", number: " + counter + " starting");
	}

	@BeforeAll

	public static void banner() {

		System.err.println("\n______________ Starting all ParticipantDTO unit tests _____________");

	}

	@Test
	void testPsicologoDTO() {
		start("Constructor PsicologoDTO");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		String aGraduacion = " a long time";
		int dServicio = 5;
		int sApoyo = 3;
		String Salario = "mucho";

		PsicologoDTO aux = new PsicologoDTO(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyo, Salario);
		assertEquals(aux, aux);
	}

	@Test
	void testGetaGraduacion() {
		start("GetaGraduacion");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		String aGraduacion = " a long time";
		int dServicio = 5;
		int sApoyo = 3;
		String Salario = "mucho";

		PsicologoDTO aux = new PsicologoDTO(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyo, Salario);
		assertEquals(" a long time", aux.getaGraduacion());
	}

	@Test
	void testGetdServicio() {
		start("GetdServicio");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		String aGraduacion = " a long time";
		int dServicio = 5;
		int sApoyo = 3;
		String Salario = "mucho";

		PsicologoDTO aux = new PsicologoDTO(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyo, Salario);
		assertEquals(5, aux.getdServicio());
	}

	@Test
	void testGetsApoyada() {
		start("GetsApoyada");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		String aGraduacion = " a long time";
		int dServicio = 5;
		int sApoyo = 3;
		String Salario = "mucho";

		PsicologoDTO aux = new PsicologoDTO(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyo, Salario);
		assertEquals(3, aux.getsApoyada());
	}

	@Test
	void testGetSalario() {
		start("GetdServicio");
		counter++;
		int id = 1;
		String nombre = "test";
		Long cedula = 0000000000L;
		String contrasena = "1234";
		String aGraduacion = " a long time";
		int dServicio = 5;
		int sApoyo = 3;
		String Salario = "mucho";

		PsicologoDTO aux = new PsicologoDTO(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyo, Salario);
		assertEquals("mucho", aux.getSalario());
	}

	@Test
	void testToString() {
		start("ToString");
		counter++;
		PsicologoDTO psico = new PsicologoDTO();
		psico.setId(1);
		psico.setNombre("berni");
		psico.setCedula(1L);
		psico.setContrasena("patos");
		psico.setaGraduacion("a long time");
		psico.setdServicio(5);
		psico.setsApoyada(3);
		psico.setSalario("costarracho");

		String aux = "\nNombre: " + psico.getNombre() + "\nId: " + psico.getId()  + "\nCedula: " + psico.getCedula() + 
				 "\n Contraseña: " + psico.getContrasena() + "\nNumero de sesiones apoyadas: " + psico.getsApoyada() + "\nDias en servicio" + psico.getdServicio() + "\nAño de graduacion: " + psico.getaGraduacion() +"\nSalario" + psico.getSalario();
		assertEquals(aux, psico.toString());

	}

}
