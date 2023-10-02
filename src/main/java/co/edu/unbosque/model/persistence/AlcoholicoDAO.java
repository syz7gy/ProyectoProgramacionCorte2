package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.AlcoholicoDTO;
import co.edu.unbosque.util.DBConnection;

public class AlcoholicoDAO {

	private ArrayList<AlcoholicoDTO> alcoholicos;
	private DBConnection dbcon;
	
	public AlcoholicoDAO() {

		alcoholicos = new ArrayList<AlcoholicoDTO>();
		dbcon = new DBConnection();
		
	}

	public ArrayList<AlcoholicoDTO> getAlcoholicos() {
		return alcoholicos;
	}

	public void setAlcoholicos(ArrayList<AlcoholicoDTO> alcoholicos) {
		this.alcoholicos = alcoholicos;
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	public void create(Object o) {

		AlcoholicoDTO temp = (AlcoholicoDTO) o;
		dbcon.initConnection();
		try {

			dbcon.setPrepareStatement(
			dbcon.getConnect().prepareStatement("INSERT INTO alcoholicos VALUES (?, ?, ?, ?, ?, ?, ?, ?);"));
			dbcon.getPrepareStatement().setInt(1, 0);
			dbcon.getPrepareStatement().setString(2, temp.getNombre());
			dbcon.getPrepareStatement().setString(3, temp.getFechaDeNacimiento());
			dbcon.getPrepareStatement().setLong(4, temp.getCedula());
			dbcon.getPrepareStatement().setString(5, temp.getUsername());
			dbcon.getPrepareStatement().setString(6, temp.getContrasena());
			dbcon.getPrepareStatement().setInt(7, temp.getnSesiones());
			dbcon.getPrepareStatement().setString(8, temp.getApodo());
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena, int nSesiones, String apodo) {

		AlcoholicoDTO newAlcoholico = new AlcoholicoDTO(id, nombre, fechaDeNacimiento, cedula, username,contrasena, nSesiones, apodo);
		dbcon.initConnection();
		alcoholicos.add(newAlcoholico);
	}

	public String readAll() {

		String salida = " ";
		alcoholicos.clear();
		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT *FROM alcoholicos;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String nombre = dbcon.getResultSet().getString("nombre");
				long cedula = dbcon.getResultSet().getLong("cedula");
				String contrasena = dbcon.getResultSet().getString("contrasena");
				String apodo = dbcon.getResultSet().getString("apodo");
				int nSesiones = dbcon.getResultSet().getInt("nSesiones");
				String fechaDeNacimiento = dbcon.getResultSet().getString("fechaDeNacimiento");
				String username = dbcon.getResultSet().getString("username");

				alcoholicos.add(new AlcoholicoDTO(id, nombre, fechaDeNacimiento, cedula, contrasena, username, nSesiones, apodo));
			}
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (AlcoholicoDTO comediante : alcoholicos) {
			salida += comediante.toString();
		}

		return salida;
	}

	public int updateById(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena, int nSesiones, String apodo) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement(
					"UPDATE alcoholicos SET id=?, nombre=?, fechaDeNacimiento=?, cedula=?, username=?, contrasena=?, nSesiones=? , apodo=? WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().setString(2, nombre);
			dbcon.getPrepareStatement().setString(3, fechaDeNacimiento);
			dbcon.getPrepareStatement().setLong(4, cedula);
			dbcon.getPrepareStatement().setString(5, username);
			dbcon.getPrepareStatement().setString(6, contrasena);
			dbcon.getPrepareStatement().setInt(7, nSesiones);
			dbcon.getPrepareStatement().setString(8, apodo);
			dbcon.getPrepareStatement().setInt(9, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < alcoholicos.size(); i++) {
			if (alcoholicos.get(i).getId() == id) {
				alcoholicos.get(i).setNombre(nombre);
				alcoholicos.get(i).setFechaDeNacimiento(fechaDeNacimiento);
				alcoholicos.get(i).setCedula(cedula);
				alcoholicos.get(i).setUsername(username);
				alcoholicos.get(i).setContrasena(contrasena);
				alcoholicos.get(i).setApodo(apodo);
				alcoholicos.get(i).setnSesiones(nSesiones);
				return 0;
			}
		}
		return 1;
	}

	public int deleteById(int id) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("DELETE FROM alcoholicos WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < alcoholicos.size(); i++) {
			if (alcoholicos.get(i).getId() == id) {
				alcoholicos.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
}
