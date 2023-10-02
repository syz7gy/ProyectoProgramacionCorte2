package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.model.PersonaDTO;
import co.edu.unbosque.util.DBConnection;

public class PersonaDAO {
	
	private ArrayList<PersonaDTO> personas;
	DBConnection dbcon;

	
	public PersonaDAO() {
		dbcon = new DBConnection();
		personas = new ArrayList<PersonaDTO>();
	}


	public ArrayList<PersonaDTO> getPersonas() {
		return personas;
	}


	public void setPersonas(ArrayList<PersonaDTO> personas) {
		this.personas = personas;
	}


	public DBConnection getDbcon() {
		return dbcon;
	}


	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	public void create(Object o) {

		PersonaDTO temp = (PersonaDTO) o;
		dbcon.initConnection();
		try {

			dbcon.setPrepareStatement(
					dbcon.getConnect().prepareStatement("INSERT INTO personas VALUES (?, ?, ?, ?);"));
			dbcon.getPrepareStatement().setInt(1, 0);
			dbcon.getPrepareStatement().setString(2, temp.getNombre());
			dbcon.getPrepareStatement().setLong(3, temp.getCedula());
			dbcon.getPrepareStatement().setString(4, temp.getContrasena());
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(int id, String nombre, long cedula, String nEstudio) {

		PersonaDTO newPersona = new PersonaDTO(id, nombre, cedula, nEstudio);
		dbcon.initConnection();
		personas.add(newPersona);

	}

	public String readAll() {

		String salida = " ";
		personas.clear();
		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT *FROM personas;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String nombre = dbcon.getResultSet().getString("nombre");
				long cedula = dbcon.getResultSet().getLong("cedula");
				String nEstudio = dbcon.getResultSet().getString("nEstudio");

				personas.add(new PersonaDTO(id, nombre, cedula, nEstudio));
			}
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (PersonaDTO user : personas) {
			salida += user.toString();
		}
		return salida;
	}

	public int updateById(int id, String nombre, long cedula, String contrasena) {
		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement(
					"UPDATE personas SET id=?, nombre=?, cedula=?, nEstudio=? WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().setString(2, nombre);
			dbcon.getPrepareStatement().setLong(3, cedula);
			dbcon.getPrepareStatement().setString(4, contrasena);
			dbcon.getPrepareStatement().setInt(5, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getId() == id) {
				personas.get(i).setNombre(nombre);
				personas.get(i).setCedula(cedula);
				personas.get(i).setContrasena(contrasena);
				return 0;
			}
		}
		return 1;
	}

	public int deleteById(int id) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("DELETE FROM personas WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getId() == id) {
				personas.remove(i);
				return 0;
			}
		}
		return 1;
	}
}
