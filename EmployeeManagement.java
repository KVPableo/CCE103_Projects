package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
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
		
		
		File f = new File("Employee.txt");
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		String [] columns = {"Employee ID","Fullname","Age","Date of Birth","Nationality","Gender","Contact Number","Email","Department","Job Title / Position"};
		Object [][] data = {{}};
		DefaultTableModel model = new DefaultTableModel(data, columns);
		JTable table = new JTable(model);
		JScrollPane  scroll = new JScrollPane(table);
		table.setEnabled(false);
		scroll.setBounds(25, 240, 735, 200);
		frame.add(scroll);
		model.setRowCount(25);
		try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] dataRow = line.split("#"); 
		        model.addRow(dataRow);
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
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
		name.setBounds(25,100,150,25);
		JTextField txtName = new JTextField();
		frame.add(txtName);
		txtName.setBounds(25,125,160,20);
		
		JLabel birth = new JLabel("Date of Birth");
		frame.add(birth);
		birth.setBounds(25,145,150,20);
		JTextField txtBirth = new JTextField();
		frame.add(txtBirth);
		txtBirth.setBounds(25,170,160,20);
		
		JLabel age = new JLabel("Age");
		frame.add(age);
		age.setBounds(215,55,150,25);
		JTextField txtAge = new JTextField();
		frame.add(txtAge);
		txtAge.setBounds(215,80,160,20);
		
		JLabel status = new JLabel("Civil Status");
		frame.add(status);
		status.setBounds(215,100,150,25);
		String [] civil = {"Single","Married","Widowed","Separated","Divorced"};
		JComboBox civilStat = new JComboBox(civil);
		frame.add(civilStat);
		civilStat.setBounds(215,125,160,20);
		
		
		
		JLabel nation = new JLabel("Nationality");
		frame.add(nation);
		nation.setBounds(215,145,150,25);
		JTextField txtNation = new JTextField();
		frame.add(txtNation);
		txtNation.setBounds(215,170,160,20);
		
		JLabel gender = new JLabel("Gender");
		frame.add(gender);
		gender.setBounds(405,55,150,25);
		String genderpick = "";
		JRadioButton m = new JRadioButton("Male");	
		JRadioButton fm = new JRadioButton("Female");	
		ButtonGroup group = new ButtonGroup();
		group.add(m);
		group.add(fm);
		frame.add(m);
		frame.add(fm);
		m.setBounds(405,76,60,25);
		fm.setBounds(465,76,80,25);
		
		JLabel no = new JLabel("Contact Number");
		frame.add(no);
		no.setBounds(405,100,150,25);
		JTextField txtNum = new JTextField();
		frame.add(txtNum);
		txtNum.setBounds(405,125,160,20);
		
		JLabel email = new JLabel("Email");
		frame.add(email);
		email.setBounds(405,145,150,25);
		JTextField txtEmail = new JTextField();
		frame.add(txtEmail);
		txtEmail.setBounds(405,170,160,20);
		
		JLabel dept = new JLabel("Department");
		frame.add(dept);
		dept.setBounds(595,100,150,25);
		JTextField txtDept = new JTextField();
		frame.add(txtDept);
		txtDept.setBounds(595,125,160,20);
		
		JLabel pos = new JLabel("Job Title / Position");
		frame.add(pos);
		pos.setBounds(595,145,150,25);
		JTextField txtPos = new JTextField();
		frame.add(txtPos);
		txtPos.setBounds(595,170,160,20);
		
		JButton btnAdd = new JButton("Add Employee");
		frame.add(btnAdd);
		btnAdd.setBounds(615,203,120,25);
		btnAdd.addActionListener(e ->{
			String genderFinal = "";
			if (m.isSelected()) {
			 genderFinal = "Male";
			}
			else if (fm.isSelected()) {
			genderFinal = "Female";
			}
				
			try {
				FileWriter fw = new FileWriter(f, true);
				fw.write(System.lineSeparator()+txtID.getText()+"#"+txtName.getText()+"#"+txtAge.getText()+"#"+txtNation.getText()+"#"+civilStat.getSelectedItem()+"#"+ genderFinal +"#"+txtNum.getText()+"#"+txtEmail.getText()+"#"+txtDept.getText()+"#"+txtPos.getText()+"#");
				fw.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		});
		
		
	}
	public static void main(String[] args) {
			new EmployeeManagement();

	}

}