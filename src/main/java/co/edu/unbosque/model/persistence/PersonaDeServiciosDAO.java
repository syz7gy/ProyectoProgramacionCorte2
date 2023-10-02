package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.model.PersonaDeServiciosDTO;
import co.edu.unbosque.model.PersonaDeServiciosDTO;
import co.edu.unbosque.util.DBConnection;

public class PersonaDeServiciosDAO {

	private ArrayList<PersonaDeServiciosDTO> pServicios;
	private DBConnection dbcon;
	
	public PersonaDeServiciosDAO() {

		pServicios = new ArrayList<PersonaDeServiciosDTO>();
		dbcon = new DBConnection();
	}

	public ArrayList<PersonaDeServiciosDTO> getpServicios() {
		return pServicios;
	}

	public void setpServicios(ArrayList<PersonaDeServiciosDTO> pServicios) {
		this.pServicios = pServicios;
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	public void create(Object o) {

		PersonaDeServiciosDTO temp = (PersonaDeServiciosDTO) o;
		dbcon.initConnection();
		try {

			dbcon.setPrepareStatement(
			dbcon.getConnect().prepareStatement("INSERT INTO pServicios VALUES (?, ?, ?, ?, ?, ?);"));
			dbcon.getPrepareStatement().setInt(1, 0);
			dbcon.getPrepareStatement().setString(2, temp.getNombre());
			dbcon.getPrepareStatement().setLong(3, temp.getCedula());
			dbcon.getPrepareStatement().setString(4, temp.getContrasena());
			dbcon.getPrepareStatement().setInt(5, temp.getsLimpiada());
			dbcon.getPrepareStatement().setString(6, temp.getSalario());
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(int id, String nombre, long cedula, String contrasena, int sLimpiada, String salario) {

		PersonaDeServiciosDTO newPersonaDeServicio = new PersonaDeServiciosDTO(id, nombre, cedula, contrasena,sLimpiada, salario);
		dbcon.initConnection();
		pServicios.add(newPersonaDeServicio);
	}

	public String readAll() {

		String salida = " ";
		pServicios.clear();
		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT *FROM pServicios;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String nombre = dbcon.getResultSet().getString("nombre");
				long cedula = dbcon.getResultSet().getLong("cedula");
				String contrasena = dbcon.getResultSet().getString("contrasena");
				String salario = dbcon.getResultSet().getString("salario");
				int sLimpiadas = dbcon.getResultSet().getInt("sApoyada");

				pServicios.add(new PersonaDeServiciosDTO(id, nombre, cedula, contrasena,sLimpiadas, salario));
			}
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (PersonaDeServiciosDTO pServicios : pServicios) {
			salida += pServicios.toString();
		}

		return salida;
	}

	public int updateById(int id, String nombre, long cedula, String contrasena, int sLimpiadas, String salario) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement(
			"UPDATE pServicios SET id=?, nombre=?, cedula=?, contrasena=?, dServicio=?, salario=? WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().setString(2, nombre);
			dbcon.getPrepareStatement().setLong(3, cedula);
			dbcon.getPrepareStatement().setString(4, contrasena);
			dbcon.getPrepareStatement().setInt(5, sLimpiadas);
			dbcon.getPrepareStatement().setString(6, salario);
			dbcon.getPrepareStatement().setInt(7, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pServicios.size(); i++) {
			if (pServicios.get(i).getId() == id) {
				pServicios.get(i).setNombre(nombre);
				pServicios.get(i).setCedula(cedula);
				pServicios.get(i).setContrasena(contrasena);
				pServicios.get(i).setsLimpiada(sLimpiadas);
				pServicios.get(i).setSalario(salario);
				
				return 0;
			}
		}
		return 1;
	}

	public int deleteById(int id) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("DELETE FROM pServicios WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < pServicios.size(); i++) {
			if (pServicios.get(i).getId() == id) {
				pServicios.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
}
