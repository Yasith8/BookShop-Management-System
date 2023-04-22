package guiprogramming.bookshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BookShopForm {

	private JFrame frame;
	private JTextField txtAuthor;
	private JTextField txtBook;
	private JTextField txtEditionYear;
	private JTextField txtBookPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookShopForm window = new BookShopForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private BookDao daoBook;
	private JTable table;
	
	
	public BookShopForm() {
		daoBook = new BookDao();
		initialize();
		loadTable();
		
	}
	
	public void clearForm() {
		
		txtAuthor.setText("");
		txtBook.setText("");
		txtEditionYear.setText(""); 
		txtBookPrice.setText("");
	}

	public void loadTable() {
		ResultSet rs = daoBook.loadTableData();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("Book Shop Management ");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegistration.setBounds(224, 10, 501, 49);
		frame.getContentPane().add(lblRegistration);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 70, 343, 419);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBook = new JLabel("Book Name : ");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBook.setBounds(20, 98, 118, 25);
		panel.add(lblBook);
		
		txtAuthor = new JTextField();
		txtAuthor.setBounds(130, 55, 203, 24);
		panel.add(txtAuthor);
		txtAuthor.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author Name : ");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAuthor.setBounds(20, 52, 118, 25);
		panel.add(lblAuthor);
		
		txtBook = new JTextField();
		txtBook.setColumns(10);
		txtBook.setBounds(130, 99, 203, 24);
		panel.add(txtBook);
		
		JLabel lblEditionYear = new JLabel("Edition Year : ");
		lblEditionYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEditionYear.setBounds(20, 145, 118, 25);
		panel.add(lblEditionYear);
		
		txtEditionYear = new JTextField();
		txtEditionYear.setColumns(10);
		txtEditionYear.setBounds(130, 146, 203, 24);
		panel.add(txtEditionYear);
		
		JLabel lblBookPrice = new JLabel("Book Price : ");
		lblBookPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookPrice.setBounds(20, 198, 118, 25);
		panel.add(lblBookPrice);
		
		txtBookPrice = new JTextField();
		txtBookPrice.setColumns(10);
		txtBookPrice.setBounds(130, 198, 203, 24);
		panel.add(txtBookPrice);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String author =  txtAuthor.getText();
				String book = txtBook.getText();
				String edition = txtEditionYear.getText();
				String price = txtBookPrice.getText();
				
				BookEntity bookObject = new BookEntity(author,book,edition,price); 
				daoBook.insertBook(bookObject);
				
				
				loadTable();
				clearForm();
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBounds(25, 288, 135, 58);
		panel.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(183, 288, 135, 58);
		panel.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 69, 516, 347);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.setBounds(100, 100, 914, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
