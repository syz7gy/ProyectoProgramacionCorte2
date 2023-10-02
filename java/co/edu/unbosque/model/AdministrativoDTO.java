package co.edu.unbosque.model;

public class AdministrativoDTO extends PersonaDTO{

	public AdministrativoDTO() {
		super();
	}

	public AdministrativoDTO(int id, String nombre, long cedula, String contrasena) {
		super(id, nombre, cedula, contrasena);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "\nNombre: " + getNombre() + "\nId: " + getId()  + "\nCedula: " + getCedula()
		+ "\n Contraseña: " + getContrasena();
	}
	
	
	
}
