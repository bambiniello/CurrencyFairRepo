package mf.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class ConnManager.
 */
public class ConnManager {

	/** The singleton instance. */
	private static ConnManager instance = null;
	
	/** The connection. */
	private static Connection conn = null;

	/**
	 * Instantiates a new connection manager.
	 */
	private ConnManager() {
	}

	/**
	 * Gets the single instance of ConnManager.
	 *
	 * @return single instance of ConnManager
	 */
	public static ConnManager getInstance() {
		if (instance == null) {
			instance = new ConnManager();
		}
		return instance;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException the sQL exception
	 */
	public Connection getConnection() throws SQLException {
		if (conn == null) {
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.
						getConnection("jdbc:h2:tcp://localhost/~/h2db/currencyDb", "sa", "");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * Close connection.
	 */
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		conn = null;
	}

}
