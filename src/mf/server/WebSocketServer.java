package mf.server;

import java.io.IOException;

import javax.websocket.DeploymentException;

import org.glassfish.tyrus.server.Server;

/**
 * The Class WebSocketServer.
 */
public class WebSocketServer {

	/**
	 * Run server.
	 *
	 * @return the server
	 * @throws DeploymentException the deployment exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Server runServer() throws DeploymentException, IOException {
		Server server = new Server("localhost", 8025, "/websockets", MessageServerEndpoint.class);
		server.start();
		return server;
	}

}
