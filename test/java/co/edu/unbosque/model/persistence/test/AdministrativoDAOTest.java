package co.edu.unbosque.model.persistence.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.persistence.AdministrativoDAO;



class AdministrativoDAOTest {

	@Test
	void testAdministrativoDAO() {
		AdministrativoDAO dao = new AdministrativoDAO();
		assertNotNull(dao.getAdministrativos());
		assertNotNull(dao.getDbcon());
	}

	@Test
	void testGetAdministrativos() {
		AdministrativoDAO dao = new AdministrativoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena);

		ArrayList<AdministrativoDTO> administrativos = dao.getAdministrativos();
		assertEquals(1, administrativos.size());

		AdministrativoDTO administrativo = administrativos.get(0);
		assertEquals(id, administrativo.getId());
		assertEquals(nombre, administrativo.getNombre());
		assertEquals(cedula, administrativo.getCedula());
		assertEquals(contrasena, administrativo.getContrasena());
	}



	@Test
	void testCreateObject() {
		AdministrativoDAO dao = new AdministrativoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena);

		ArrayList<AdministrativoDTO> administrativos = dao.getAdministrativos();
		assertEquals(1, administrativos.size());

		AdministrativoDTO administrativo = administrativos.get(0);
		assertEquals(id, administrativo.getId());
		assertEquals(nombre, administrativo.getNombre());
		assertEquals(cedula, administrativo.getCedula());
		assertEquals(contrasena, administrativo.getContrasena());
	}

	@Test
	void testReadAll() {
		AdministrativoDAO dao = new AdministrativoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena);

		String result = dao.readAll();
		String expected = "\nNombre:" + nombre + "\nId:" + id + "\nCedula:" + cedula + "\nContrasena:" + contrasena;
		assertEquals(expected, result);
	}

	@Test
	void testUpdateById() {
		AdministrativoDAO dao = new AdministrativoDAO();
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

		ArrayList<AdministrativoDTO> administrativos = dao.getAdministrativos();
		AdministrativoDTO admin = administrativos.get(0);

		assertEquals(id, admin.getId());
		assertEquals(nuevoNombre, admin.getNombre());
		assertEquals(nuevaCedula, admin.getCedula());
		assertEquals(nuevaContrasena, admin.getContrasena());
	}

	@Test
	void testDeleteById() {
		AdministrativoDAO dao = new AdministrativoDAO();
		int id = 1;
		String nombre = "Nombre de prueba";
		long cedula = 1234567890L;
		String contrasena = "Contraseña de prueba";

		dao.create(id, nombre, cedula, contrasena);

		int result = dao.deleteById(id);

		assertEquals(0, result);
		assertEquals(0, dao.getAdministrativos().size());
	}

}
