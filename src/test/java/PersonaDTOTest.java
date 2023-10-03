import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import co.edu.unbosque.model.PersonaDTO;

public class PersonaDTOTest {
	private static int counter = 0;

	public static void start(String name) {
		System.out.println("\n test called: " + name + ", number: " + counter + " starting");
	}

	@BeforeAll

	public static void banner() {

		System.err.println("\n______________ Starting all ParticipantDTO unit tests _____________");

	}

	@Test
	public void testPersonaDTO() {
		start("Constructor PersonaDTO");
		counter++;
		int id =1;
		String nombre = "test";
		Long cedula =  0000000000L;
		String contrasena ="1234";
		
		PersonaDTO aux= new PersonaDTO(id, nombre,cedula,contrasena);
		assertEquals(aux, aux);
	}

	@Test
	public void testGetId() {
		start("getId");
		counter++;
		int id =1;
		String nombre = "test";
		Long cedula =  0000000000L;
		String contrasena ="1234";
		
		PersonaDTO aux= new PersonaDTO(id, nombre,cedula,contrasena);
		assertEquals(1, aux.getId());
	}

	@Test
	public void testGetNombre() {
		start("getNombre");
		counter++;
		int id =1;
		String nombre = "test";
		Long cedula =  0000000000L;
		String contrasena ="1234";
		
		PersonaDTO aux= new PersonaDTO(id, nombre,cedula,contrasena);
		assertEquals("test", aux.getNombre());
	}

	@Test
	public void testGetCedula() {
		start("getCedula");
		counter++;
		int id =1;
		String nombre = "test";
		Long cedula =  0000000000L;
		String contrasena ="1234";
		
		PersonaDTO aux= new PersonaDTO(id, nombre,cedula,contrasena);
		assertEquals(0000000000L, aux.getCedula());
	}

	@Test
	public void testGetContrasena() {
		start("getContrasena");
		counter++;
		int id =1;
		String nombre = "test";
		Long cedula =  0000000000L;
		String contrasena ="1234";
		
		PersonaDTO aux= new PersonaDTO(id, nombre,cedula,contrasena);
		assertEquals("1234", aux.getContrasena());
	}

}
