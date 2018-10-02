package minor;
import java.sql.*;
//import java.util.InputMismatchException;

import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Font;
//import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patentry{

	private JFrame frame;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patentry window = new patentry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection conn=null;
private JTextField ename;
private JTextField eage;
private JTextField econtact;
private JTextField ebg;
private JTextField eadd;
private JTextField egender;
private JTextField eid;

	/**
	 * Create the application.
	 */
	public patentry() {
		initialize();
		//conn=conn.dbConnector();
		/*myconn con= new myconn();
		conn = con.getconn();*/
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 826, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblName.setBounds(130, 61, 157, 24);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblAge.setBounds(130, 116, 157, 24);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblGender.setBounds(130, 171, 157, 24);
		frame.getContentPane().add(lblGender);
		
		JLabel lblContactNo = new JLabel("Contact no.:");
		lblContactNo.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblContactNo.setBounds(130, 219, 157, 24);
		frame.getContentPane().add(lblContactNo);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblBloodGroup.setBounds(130, 269, 167, 24);
		frame.getContentPane().add(lblBloodGroup);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblAddress.setBounds(130, 316, 157, 24);
		frame.getContentPane().add(lblAddress);
		
		ename = new JTextField();
		ename.setBounds(473, 61, 257, 24);
		frame.getContentPane().add(ename);
		ename.setColumns(10);
		
		eage = new JTextField();
		eage.setColumns(10);
		eage.setBounds(473, 117, 257, 24);
		frame.getContentPane().add(eage);
		
		econtact = new JTextField();
		econtact.setColumns(10);
		econtact.setBounds(473, 220, 257, 24);
		frame.getContentPane().add(econtact);
		
		ebg = new JTextField();
		ebg.setColumns(10);
		ebg.setBounds(473, 270, 257, 24);
		frame.getContentPane().add(ebg);
		
		eadd = new JTextField();
		eadd.setColumns(10);
		eadd.setBounds(473, 317, 257, 24);
		frame.getContentPane().add(eadd);
		
		JButton btnSumbit = new JButton("Sumbit");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				myconn con= new myconn();
				conn = con.getconn();
				try{String nam=ename.getText();
					String abc="INSERT INTO patinfo(Name, Age,Gender,Contact1,Bloodgroup,Address,Roomn) VALUES(?,?,?,?,?,?,?)";
					PreparedStatement pst= conn.prepareStatement(abc);
					pst.setString(1, nam); 
					pst.setString(2, eage.getText() );
					pst.setString(3, egender.getText() );
					pst.setString(4, econtact.getText());
					pst.setString(5, ebg.getText());
					pst.setString(6, eadd.getText());
					pst.setString(7, eid.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data saved " );
					
					pst.close();
				} catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}	
				/*catch(InputMismatchException ime){
					JOptionPane.showMessageDialog(null, "Give valid input/Field can't be empty");
					
				}*/
				
			}
		});
		btnSumbit.setFont(new Font("Imprint MT Shadow", Font.BOLD, 19));
		btnSumbit.setBounds(299, 394, 167, 24);
		frame.getContentPane().add(btnSumbit);
		
		JLabel lblPatientsInformation = new JLabel("PATIENT'S INFORMATION");
		lblPatientsInformation.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblPatientsInformation.setBounds(257, 11, 335, 26);
		frame.getContentPane().add(lblPatientsInformation);
		
		egender = new JTextField();
		egender.setBounds(473, 174, 257, 24);
		frame.getContentPane().add(egender);
		egender.setColumns(10);
		
		eid = new JTextField();
		eid.setBounds(473, 362, 257, 24);
		frame.getContentPane().add(eid);
		eid.setColumns(10);
		
		JLabel lblRoomNo = new JLabel("Room No.");
		lblRoomNo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblRoomNo.setBounds(130, 361, 102, 24);
		frame.getContentPane().add(lblRoomNo);
	 }
}
