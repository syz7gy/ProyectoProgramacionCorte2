package co.edu.unbosque.model.persistence.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UserDAO;

class UserDAOTest {

	@Test
	public void testCreate() {
		UserDAO dao = new UserDAO();
		dao.create("1", "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		String result = dao.readAll();
		assertTrue(result.contains("Nombre de prueba"));
	}

	@Test
	public void testReadByName() {
		UserDAO dao = new UserDAO();
		dao.create("1", "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		String result = dao.readByName("Nombre de prueba");
		assertTrue(result.contains("Nombre de prueba"));
	}

	@Test
	public void testUpdateById() {
		UserDAO dao = new UserDAO();
		dao.create("1", "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		dao.updateById(1, "Nuevo nombre", "Nuevo usuario", "Nueva contraseña");
		String result = dao.readAll();
		assertTrue(result.contains("Nuevo nombre"));
	}

	@Test
	public void testDeleteById() {
		UserDAO dao = new UserDAO();
		dao.create("1", "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		dao.deleteById(1);
		String result = dao.readAll();
		assertTrue(!result.contains("Nombre de prueba"));
	}

	@Test
	void testUpdate() {
		UserDAO dao = new UserDAO();
		UserDTO user = new UserDTO(1, "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		dao.create(user);
		dao.update(0, "Nuevo usuario", "Nueva contraseña");
		String result = dao.readOnly();
		assertTrue(result.contains("Nuevo usuario"));

	}

	@Test
	void testDelete() {
		UserDAO dao = new UserDAO();
		UserDTO user = new UserDTO(1, "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		dao.create(user);
		dao.delete(0);
		String result = dao.readOnly();
		assertTrue(!result.contains("Nombre de prueba"));

	}

	@Test
	void testValidate() {
		UserDAO dao = new UserDAO();
		UserDTO user = new UserDTO(1, "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		dao.create(user);
		boolean result = dao.validate(new UserDTO(1, "", "Usuario de prueba", "Contraseña de prueba"));
		assertTrue(result);

	}

	@Test
	void testCreateObject() {
		UserDAO dao = new UserDAO();
		UserDTO user = new UserDTO(1, "Nombre de prueba", "Usuario de prueba", "Contraseña de prueba");
		dao.create(user);
		String result = dao.readOnly();
		assertTrue(result.contains("Nombre de prueba"));

	}

}
