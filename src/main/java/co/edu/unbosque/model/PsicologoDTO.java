package co.edu.unbosque.model;

public class PsicologoDTO extends PersonaDTO{
	
	private String aGraduacion;
	private int dServicio;
	private int sApoyada;
	private String salario;

	public PsicologoDTO() {
		super();
	}

	

	public PsicologoDTO(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena, String aGraduacion, int dServicio, int sApoyada, String salario) {
		super(id, nombre, fechaDeNacimiento, cedula, username, contrasena);

		this.aGraduacion = aGraduacion;
		this.dServicio = dServicio;
		this.sApoyada = sApoyada;
		this.salario = salario;
		
	}



	public String getaGraduacion() {
		return aGraduacion;
	}

	public void setaGraduacion(String aGraduacion) {
		this.aGraduacion = aGraduacion;
	}

	public int getdServicio() {
		return dServicio;
	}

	public void setdServicio(int dServicio) {
		this.dServicio = dServicio;
	}

	public int getsApoyada() {
		return sApoyada;
	}

	public void setsApoyada(int sApoyada) {
		this.sApoyada = sApoyada;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return "\nNombre: " + getNombre() + "\nId: " + getId()  + "\nCedula: " + getCedula() + 
				 "\n Contraseña: " + getContrasena() + "\nNumero de sesiones apoyadas: " + sApoyada + "\nDias en servicio" + dServicio + "\nAño de graduacion: " + aGraduacion +"\nSalario" + salario;
	}
	
	

}
