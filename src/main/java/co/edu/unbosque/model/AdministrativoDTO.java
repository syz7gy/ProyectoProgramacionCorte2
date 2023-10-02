package co.edu.unbosque.model;

public class AdministrativoDTO extends PersonaDTO{

	public AdministrativoDTO() {
		super();
	}

	public AdministrativoDTO(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena) {
		super(id, nombre, fechaDeNacimiento, cedula, username, contrasena);
		
	}
	
	public String toString() {
		return "\nNombre: " + getNombre() + "\nId: " + getId()  + "\nCedula: " + getCedula()
		+ "\n Contraseña: " + getContrasena();
	}
	
	
	
}
