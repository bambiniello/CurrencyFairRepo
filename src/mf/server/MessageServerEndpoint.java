package mf.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import mf.dao.TradeMessageDAO;
import mf.exceptions.InvalidFieldException;
import mf.model.TradeMsg;
import mf.model.TradeMsgDecoder;
import mf.model.TradeMsgEncoder;
import mf.model.validator.TradeMessageValidator;

import org.json.JSONException;
import org.json.JSONObject;
 
/**
 * The Class MessageServerEndpoint.
 */
@ServerEndpoint(value = "/messages", decoders = {TradeMsgDecoder.class}, encoders = {TradeMsgEncoder.class})
public class MessageServerEndpoint {
 
    /** The logger. */
    private Logger logger = Logger.getLogger(this.getClass().getName());
 
    /**
     * On open.
     *
     * @param session the session
     */
    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected ... " + session.getId());
    }
 
    /**
     * On message.
     *
     * @param message the message
     * @param session the session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    	try {
			JSONObject jsonObj = new JSONObject(message);
			TradeMsg modelMsg = TradeMessageValidator.validateTradeMessage(jsonObj);
			
			TradeMessageDAO dao = new TradeMessageDAO();
			logger.log(Level.FINEST, "Saving message: " + jsonObj);
			dao.saveMessage(modelMsg);
		} catch (JSONException e) {
			logger.log(Level.SEVERE, "received message is not a valid JSON", e);
		} catch (InvalidFieldException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
    }
 
    /**
     * On close.
     *
     * @param session the session
     * @param closeReason the close reason
     */
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
}