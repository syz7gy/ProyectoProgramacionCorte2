package co.edu.unbosque.model.persistence.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.PersonaDeServiciosDTO;
import co.edu.unbosque.model.persistence.PersonaDeServiciosDAO;

class PersonaDeServiciosDAOTest {

	@Test
	void testPersonaDeServiciosDAO() {
		PersonaDeServiciosDAO dao = new PersonaDeServiciosDAO();
		assertNotNull(dao.getpServicios());
		assertNotNull(dao.getDbcon());
	}

	@Test
	void testGetServicios() {
		PersonaDeServiciosDAO dao = new PersonaDeServiciosDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String salario = "mucho";
		int sLimpiada = 4;

		dao.create(id, nombre, cedula, contrasena, salario, sLimpiada);

		ArrayList<PersonaDeServiciosDTO> Servicios = dao.getpServicios();
		assertEquals(1, Servicios.size());

		PersonaDeServiciosDTO pServicio = Servicios.get(0);
		assertEquals(id, pServicio.getId());
		assertEquals(nombre, pServicio.getNombre());
		assertEquals(cedula, pServicio.getCedula());
		assertEquals(contrasena, pServicio.getContrasena());
		assertEquals(salario, pServicio.getSalario());
		assertEquals(sLimpiada, pServicio.getsLimpiada());
	}

	@Test
	void testCreateObject() {
		PersonaDeServiciosDAO dao = new PersonaDeServiciosDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String salario = "mucho";
		int sLimpiada = 4;

		dao.create(id, nombre, cedula, contrasena, salario, sLimpiada);

		ArrayList<PersonaDeServiciosDTO> Servicios = dao.getpServicios();
		assertEquals(1, Servicios.size());

		PersonaDeServiciosDTO pServicio = Servicios.get(0);
		assertEquals(id, pServicio.getId());
		assertEquals(nombre, pServicio.getNombre());
		assertEquals(cedula, pServicio.getCedula());
		assertEquals(contrasena, pServicio.getContrasena());
		assertEquals(salario, pServicio.getSalario());
		assertEquals(sLimpiada, pServicio.getsLimpiada());
	}

	@Test
	void testReadAll() {
		PersonaDeServiciosDAO dao = new PersonaDeServiciosDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String salario = "mucho";
		int sLimpiada = 4;

		dao.create(id, nombre, cedula, contrasena, salario, sLimpiada);

		String result = dao.readAll();
		String expected = "\nNombre:" + nombre + "\nId:" + id + "\nCedula:" + cedula + "\nContrasena:" + contrasena
				+ "\nSalario:" + salario + "\nSLimpiada:" + sLimpiada;
		assertEquals(expected, result);
	}

	@Test
	void testUpdateById() {
		PersonaDeServiciosDAO dao = new PersonaDeServiciosDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String salario = "mucho";
		int sLimpiada = 4;

		dao.create(id, nombre, cedula, contrasena, salario, sLimpiada);

		String nuevoNombre = "test name";
		long nuevaCedula = 111111111L;
		String nuevaContrasena = "test pass";
		String nuevoSalario = "mucho";
		int nuevoSLimpiada = 4;
		int result = dao.updateById(id, nuevoNombre, nuevaCedula, nuevaContrasena, nuevoSLimpiada, nuevoSalario);

		assertEquals(0, result);

		ArrayList<PersonaDeServiciosDTO> Servicios = dao.getpServicios();
		PersonaDeServiciosDTO pServicio = Servicios.get(0);

		assertEquals(id, pServicio.getId());
		assertEquals(nuevoNombre, pServicio.getNombre());
		assertEquals(nuevaCedula, pServicio.getCedula());
		assertEquals(nuevaContrasena, pServicio.getContrasena());
		assertEquals(nuevoSalario, pServicio.getSalario());
		assertEquals(nuevoSLimpiada, pServicio.getsLimpiada());
	}

	@Test
	void testDeleteById() {
		PersonaDeServiciosDAO dao = new PersonaDeServiciosDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String salario = "mucho";
		int sLimpiada = 4;

		dao.create(id, nombre, cedula, contrasena, salario, sLimpiada);

		int result = dao.deleteById(id);

		assertEquals(0, result);
		assertEquals(0, dao.getpServicios().size());
	}
}
