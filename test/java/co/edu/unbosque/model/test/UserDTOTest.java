package co.edu.unbosque.model.test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.UserDTO;


class UserDTOTest {
	private static int counter = 0;

	public static void start(String name) {
		System.out.println("\n test called: " + name + ", number: " + counter + " starting");
	}

	@BeforeAll

	public static void banner() {

		System.err.println("\n______________ Starting all ParticipantDTO unit tests _____________");

	}

	@Test
	void testUserDTO() {
		start("Constructor UserDTO");
		counter++;
		int id = 1;
		String nombre = "test";
		String usarName = "manueh";
		String password = "1234";

		UserDTO aux = new UserDTO(id, nombre, usarName, password);
		assertEquals(aux, aux);
	}

	@Test
	void testGetName() {
		start("GetName");
		counter++;
		int id = 1;
		String nombre = "test";
		String usarName = "manueh";
		String password = "1234";

		UserDTO aux = new UserDTO(id, nombre, usarName, password);
		assertEquals("test", aux.getName());
	}

	@Test
	void testGetUserName() {
		start("GetUsarName");
		counter++;
		int id = 1;
		String nombre = "test";
		String usarName = "manueh";
		String password = "1234";

		UserDTO aux = new UserDTO(id, nombre, usarName, password);
		assertEquals("manueh", aux.getUserName());
	}

	@Test
	void testGetPassword() {
		start("GetPassword");
		counter++;
		int id = 1;
		String nombre = "test";
		String usarName = "manueh";
		String password = "1234";

		UserDTO aux = new UserDTO(id, nombre, usarName, password);
		assertEquals("1234", aux.getPassword());
	}

	@Test
	void testGetId() {
		start("Constructor UserDTO");
		counter++;
		int id = 1;
		String nombre = "test";
		String usarName = "manueh";
		String password = "1234";

		UserDTO aux = new UserDTO(id, nombre, usarName, password);
		assertEquals(1, aux.getId());
	}

	@Test
	void testToString() {
		start("ToString");
		counter++;
		UserDTO user = new UserDTO();
		user.setId(1);
		user.setName("berni");
		user.setUserName("muaeh");
		user.setPassword("patos");

		String aux = "UserDTO [id=" + user.getId() + ", Name=" + user.getName() + ", userName=" + user.getUserName()
				+ ", password=" + user.getPassword() + "]";
		assertEquals(aux, user.toString());
	}

}
