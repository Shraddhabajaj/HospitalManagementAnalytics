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
import javax.swing.JScrollPane;
//import javax.swing.JComboBox;

public class doc {
	Connection conn=null;
	private JFrame frame;
	private JTextField conpr1;
	private JTextField gdate;
	private JTextField grx;
	private JTextField gmdh;
	private JTextField grecom;
	private JTable stable;
	private JTable table_1;
	private JTextField ph;
	private JTextField docname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc window = new doc();
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
	public doc() {
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
		
		JLabel lblPrescription = new JLabel("PRESCRIPTION");
		lblPrescription.setFont(new Font("Georgia", Font.BOLD, 19));
		lblPrescription.setBounds(376, 11, 172, 25);
		frame.getContentPane().add(lblPrescription);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblDate.setBounds(26, 188, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblContact = new JLabel("Enter room no. :");
		lblContact.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblContact.setBounds(257, 56, 141, 14);
		frame.getContentPane().add(lblContact);
		
		conpr1 = new JTextField();
		conpr1.setBounds(408, 53, 193, 25);
		frame.getContentPane().add(conpr1);
		conpr1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				myconn con= new myconn();
				conn = con.getconn();
				try{
					String srch="SELECT Name,Age,Bloodgroup,Gender, Contact1 FROM patinfo where Roomn=? ";
					PreparedStatement ps= conn.prepareStatement(srch);
					ps.setString(1, conpr1.getText());
					ResultSet rs=ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					/*int count=0;
					while(rs.next())
						{count++;
					
				}
					if(count==1){
						JOptionPane.showMessageDialog(null, "data found");
					}else if(count>1){
						JOptionPane.showMessageDialog(null, "duplicate data found");
					}else
						{
						JOptionPane.showMessageDialog(null, "data not found");
						}*/
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSearch.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnSearch.setBounds(695, 52, 110, 23);
		frame.getContentPane().add(btnSearch);
		
		gdate = new JTextField();
		gdate.setBounds(186, 185, 86, 20);
		frame.getContentPane().add(gdate);
		gdate.setColumns(10);
		
		grx = new JTextField();
		grx.setBounds(186, 283, 666, 44);
		frame.getContentPane().add(grx);
		grx.setColumns(10);
		
		gmdh = new JTextField();
		gmdh.setBounds(186, 347, 666, 44);
		frame.getContentPane().add(gmdh);
		gmdh.setColumns(10);
		
		grecom = new JTextField();
		grecom.setBounds(186, 402, 666, 38);
		frame.getContentPane().add(grecom);
		grecom.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myconn con= new myconn();
				conn = con.getconn();
				try{
					String abc="INSERT INTO doc(Contact1,Date,docname,Rx,medhis,recom) VALUES(?,?,?,?,?,?) ";
					PreparedStatement pst= conn.prepareStatement(abc);
					pst.setString(1, ph.getText());
					pst.setString(2, gdate.getText());
					pst.setString(3, docname.getText());
					pst.setString(4, grx.getText() );
					pst.setString(5, gmdh.getText() );
					pst.setString(6, grecom.getText()); 
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Report entered and saved " );
					
					pst.close();
				} catch(Exception e){
					e.printStackTrace();
					
				}
			}
		});
		btnSubmit.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnSubmit.setBounds(392, 451, 115, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblRx = new JLabel("Rx :");
		lblRx.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblRx.setBounds(26, 298, 46, 14);
		frame.getContentPane().add(lblRx);
		
		JLabel lblAnyMedicalHistory = new JLabel("Any Medical History :");
		lblAnyMedicalHistory.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblAnyMedicalHistory.setBounds(26, 355, 147, 29);
		frame.getContentPane().add(lblAnyMedicalHistory);
		
		JLabel lblRecommendations = new JLabel("Recommendations :");
		lblRecommendations.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblRecommendations.setBounds(26, 414, 131, 14);
		frame.getContentPane().add(lblRecommendations);
		
		stable = new JTable();
		stable.setBounds(53, 106, 1, 1);
		frame.getContentPane().add(stable);
		
		JScrollPane tbl1 = new JScrollPane();
		tbl1.setBounds(10, 111, 842, 63);
		frame.getContentPane().add(tbl1);
		
		table_1 = new JTable();
		tbl1.setViewportView(table_1);
		
		JLabel lblph = new JLabel("Contact:");
		lblph.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblph.setBounds(527, 188, 96, 14);
		frame.getContentPane().add(lblph);
		
		ph = new JTextField();
		ph.setBounds(621, 185, 120, 20);
		frame.getContentPane().add(ph);
		ph.setColumns(10);
		
		JLabel lblDoctorsName = new JLabel("Doctor's Name:");
		lblDoctorsName.setFont(new Font("Californian FB", Font.BOLD, 16));
		lblDoctorsName.setBounds(26, 233, 110, 14);
		frame.getContentPane().add(lblDoctorsName);
		
		docname = new JTextField();
		docname.setBounds(186, 230, 251, 20);
		frame.getContentPane().add(docname);
		docname.setColumns(10);
	}
}
