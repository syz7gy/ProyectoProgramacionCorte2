package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.util.DBConnection;
import co.edu.unbosque.model.UserDTO;

public class UserDAO implements CRUDOperation<UserDTO> {

	private DBConnection dbcon;
	private ArrayList<UserDTO> usersList;

	public UserDAO() {
		dbcon = new DBConnection();
		usersList = new ArrayList<>();
		usersList.add(new UserDTO(0, "admin", "1234", "salida"));
	}

	@Override
	public void create(String... args) {
		UserDTO newUser = new UserDTO(Integer.parseInt(args[0]), args[1], args[2], args[3]);

		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("INSERT INTO usersList VALUES(?,?,?,?)"));
			dbcon.getPrepareStatement().setInt(1, newUser.getId());
			dbcon.getPrepareStatement().setString(2, newUser.getName());
			dbcon.getPrepareStatement().setString(3, newUser.getUserName());
			dbcon.getPrepareStatement().setString(4, newUser.getPassword());
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {

			e.printStackTrace();

		}
		usersList.add(newUser);

	}

	@Override
	public String readAll() {
		String temp = "";
		usersList.clear();
		try {
			dbcon.initConnection();
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM usersList"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String name = dbcon.getResultSet().getString("nameuser");
				String userName = dbcon.getResultSet().getString("username");
				String password = dbcon.getResultSet().getString("userpassword");
				usersList.add(new UserDTO(id, name, userName, password));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (UserDTO user : usersList) {

			temp += user.toString();

		}
		return temp;
	}

	@Override
	public String readByName(String name) {

		String temp = "";

		for (UserDTO user : usersList) {

			if (user.getName().equals(name)) {
				temp += user.toString();
			}
		}
		return temp;
	}

	@Override
	public int updateById(int id, String... args) {
		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("UPDATE usersList SET id = ?, nameuser = ?, username = ?, userpassword = ? WHERE id = ?"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().setString(2, args[0]);
			dbcon.getPrepareStatement().setString(3, args[1]);
			dbcon.getPrepareStatement().setString(4, args[0]);
			dbcon.getPrepareStatement().setInt(5, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
			return 0;
		} catch (Exception e) {
			return 1;
		}

	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("DELETE FROM usersList WHERE id = ?"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
			return 0;
		} catch (Exception e) {
			return 1;
		}

	}


	String salida = "";

	@Override
	public String readOnly() {
		usersList.forEach((user) -> {
			salida += user.toString() + "\n";
		});
		return salida;
	}

	@Override
	public ArrayList<UserDTO> read() {
		return usersList;
	}

	@Override
	public int update(int index, String... args) {
		if (index < 0) {
			return 1;
		} else if (index >= usersList.size()) {
			return 2;
		} else {
			usersList.get(index).setUserName(args[0]);
			usersList.get(index).setPassword(args[1]);

			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (index < 0) {
			return 1;
		} else if (index >= usersList.size()) {
			return 2;
		} else {
			usersList.remove(index);

			return 0;
		}

	}

	@Override
	public int delete(Object o) {
		if (usersList.remove((UserDTO) o)) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean validate(UserDTO login) {
		for (UserDTO u : usersList) {
			if (u.getUserName().equals(login.getUserName())) {
				if (u.getPassword().equals(login.getPassword())) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public ArrayList<UserDTO> getusersList() {
		return usersList;
	}

	public void setusersList(ArrayList<UserDTO> usersList) {
		this.usersList = usersList;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub
		
	}

}
