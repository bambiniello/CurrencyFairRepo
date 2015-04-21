package mf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import mf.db.util.ConnManager;
import mf.model.TradeMsg;
import mf.model.constants.MsgConst;

/**
 * The Class TradeMessageDAO.
 */
public class TradeMessageDAO {

	/** The Constant INSERT_TRADE_MESSAGE. */
	private static final String INSERT_TRADE_MESSAGE = "insert into TRADE_MESSAGE (" +
			MsgConst.KEY_USER_ID + "," +
			MsgConst.KEY_FROM + "," +
			MsgConst.KEY_TO + "," +
			MsgConst.KEY_SELL + "," +
			MsgConst.KEY_BUY + "," +
			MsgConst.KEY_RATE + "," +
			MsgConst.KEY_TIME + "," +
			MsgConst.KEY_COUNTRY +
			")" +
			"values(?,?,?,?,?,?,?,?)";
	
	/**
	 * Save message.
	 *
	 * @param msg the msg
	 */
	public void saveMessage(TradeMsg msg) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			
			conn = ConnManager.getInstance().getConnection();
			if (conn != null) {
				
				stat = conn.prepareStatement(INSERT_TRADE_MESSAGE);
				stat.setLong(1, msg.getUserId());
				stat.setString(2, msg.getCurrencyFrom());
				stat.setString(3, msg.getCurrencyTo());
				stat.setDouble(4, msg.getAmountSell());
				stat.setDouble(5, msg.getAmountBuy());
				stat.setDouble(6, msg.getRate());
				stat.setDate(7, new Date(msg.getTimePlaced().getTime()));
				stat.setString(8, msg.getOriginatingCountry());
				stat.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stat);
			ConnManager.getInstance().closeConnection();
		}
		
	}
	
	/**
	 * Close the statement.
	 *
	 * @param stat the statement to close
	 */
	private void close(Statement stat) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
