package mf.presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * The Class PresentationMessages.
 */
public class PresentationMessages extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7341770435734305200L;

	/** The qtm. */
	private QueryTableModel qtm;

	/**
	 * Instantiates a new presentation messages.
	 */
	public PresentationMessages() {
		super("Database Test Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 200);

		qtm = new QueryTableModel();
		JTable table = new JTable(qtm);
		JScrollPane scrollpane = new JScrollPane(table);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 2));
		JButton jb = new JButton("Refresh");
		p1.add(jb);
		
		jb.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        qtm.execQuery();
		      }
		    });
		getContentPane().add(p1, BorderLayout.NORTH);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		
		qtm.execQuery();
		
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		PresentationMessages tt = new PresentationMessages();
		tt.setVisible(true);
	}
}
