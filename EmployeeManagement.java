package cce103;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class EmployeeManagement {
	public EmployeeManagement ( ) {
		JFrame frame = new JFrame("Employee Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(800, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(frame);
		frame.setLayout(null);
		
		File f = new File("Data.txt");
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String [] columns = {"Employee ID","Fullname","Age","Date of Birth","Nationality","Contact Number","Email","Department","Job Title"};
		Object [][] data = {{"","","","","","","","","","","","",""}};
		DefaultTableModel model = new DefaultTableModel(data, columns);
		JTable table = new JTable(model);
		JScrollPane  scroll = new JScrollPane(table);
		scroll.setBounds(25, 240, 735, 200);
		frame.add(scroll);
		
		JLabel title = new JLabel("EMS Inc.");
		frame.add(title);
		title.setBounds(25, -45, 150, 150);
		
		JLabel id = new JLabel("Employee ID");
		frame.add(id);
		id.setBounds(25,55,150,25);
		JTextField txtID = new JTextField();
		frame.add(txtID);
		txtID.setBounds(25,80,160,20);
		
		
		JLabel name = new JLabel("Fullname");
		frame.add(name);
		name.setBounds(25,110,150,25);
		JTextField txtName = new JTextField();
		frame.add(txtName);
		txtName.setBounds(25,130,150,20);
		
		JLabel birth = new JLabel("Date of Birth");
		frame.add(birth);
		birth.setBounds(25,160,150,20);
		JTextField txtBirth = new JTextField();
		frame.add(txtBirth);
		txtBirth.setBounds(25,180,150,20);
		
		JLabel age = new JLabel("Age");
		frame.add(age);
		age.setBounds(200,55,150,25);
		JTextField txtAge = new JTextField();
		frame.add(txtAge);
		txtAge.setBounds(200,80,150,20);
		
		JLabel status = new JLabel("Civil Status");
		frame.add(status);
		status.setBounds(200,110,150,25);
	//	JTextField txtStat = new JTextField();
	//	frame.add(txtAge);
	//	txtAge.setBounds(220,80,150,25);
		
		JLabel nation = new JLabel("Nationality");
		frame.add(nation);
		nation.setBounds(200,160,150,25);
		JTextField txtNation = new JTextField();
		frame.add(txtNation);
		txtNation.setBounds(200,180,150,20);
		
		JLabel gender = new JLabel("Gender");
		frame.add(gender);
		gender.setBounds(375,55,150,25);
	//	JTextField txtGender = new JTextField();
	//	frame.add(txtGender);
	//	txtGender.setBounds(375,80,150,25);
		
		JLabel no = new JLabel("Contact Number");
		frame.add(no);
		no.setBounds(375,110,150,25);
		JTextField txtNum = new JTextField();
		frame.add(txtNum);
		txtNum.setBounds(375,130,150,20);
		
		JLabel email = new JLabel("Email");
		frame.add(email);
		email.setBounds(375,160,150,25);
		JTextField txtEmail = new JTextField();
		frame.add(txtEmail);
		txtEmail.setBounds(375,180,150,20);
		
		JLabel dept = new JLabel("Department");
		frame.add(dept);
		dept.setBounds(550,110,150,25);
		JTextField txtDept = new JTextField();
		frame.add(txtDept);
		txtDept.setBounds(550,130,150,20);
		
		JLabel pos = new JLabel("Job Title / Position");
		frame.add(pos);
		pos.setBounds(550,160,150,25);
		JTextField txtPos = new JTextField();
		frame.add(txtPos);
		txtPos.setBounds(550,180,150,20);
	}
	public static void main(String[] args) {
			new EmployeeManagement();

	}

}
