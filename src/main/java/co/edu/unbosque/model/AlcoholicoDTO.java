package co.edu.unbosque.model;

public class AlcoholicoDTO extends PersonaDTO{

	private int nSesiones;
	private String apodo;
	
	public AlcoholicoDTO() {
		super();
	}

	public AlcoholicoDTO(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena, int nSesiones, String apodo) {
		super(id, nombre, fechaDeNacimiento, cedula, username, contrasena);

		this.nSesiones = nSesiones;
		this.apodo = apodo;
		
	}

	public int getnSesiones() {
		return nSesiones;
	}

	public void setnSesiones(int nSesiones) {
		this.nSesiones = nSesiones;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	@Override
	public String toString() {
		return "\nNombre: " + getNombre() + "\nId: " + getId()  + "\nCedula: " + getCedula()
		+ "\n Contraseña: " + getContrasena() + "\nNumero de sesiones: " + nSesiones + "\nApodo" + apodo ;
	}
	
}
