package co.edu.unbosque.model.persistence.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.PersonaDTO;
import co.edu.unbosque.model.persistence.PersonaDAO;

class PersonaDAOTest {

	@Test
	void testPersonaDAO() {
		PersonaDAO dao = new PersonaDAO();
		assertNotNull(dao.getPersonas());
		assertNotNull(dao.getDbcon());
	}

	@Test
	void testgetPersonas() {
		PersonaDAO dao = new PersonaDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena);

		ArrayList<PersonaDTO> personas = dao.getPersonas();
		assertEquals(1, personas.size());

		PersonaDTO persona = personas.get(0);
		assertEquals(id, persona.getId());
		assertEquals(nombre, persona.getNombre());
		assertEquals(cedula, persona.getCedula());
		assertEquals(contrasena, persona.getContrasena());

	}

	@Test
	void testCreateObject() {
		PersonaDAO dao = new PersonaDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";


		dao.create(id, nombre, cedula, contrasena);

		ArrayList<PersonaDTO> personas = dao.getPersonas();
		assertEquals(1, personas.size());

		PersonaDTO persona = personas.get(0);
		assertEquals(id, persona.getId());
		assertEquals(nombre, persona.getNombre());
		assertEquals(cedula, persona.getCedula());
		assertEquals(contrasena, persona.getContrasena());

	}

	@Test
	void testReadAll() {
		PersonaDAO dao = new PersonaDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		int nSesiones = 2;
		String apodo = "costarracho";

		dao.create(id, nombre, cedula, contrasena);

		String result = dao.readAll();
		String expected = "\nNombre:" + nombre + "\nId:" + id + "\nCedula:" + cedula + "\nContrasena:" + contrasena
				+ "\nnSesiones:" + nSesiones + "\nApodo:" + apodo;
		assertEquals(expected, result);
	}

	@Test
	void testUpdateById() {
		PersonaDAO dao = new PersonaDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;

		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena);

		String nuevoNombre = "test name";
		long nuevaCedula = 111111111L;
		String nuevaContrasena = "test pass";

		int result = dao.updateById(id, nuevoNombre, nuevaCedula, nuevaContrasena);

		assertEquals(0, result);

		ArrayList<PersonaDTO> personas = dao.getPersonas();
		PersonaDTO persona = personas.get(0);

		assertEquals(id, persona.getId());
		assertEquals(nuevoNombre, persona.getNombre());
		assertEquals(nuevaCedula, persona.getCedula());
		assertEquals(nuevaContrasena, persona.getContrasena());;
	}

	@Test
	void testDeleteById() {
		PersonaDAO dao = new PersonaDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";


		dao.create(id, nombre, cedula, contrasena);

		int result = dao.deleteById(id);

		assertEquals(0, result);
		assertEquals(0, dao.getPersonas().size());
	}
}
