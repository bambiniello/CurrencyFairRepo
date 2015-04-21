package mf.presentation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

import mf.db.util.ConnManager;
import mf.model.constants.MsgConst;

/**
 * The Class QueryTableModel.
 */
public class QueryTableModel extends AbstractTableModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9126876105101081980L;
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(QueryTableModel.class.getName());

	/** The cache. */
	Vector<String[]> cache; 

	/** The col count. */
	int colCount;

	/** The headers. */
	String[] headers;


	/**
	 * Instantiates a new query table model.
	 */
	public QueryTableModel() {
		cache = new Vector<String[]>();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	public String getColumnName(int i) {
		return headers[i];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return colCount;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		return cache.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int row, int col) {
		return ((String[]) cache.elementAt(row))[col];
	}

	/**
	 * Exec query.
	 */
	public void execQuery() {
		cache = new Vector<String[]>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = ConnManager.getInstance().getConnection();
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from TRADE_MESSAGE order by " + MsgConst.KEY_TIME + " desc;" );

			ResultSetMetaData meta = rs.getMetaData();
			colCount = meta.getColumnCount();

			headers = new String[colCount];
			for (int h = 1; h <= colCount; h++) {
				headers[h - 1] = meta.getColumnName(h);
			}

			while (rs.next()) {
				String[] record = new String[colCount];
				for (int i = 0; i < colCount; i++) {
					record[i] = rs.getString(i + 1);
				}
				cache.addElement(record);
			}
			fireTableChanged(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(stat);
		}
	}

	/**
	 * Close db.
	 *
	 * @param statement the statement
	 */
	public void closeDB(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Could not close the current statement.");
			e.printStackTrace();
		}
	}
}
