package co.edu.unbosque.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBConnectionTest {

	private DBConnection dbConnection;
	
	@BeforeEach
	public void setUp() {
		dbConnection = new DBConnection();
	}
	@Test
	void testInitConnection() {
		dbConnection.initConnection();
		assertNotNull(dbConnection.getConnect());
	}

	@AfterEach
	public void tearDown() {
		dbConnection.closeConnection();
	}


}
