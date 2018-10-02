package minor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
//import javax.swing.JScrollPane;
//import javax.swing.JComboBox;
//import javax.swing.JComboBox;

public class phar {
	Connection conn=null;
	
	/*JTable jt;
	String[] col = {"Medicines","Qty","Price"};
	String[] info = {"Select Rx from doc","",""};*/
	private JFrame frame;
	private JTable stable;
	private JTextField patname;
	private JTextField ref;
	private JTextField date;
	private JTextField conpr1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phar window = new phar();
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
	public phar() {
		initialize();
		
		//conn=connection1.dbConnector();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 878, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\kaamkichiz\\SRM-University-,SRMJEEE.jpg"));
		lblNewLabel.setBounds(10, 11, 219, 84);
		frame.getContentPane().add(lblNewLabel);
		
		stable = new JTable();
		stable.setBounds(53, 106, 1, 1);
		frame.getContentPane().add(stable);
		
		JLabel lblPharmacy = new JLabel("PHARMACY");
		lblPharmacy.setFont(new Font("Georgia", Font.BOLD, 30));
		lblPharmacy.setBounds(351, 30, 296, 46);
		frame.getContentPane().add(lblPharmacy);
		
		JLabel lblPatientsName = new JLabel("Patient's Name:");
		lblPatientsName.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblPatientsName.setBounds(53, 118, 129, 24);
		frame.getContentPane().add(lblPatientsName);
		
		JLabel lblReferredBy = new JLabel("Referred By:");
		lblReferredBy.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblReferredBy.setBounds(53, 153, 129, 20);
		frame.getContentPane().add(lblReferredBy);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblDate.setBounds(628, 118, 46, 24);
		frame.getContentPane().add(lblDate);
		
		JLabel lblMedicines = new JLabel("Medicines:");
		lblMedicines.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblMedicines.setBounds(53, 197, 119, 24);
		frame.getContentPane().add(lblMedicines);
		
		JLabel label = new JLabel("");
		label.setBounds(628, 159, 46, 14);
		frame.getContentPane().add(label);
		
		patname = new JTextField();
		patname.setBounds(171, 120, 219, 20);
		frame.getContentPane().add(patname);
		patname.setColumns(10);
		
		ref = new JTextField();
		ref.setBounds(171, 153, 219, 20);
		frame.getContentPane().add(ref);
		ref.setColumns(10);
		
		date = new JTextField();
		date.setBounds(684, 120, 119, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		JButton btnCheckMedicines = new JButton("Check medicines");
		btnCheckMedicines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//jt= new JTable(col,info);
				myconn con= new myconn();
				conn = con.getconn();
				try{
					
					String src="SELECT Rx, qty FROM doc where Contact1=? ";
					PreparedStatement pst= conn.prepareStatement(src);
					pst.setString(1, conpr1.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			
			}
		});
		btnCheckMedicines.setBounds(559, 198, 119, 23);
		frame.getContentPane().add(btnCheckMedicines);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblContact.setBounds(601, 156, 73, 14);
		frame.getContentPane().add(lblContact);
		
		conpr1 = new JTextField();
		conpr1.setBounds(684, 153, 119, 20);
		frame.getContentPane().add(conpr1);
		conpr1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myconn con= new myconn();
				conn = con.getconn();
				try{
					String abc="INSERT INTO phar(name,date, ref, contact) VALUES(?,?,?,?) ";
					PreparedStatement pst= conn.prepareStatement(abc);
					pst.setString(1, patname.getText());
					pst.setString(2, date.getText());
					pst.setString(3, ref.getText());
					pst.setString(4, conpr1.getText() );
					//pst.setString(5, gmdh.getText() );
					//pst.setString(6, grecom.getText()); 
					pst.execute();
					JOptionPane.showMessageDialog(null, "Report entered and saved " );
					
					pst.close();
				} catch(Exception e){
					e.printStackTrace();
					
				}
			}
		});
		btnSubmit.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnSubmit.setBounds(351, 433, 174, 23);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
