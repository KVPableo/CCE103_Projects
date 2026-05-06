package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
public class EmployeeManagement extends JFrame {
	
	static DefaultTableModel model;
	static JFrame frame;
	static File f;
	
	
	
	public EmployeeManagement ( ) {
		frame = new JFrame("Employee Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(800, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(frame);
		frame.setLayout(null);
		
		
		f = new File("Employee.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String [] columns = {"Employee ID","Fullname","Age","Date of Birth","Nationality","Gender","Contact Number","Email","Department","Job Title / Position"};
		model = new DefaultTableModel(columns, 0);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		frame.add(scroll).setBounds(25, 240, 735, 200);
		
		
		JLabel title = new JLabel("EMS Inc.");
		frame.add(title).setBounds(25, -45, 150, 150);
		
		JLabel id = new JLabel("Employee ID");
		frame.add(id).setBounds(25,55,150,25);
		JTextField txtID = new JTextField();
		frame.add(txtID).setBounds(25,80,160,20);
		
		JLabel name = new JLabel("Fullname");
		frame.add(name).setBounds(25,100,150,25);
		JTextField txtName = new JTextField();
		frame.add(txtName).setBounds(25,125,160,20);
		
		JLabel birth = new JLabel("Date of Birth");
		frame.add(birth).setBounds(25,145,150,20);
		JTextField txtBirth = new JTextField();
		frame.add(txtBirth).setBounds(25,170,160,20);
		
		JLabel age = new JLabel("Age");
		frame.add(age).setBounds(215,55,150,25);
		JTextField txtAge = new JTextField();
		frame.add(txtAge).setBounds(215,80,160,20);
		
		JLabel status = new JLabel("Civil Status");
		frame.add(status).setBounds(215,100,150,25);
		String [] civil = {"Single","Married","Widowed","Separated","Divorced"};
		JComboBox civilStat = new JComboBox(civil);
		frame.add(civilStat).setBounds(215,125,160,20);
		
		JLabel nation = new JLabel("Nationality");
		frame.add(nation).setBounds(215,145,150,25);
		JTextField txtNation = new JTextField();
		frame.add(txtNation).setBounds(215,170,160,20);
		
		JLabel gender = new JLabel("Gender");
		frame.add(gender).setBounds(405,55,150,25);
		JRadioButton m = new JRadioButton("Male");	
		JRadioButton fm = new JRadioButton("Female");	
		ButtonGroup group = new ButtonGroup();
		group.add(m);
		group.add(fm);
		frame.add(m).setBounds(405,76,60,25);
		frame.add(fm).setBounds(465,76,80,25);
		m.setActionCommand("Male");
		fm.setActionCommand("Female");
		
		JLabel no = new JLabel("Contact Number");
		frame.add(no).setBounds(405,100,150,25);
		JTextField txtNum = new JTextField();
		frame.add(txtNum).setBounds(405,125,160,20);
		
		JLabel email = new JLabel("Email");
		frame.add(email).setBounds(405,145,150,25);
		JTextField txtEmail = new JTextField();
		frame.add(txtEmail).setBounds(405,170,160,20);
		
		JLabel dept = new JLabel("Department");
		frame.add(dept).setBounds(595,100,150,25);
		JTextField txtDept = new JTextField();
		frame.add(txtDept).setBounds(595,125,160,20);
		
		JLabel pos = new JLabel("Job Title / Position");
		frame.add(pos).setBounds(595,145,150,25);
		JTextField txtPos = new JTextField();
		frame.add(txtPos).setBounds(595,170,160,20);
		
		// BUTTONS
		JButton btnAdd = new JButton("Add");
		frame.add(btnAdd).setBounds(360,203,120,25);
		
		JButton btnRemove = new JButton("Remove");
		frame.add(btnRemove);
		btnRemove.setBounds(640,203,120,25);
		
		JButton btnUpdate = new JButton("Update");
		frame.add(btnUpdate).setBounds(500,203,120,25);
		
		
		// FUNCTIONS
		
//		String genderselect = group.getSelection().getActionCommand();
		
		update();
	///// NEEDS FIXINGGGGGGGGGGG =============================================================================================================
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int roww = table.getSelectedRow();
				if(roww != -1) {
//					(txtID.getText()+"#"+txtName.getText()+"#"+txtAge.getText()+"#"+txtNation.getText()+"#"+civilStat.getSelectedItem()+"#"+ genderFinal +"#"+txtNum.getText()+"#"+txtEmail.getText()+"#"+txtDept.getText()+"#"+txtPos.getText()+"#"+"\n");
					
					txtID.setText(model.getValueAt(roww,0).toString());
					txtName.setText(model.getValueAt(roww,1).toString());
					txtBirth.setText(model.getValueAt(roww,2).toString());
					txtAge.setText(model.getValueAt(roww,3).toString());
					txtNation.setText(model.getValueAt(roww,4).toString());				
					civilStat.getSelectedItem();
					group.getSelection().getActionCommand();
					txtNum.setText(model.getValueAt(roww,6).toString());
					txtEmail.setText(model.getValueAt(roww,7).toString());
					txtDept.setText(model.getValueAt(roww,8).toString());
					txtPos.setText(model.getValueAt(roww,9).toString());
					
				}
			}
	
			
		});

		
		btnAdd.addActionListener(e ->{	
			try {
				FileWriter fw = new FileWriter("Employee.txt", true);
				fw.write(txtID.getText()+"#"+txtName.getText()+"#"+txtAge.getText()+"#"+txtNation.getText()+"#"+civilStat.getSelectedItem()+"#"+ group.getSelection().getActionCommand()+"#"+txtNum.getText()+"#"+txtEmail.getText()+"#"+txtDept.getText()+"#"+txtPos.getText()+"#"+"\n");
				fw.close();
				update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		});
		
		btnUpdate.addActionListener(e ->{
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "Select a record to Update");
				return;
			}
			ArrayList<String> lines = new ArrayList<>();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
				String line;
				int rowIn = 0;	
				while((line=br.readLine())!=null) {
						if(rowIn != selectedRow) {
						String newRec = txtID.getText()+"#"+txtName.getText()+"#"+txtBirth.getText()+"#"+txtAge.getText()+"#"+civilStat.getSelectedItem()+"#"+group.getSelection().getActionCommand()+"#"+txtNum.getText()+"#"+txtEmail.getText()+"#"+txtDept.getText()+"#"+txtPos.getText()+"#";
						lines.add(newRec);
				}else {
					lines.add(line);
					}
						rowIn++;
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				BufferedWriter bwr = new BufferedWriter(new FileWriter("Employee.txt"));
				for(String rec:lines)
					bwr.write(rec+"\n");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			update();
			JOptionPane.showMessageDialog(null,"Record updated!");
		
		});
		
		btnRemove.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "Select a record to delete");
				return;
		}
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this record?", "Continue", JOptionPane.YES_NO_OPTION);
			if (confirm != JOptionPane.YES_OPTION)
				return;
			
			
			ArrayList<String> lines = new ArrayList<>();			
			try {
				BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
				String line;
				int rowIn = 0;	
				while((line=br.readLine())!=null) {
						if(rowIn != selectedRow) lines.add(line);
						rowIn++;
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			try {
				BufferedWriter bfw = new BufferedWriter(new FileWriter("Employee.txt"));
					for (String rec:lines) 
					bfw.write(rec+"\n");
					
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			update();
			
			
		
		});
	}
	public static void update() {
		model.setRowCount(0);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader ("Employee.txt"));
			String line;
			
			while ((line=br.readLine())!=null) {
				String rows[] = line.split("#");
				model.addRow(rows);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			new EmployeeManagement();

	}

}