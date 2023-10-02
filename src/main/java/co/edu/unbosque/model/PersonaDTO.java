package co.edu.unbosque.model;

public class PersonaDTO {
	
	private int id;
	private String nombre;
	private String fechaDeNacimiento;
	private long cedula;
	private String username;
	private String contrasena;
	

	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PersonaDTO(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.cedula = cedula;
		this.username = username;
		this.contrasena = contrasena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	

}
