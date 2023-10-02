package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.model.PsicologoDTO;
import co.edu.unbosque.model.PersonaDTO;
import co.edu.unbosque.util.DBConnection;

public class PsicologoDAO {
	
	private ArrayList<PsicologoDTO> psicologos;
	private DBConnection dbcon;
	
	public PsicologoDAO() {

		psicologos = new ArrayList<PsicologoDTO>();
		dbcon = new DBConnection();
	}

	public ArrayList<PsicologoDTO> getPsicologos() {
		return psicologos;
	}

	public void setPsicologos(ArrayList<PsicologoDTO> psicologos) {
		this.psicologos = psicologos;
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	public void create(Object o) {

		PsicologoDTO temp = (PsicologoDTO) o;
		dbcon.initConnection();
		try {

			dbcon.setPrepareStatement(
			dbcon.getConnect().prepareStatement("INSERT INTO psicologos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"));
			dbcon.getPrepareStatement().setInt(1, 0);
			dbcon.getPrepareStatement().setString(2, temp.getNombre());
			dbcon.getPrepareStatement().setString(3, temp.getFechaDeNacimiento());
			dbcon.getPrepareStatement().setLong(4, temp.getCedula());
			dbcon.getPrepareStatement().setString(5, temp.getUsername());
			dbcon.getPrepareStatement().setString(6, temp.getContrasena());
			dbcon.getPrepareStatement().setInt(7, temp.getdServicio());
			dbcon.getPrepareStatement().setInt(8, temp.getsApoyada());
			dbcon.getPrepareStatement().setString(9, temp.getaGraduacion());
			dbcon.getPrepareStatement().setString(10, temp.getSalario());
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena, String aGraduacion, int dServicio, int sApoyada, String salario) {

		PsicologoDTO newComediante = new PsicologoDTO(id, nombre, fechaDeNacimiento, cedula, username, contrasena, aGraduacion, dServicio, sApoyada, salario);
		dbcon.initConnection();
		psicologos.add(newComediante);
	}

	public String readAll() {

		String salida = " ";
		psicologos.clear();
		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT *FROM psicologos;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String nombre = dbcon.getResultSet().getString("nombre");
				long cedula = dbcon.getResultSet().getLong("cedula");
				String contrasena = dbcon.getResultSet().getString("contrasena");
				String aGraduacion = dbcon.getResultSet().getString("aGraduacion");
				String salario = dbcon.getResultSet().getString("salario");
				String fechaDeNacimiento = dbcon.getResultSet().getString("fechaDeNacimiento");
				String username = dbcon.getResultSet().getString("username");
				int dServicio = dbcon.getResultSet().getInt("dServicio");
				int sApoyada = dbcon.getResultSet().getInt("sApoyada");
				

				psicologos.add(new PsicologoDTO(id, nombre, fechaDeNacimiento,cedula, username,contrasena,aGraduacion,dServicio,sApoyada, salario));
			}
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (PsicologoDTO comediante : psicologos) {
			salida += comediante.toString();
		}

		return salida;
	}

	public int updateById(int id, String nombre, String fechaDeNacimiento, long cedula, String username,
			String contrasena, String aGraduacion, int dServicio, int sApoyada, String salario) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement(
					"UPDATE psicologos SET id=?, nombre=?, fechaDeNacimiento=?, cedula=?, username=?,contrasena=?, aGraduacion=? , dServicio=?, sApoyada=?, salario=? WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().setString(2, nombre);
			dbcon.getPrepareStatement().setString(3, fechaDeNacimiento);
			dbcon.getPrepareStatement().setLong(4, cedula);
			dbcon.getPrepareStatement().setString(5, username);
			dbcon.getPrepareStatement().setString(6, contrasena);
			dbcon.getPrepareStatement().setInt(7, dServicio);
			dbcon.getPrepareStatement().setInt(8, sApoyada);
			dbcon.getPrepareStatement().setString(9, aGraduacion);
			dbcon.getPrepareStatement().setString(10, salario);
			dbcon.getPrepareStatement().setInt(11, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < psicologos.size(); i++) {
			if (psicologos.get(i).getId() == id) {
				psicologos.get(i).setNombre(nombre);
				psicologos.get(i).setFechaDeNacimiento(fechaDeNacimiento);
				psicologos.get(i).setCedula(cedula);
				psicologos.get(i).setUsername(username);
				psicologos.get(i).setContrasena(contrasena);
				psicologos.get(i).setaGraduacion(aGraduacion);
				psicologos.get(i).setdServicio(dServicio);
				psicologos.get(i).setsApoyada(sApoyada);
				psicologos.get(i).setSalario(salario);
				
				return 0;
			}
		}
		return 1;
	}

	public int deleteById(int id) {

		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("DELETE FROM psicologos WHERE id=?;"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < psicologos.size(); i++) {
			if (psicologos.get(i).getId() == id) {
				psicologos.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
	
}
