package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.io.*;
import java.util.ArrayList;
public class StudentInfoForm extends JFrame{
	
	static JFrame frame;
	static DefaultTableModel model;
	static JTable table;
	static JScrollPane scroll;
	
	static JLabel name;
	static JLabel course;
	static JLabel section;
	
	static JTextField txtName;
	static JTextField txtCourse;
	static JTextField txtSection;
	
	static JButton btnAdd;
	static JButton btnUpdate;
	static JButton btnDelete;
	static JButton btnClear;
	
	
	public StudentInfoForm( ) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(420,460);
		setResizable(false);
		setTitle("Student Information Form");
		setLocationRelativeTo(null);
		
		File f = new File("StudentInfo.txt");
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		String[] columns = {"Name","Course","Section"};
		model = new DefaultTableModel(columns, 0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		add(scroll).setBounds(4,10,395,256);
		refresh();
		
		
		name = new JLabel("Name");
		add(name).setBounds(15,260,300,25);
		
		course = new JLabel("Course");
		add(course).setBounds(150,260,300,25);
		
		section = new JLabel("Section");
		add(section).setBounds(285,260,300,25);
		
		
		txtName = new JTextField();
		add(txtName).setBounds(15,285,125,24);
		
		txtCourse = new JTextField();
		add(txtCourse).setBounds(150,285,125,24);
		
		txtSection = new JTextField();
		add(txtSection).setBounds(285,285,110,24);
		
		btnAdd = new JButton("Add");
		add(btnAdd).setBounds(10,340,100,25);
		
		btnUpdate = new JButton("Update");
		add(btnUpdate).setBounds(120,340,100,25);
		
		btnDelete = new JButton("Delete");
		add(btnDelete).setBounds(230,340,100,25);
		
		btnClear = new JButton("Clear");
		add(btnClear).setBounds(150,380,100,25);
		
		btnAdd.addActionListener(e ->{
			
			try {
				FileWriter fw = new FileWriter("StudentInfo.txt",true);
				fw.write(txtName.getText()+"#"+txtCourse.getText()+"#"+txtSection.getText()+"\n");
				fw.close();
				refresh();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
	});
		btnUpdate.addActionListener(e->{
			int selected = table.getSelectedRow();
			
			if (selected == -1) {
				JOptionPane.showMessageDialog(null,"Select a row to Update");
				return;
			}
			ArrayList<String> newLine = new ArrayList<>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("StudentInfo.txt"));
				String line;
				int rowIndex = 0;
				while((line=br.readLine())!=null) {
					if(rowIndex == selected) {
						String overwrite = txtName.getText()+"#"+txtCourse.getText()+"#"+txtSection.getText();
						newLine.add(overwrite);
						
					}else {
						newLine.add(line);
					}
					rowIndex++;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("StudentInfo.txt"));
				for (String replace:newLine) bw.write(replace+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			refresh();
			
		
		});
		
		btnDelete.addActionListener(e->{
			int selected = table.getSelectedRow();
			
			if(selected == -1) {
				JOptionPane.showMessageDialog(null,"Selected to remove");
				return;	
			}
			int confirm = JOptionPane.showConfirmDialog(null,"Delete everything?","Confirm?",JOptionPane.YES_NO_OPTION);
			if(confirm != JOptionPane.YES_OPTION) 
				return;
				
				ArrayList<String> newLine = new ArrayList<>();
				try {
					BufferedReader br = new BufferedReader(new FileReader("StudentInfo.txt"));
					String line;
					int rowIndex = 0;
					while((line=br.readLine())!=null) {
						if (rowIndex != selected) {
							newLine.add(line);
							rowIndex++;
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("StudenInfo.txt"));
					for (String replace:newLine) {
						bw.write(replace+"\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		});
		
		btnClear.addActionListener(e ->{
			txtName.setText("");
			txtCourse.setText("");
			txtSection.setText("");
	
	});
		
	}
	public static void refresh() {
		model.setRowCount(0);
		try {
			BufferedReader br = new BufferedReader(new FileReader("StudentInfo.txt"));
			String line;
			while((line=br.readLine())!=null) {
				String rows[] = line.split("#");
				model.addRow(rows);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new StudentInfoForm();

	}

}
