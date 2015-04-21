package mf.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.websocket.DeploymentException;

import mf.db.server.DbServer;
import mf.server.WebSocketServer;

import org.h2.tools.Server;

/**
 * The Class MainClass. Starts the DB Server and the WebSocketServer.
 */
public class MainClass {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Server dbServer = null;
		org.glassfish.tyrus.server.Server webSocketServer = null;
		try {
			// Starting Database Server.
			dbServer = DbServer.runServer();

			// Starting Web Socket Server
			webSocketServer = WebSocketServer.runServer();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please press a key to stop the server.");
			reader.readLine();
		} catch (SQLException | IOException | DeploymentException  e) {
			e.printStackTrace();
		} finally {
			stopApplication(dbServer, webSocketServer);
		}

	}

	/**
	 * Stop application.
	 *
	 * @param dbServer the db server
	 * @param webSocketServer the web socket server
	 */
	private static void stopApplication(Server dbServer, org.glassfish.tyrus.server.Server webSocketServer) {
		if (dbServer != null) {
			dbServer.stop();
		}
		if (webSocketServer != null) {
			webSocketServer.stop();
		}

	}

}
