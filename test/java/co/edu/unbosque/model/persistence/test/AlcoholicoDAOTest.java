package co.edu.unbosque.model.persistence.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AlcoholicoDTO;
import co.edu.unbosque.model.persistence.AlcoholicoDAO;

class AlcoholicoDAOTest {

	@Test
	void testAlcoholicoDAO() {
		AlcoholicoDAO dao = new AlcoholicoDAO();
		assertNotNull(dao.getAlcoholicos());
		assertNotNull(dao.getDbcon());
		
	}

	@Test
	void testGetAlcoholicos() {
		AlcoholicoDAO dao = new AlcoholicoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		int nSesiones = 2;
		String apodo = "costarracho";

		dao.create(id, nombre, cedula, contrasena, nSesiones, apodo);

		ArrayList<AlcoholicoDTO> Alcoholicos = dao.getAlcoholicos();
		assertEquals(1, Alcoholicos.size());

		AlcoholicoDTO alcoholico = Alcoholicos.get(0);
		assertEquals(id, alcoholico.getId());
		assertEquals(nombre, alcoholico.getNombre());
		assertEquals(cedula, alcoholico.getCedula());
		assertEquals(contrasena, alcoholico.getContrasena());
		assertEquals(nSesiones, alcoholico.getnSesiones());
		assertEquals(apodo, alcoholico.getApodo());
	}

	@Test
	void testCreateObject() {
		AlcoholicoDAO dao = new AlcoholicoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		int nSesiones = 2;
		String apodo = "costarracho";

		dao.create(id, nombre, cedula, contrasena, nSesiones, apodo);

		ArrayList<AlcoholicoDTO> Alcoholicos = dao.getAlcoholicos();
		assertEquals(1, Alcoholicos.size());

		AlcoholicoDTO alcoholico = Alcoholicos.get(0);
		assertEquals(id, alcoholico.getId());
		assertEquals(nombre, alcoholico.getNombre());
		assertEquals(cedula, alcoholico.getCedula());
		assertEquals(contrasena, alcoholico.getContrasena());
		assertEquals(nSesiones, alcoholico.getnSesiones());
		assertEquals(apodo, alcoholico.getApodo());
	}

	@Test
	void testReadAll() {
		AlcoholicoDAO dao = new AlcoholicoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		int nSesiones = 2;
		String apodo = "costarracho";

		dao.create(id, nombre, cedula, contrasena, nSesiones, apodo);

		String result = dao.readAll();
		String expected = "\nNombre:" + nombre + "\nId:" + id + "\nCedula:" + cedula + "\nContrasena:" + contrasena
				+ "\nnSesiones:" + nSesiones + "\nApodo:" + apodo;
		assertEquals(expected, result);
	}

	@Test
	void testUpdateById() {
		AlcoholicoDAO dao = new AlcoholicoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		int nSesiones = 2;
		String apodo = "costarracho";
		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena, nSesiones, apodo);

		String nuevoNombre = "test name";
		long nuevaCedula = 111111111L;
		String nuevaContrasena = "test pass";
		int nuevoNSesiones = 22;
		String nuevoApodo = "harryno";
		int result = dao.updateById(id, nuevoNombre, nuevaCedula, nuevaContrasena, nuevoNSesiones, nuevoApodo);

		assertEquals(0, result);

		ArrayList<AlcoholicoDTO> Alcoholicos = dao.getAlcoholicos();
		AlcoholicoDTO alcoholico = Alcoholicos.get(0);

		assertEquals(id, alcoholico.getId());
		assertEquals(nuevoNombre, alcoholico.getNombre());
		assertEquals(nuevaCedula, alcoholico.getCedula());
		assertEquals(nuevaContrasena, alcoholico.getContrasena());
		assertEquals(nuevoNSesiones, alcoholico.getnSesiones());
		assertEquals(nuevoApodo, alcoholico.getApodo());
	}

	@Test
	void testDeleteById() {
		AlcoholicoDAO dao = new AlcoholicoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		int nSesiones = 2;
		String apodo = "costarracho";

		dao.create(id, nombre, cedula, contrasena, nSesiones, apodo);

		int result = dao.deleteById(id);

		assertEquals(0, result);
		assertEquals(0, dao.getAlcoholicos().size());
	}
}
