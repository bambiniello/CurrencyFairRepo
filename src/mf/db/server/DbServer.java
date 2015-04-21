package mf.db.server;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.h2.tools.Server;

/**
 * The Class DbServer.
 */
public class DbServer {

	/** The logger. */
	private static Logger logger = Logger.getLogger(DbServer.class.getName());

	/**
	 * Run server.
	 *
	 * @return the server
	 * @throws SQLException the sQL exception
	 */
	public static Server runServer() throws SQLException {
		Server result = null;
		logger.log(Level.INFO,"Starting h2 db server....");
		result = Server.createTcpServer().start();
		logger.log(Level.INFO,"Started !");

		return result;
	}


}
