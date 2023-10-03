package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.model.AdministrativoDTO;
import co.edu.unbosque.model.PersonaDeServiciosDTO;
import co.edu.unbosque.util.DBConnection;

public class AdministrativoDAO {

	private ArrayList<AdministrativoDTO> administrativos;
	private DBConnection dbcon;

	public AdministrativoDAO() {

		administrativos = new ArrayList<AdministrativoDTO>();
		dbcon = new DBConnection();

	}

	public ArrayList<AdministrativoDTO> getAdministrativos() {
		return administrativos;
	}

	public void setAdministrativos(ArrayList<AdministrativoDTO> administrativos) {
		this.administrativos = administrativos;
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public void create(Object o) {

		AdministrativoDTO temp = (AdministrativoDTO) o;
		dbcon.initConnection();
		try {

			dbcon.setPrepareStatement(
					dbcon.getConnect().prepareStatement("INSERT INTO administrativos VALUES (?, ?, ?, ?);"));
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

	public void create(int id, String nombre, long cedula, String contrasena) {

		AdministrativoDTO newAdministrativo = new AdministrativoDTO(id, nombre, cedula, contrasena);
		dbcon.initConnection();
		administrativos.add(newAdministrativo);
	}

	public String readAll() {

		String salida = " ";
		administrativos.clear();
		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT *FROM administrativos;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String nombre = dbcon.getResultSet().getString("nombre");
				long cedula = dbcon.getResultSet().getLong("cedula");
				String contrasena = dbcon.getResultSet().getString("contrasena");

				administrativos.add(new AdministrativoDTO(id, nombre, cedula, contrasena));
			}
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (AdministrativoDTO administrativos : administrativos) {
			salida += administrativos.toString();
		}

		return salida;
	}

	public int updateById(int id, String nombre, long cedula, String contrasena) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect()
					.prepareStatement("UPDATE administrativos SET id=?, nombre=?, cedula=?, contrasena=? WHERE id=?;"));
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
		for (int i = 0; i < administrativos.size(); i++) {
			if (administrativos.get(i).getId() == id) {
				administrativos.get(i).setNombre(nombre);
				administrativos.get(i).setCedula(cedula);
				administrativos.get(i).setContrasena(contrasena);

				return 0;
			}
		}
		return 1;
	}

	public int deleteById(int id) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("DELETE FROM administrativos WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < administrativos.size(); i++) {
			if (administrativos.get(i).getId() == id) {
				administrativos.remove(i);
				return 0;
			}
		}
		return 1;
	}

}
