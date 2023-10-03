package co.edu.unbosque.model;

public class UserDTO {
	
	private int id;
	private String Name;
	private String userName;
	private String password;

	public UserDTO() {
	}
//autoincrement w3schools
	public UserDTO(int id, String name, String userName, String password) {
		super();
		this.id = id;
		Name = name;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", Name=" + Name + ", userName=" + userName + ", password=" + password + "]";
	}

}
