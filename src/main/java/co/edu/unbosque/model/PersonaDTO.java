package co.edu.unbosque.model;

public class PersonaDTO {
	
	private int id;
	private String nombre;
	private long cedula;
	private String contrasena;
	
	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonaDTO(int id, String nombre, long cedula, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
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

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

}
