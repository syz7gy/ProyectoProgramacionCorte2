import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.PersonaDTO;

class AdministrativoDTOTest {
	private static int counter = 0;

	public static void start(String name) {
		System.out.println("\n test called: " + name + ", number: " + counter + " starting");
	}

	@BeforeAll

	public static void banner() {

		System.err.println("\n______________ Starting all ParticipantDTO unit tests _____________");

	}
	@Test
	void testAdministrativoDTO() {
		start("constructor AdministrativoDTO");
		counter++;
		int id =1;
		String nombre = "test";
		Long cedula =  0000000000L;
		String contrasena ="1234";
		
		PersonaDTO aux= new PersonaDTO(id, nombre,cedula,contrasena);
		assertEquals(aux, aux);
	}
	@Test
	void testToString() {
		start("constructor");
		counter++;
AdministrativoDTO admin = new AdministrativoDTO();
admin.setId(1);
admin.setNombre("berni");
admin.setCedula(1L);
admin.setContrasena("patos");
		
		String aux= "\nNombre: " + admin.getNombre() + "\nId: " + admin.getId()  + "\nCedula: " + admin.getCedula()
		+ "\n Contraseña: " + admin.getContrasena();
		assertEquals(aux, admin.toString());
	}
}
