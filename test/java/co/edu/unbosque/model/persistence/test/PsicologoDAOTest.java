package co.edu.unbosque.model.persistence.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.PsicologoDTO;
import co.edu.unbosque.model.persistence.PsicologoDAO;

class PsicologoDAOTest {

	@Test
	void testPsicologoDAO() {
		PsicologoDAO dao = new PsicologoDAO();
		assertNotNull(dao.getPsicologos());
		assertNotNull(dao.getDbcon());
	}

	@Test
	void testGetPsicolo() {
		PsicologoDAO dao = new PsicologoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String aGraduacion = "tiempo";
		int dServicio = 9;
		int sApoyada = 9;
		String salario = "mucho";

		dao.create(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyada, salario);

		ArrayList<PsicologoDTO> Psicolo = dao.getPsicologos();
		assertEquals(1, Psicolo.size());

		PsicologoDTO pServicio = Psicolo.get(0);
		assertEquals(id, pServicio.getId());
		assertEquals(nombre, pServicio.getNombre());
		assertEquals(cedula, pServicio.getCedula());
		assertEquals(contrasena, pServicio.getContrasena());
		assertEquals(aGraduacion, pServicio.getaGraduacion());
		assertEquals(dServicio, pServicio.getdServicio());
		assertEquals(sApoyada, pServicio.getsApoyada());
		assertEquals(salario, pServicio.getSalario());

	}

	@Test
	void testCreateObject() {
		PsicologoDAO dao = new PsicologoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String aGraduacion = "tiempo";
		int dServicio = 9;
		int sApoyada = 9;
		String salario = "mucho";

		dao.create(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyada, salario);

		ArrayList<PsicologoDTO> Psicolo = dao.getPsicologos();
		assertEquals(1, Psicolo.size());

		PsicologoDTO pServicio = Psicolo.get(0);
		assertEquals(id, pServicio.getId());
		assertEquals(nombre, pServicio.getNombre());
		assertEquals(cedula, pServicio.getCedula());
		assertEquals(contrasena, pServicio.getContrasena());
		assertEquals(aGraduacion, pServicio.getaGraduacion());
		assertEquals(dServicio, pServicio.getdServicio());
		assertEquals(sApoyada, pServicio.getsApoyada());
		assertEquals(salario, pServicio.getSalario());
	}

	@Test
	void testReadAll() {
		PsicologoDAO dao = new PsicologoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String aGraduacion = "tiempo";
		int dServicio = 9;
		int sApoyada = 9;
		String salario = "mucho";
		;

		dao.create(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyada, salario);

		String result = dao.readAll();
		String expected = "\nNombre:" + nombre + "\nId:" + id + "\nCedula:" + cedula + "\nContrasena:" + contrasena
				+ "\nAGraduacion:" + aGraduacion + "\ndServicio:" + dServicio + "\nSApoyada:" + sApoyada + "\nSalario:"
				+ salario;
		assertEquals(expected, result);
	}

	@Test
	void testUpdateById() {
		PsicologoDAO dao = new PsicologoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String aGraduacion = "tiempo";
		int dServicio = 9;
		int sApoyada = 9;
		String salario = "mucho";

		dao.create(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyada, salario);

		String nuevoNombre = "test name";
		long nuevaCedula = 111111111L;
		String nuevaContrasena = "test pass";
		String nuevoAGraduacion = "tiempo";
		int nuevoDServicio = 9;
		int nuevoSApoyada = 9;
		String nuevoSalario = "mucho";

		int result = dao.updateById(id, nuevoNombre, nuevaCedula, nuevaContrasena, nuevoSApoyada, nuevoDServicio,
				nuevoAGraduacion, nuevoSalario);

		assertEquals(0, result);

		ArrayList<PsicologoDTO> Psicolo = dao.getPsicologos();
		PsicologoDTO pServicio = Psicolo.get(0);

		assertEquals(id, pServicio.getId());
		assertEquals(nuevoNombre, pServicio.getNombre());
		assertEquals(nuevaCedula, pServicio.getCedula());
		assertEquals(nuevaContrasena, pServicio.getContrasena());
		assertEquals(nuevoAGraduacion, pServicio.getaGraduacion());
		assertEquals(nuevoDServicio, pServicio.getdServicio());
		assertEquals(nuevoSApoyada, pServicio.getsApoyada());
		assertEquals(nuevoSalario, pServicio.getSalario());
	}

	@Test
	void testDeleteById() {
		PsicologoDAO dao = new PsicologoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";
		String aGraduacion = "tiempo";
		int dServicio = 9;
		int sApoyada = 9;
		String salario = "mucho";

		dao.create(id, nombre, cedula, contrasena, aGraduacion, dServicio, sApoyada, salario);

		int result = dao.deleteById(id);

		assertEquals(0, result);
		assertEquals(0, dao.getPsicologos().size());
	}
}
