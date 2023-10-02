package co.edu.unbosque.model;

public class PersonaDeServiciosDTO extends PersonaDTO{
	
	private String salario;
	private int sLimpiada;
	
	public PersonaDeServiciosDTO() {
		super();
	}

	
	public PersonaDeServiciosDTO(int id, String nombre, long cedula, String contrasena, int sLimpiadas, String salario) {
		super(id, nombre, cedula, contrasena);

		this.salario = salario;
		this.sLimpiada = sLimpiada;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public int getsLimpiada() {
		return sLimpiada;
	}

	public void setsLimpiada(int sLimpiada) {
		this.sLimpiada = sLimpiada;
	}
	
	public String toString() {
		return "\nNombre: " + getNombre() + "\nId: " + getId()  + "\nCedula: " + getCedula()
		+ "\n Contraseña: " + getContrasena() + "\nNumero de sesiones limpiadas: " + sLimpiada + "\nSalario: " + salario ;
	}
	
	
	

}
