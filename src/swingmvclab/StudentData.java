package swingmvclab;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/*
 * A hallgatók adatait tároló osztály.
 */
public class StudentData extends AbstractTableModel {

	/*
	 * Ez a tagváltozó tárolja a hallgatói adatokat. NE MÓDOSÍTSD!
	 */
	List<Student> students = new ArrayList<Student>();

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.students.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = students.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return student.getName();
		case 1:
			return student.getNeptun();
		case 2:
			return student.hasSignature();
		default:
			return student.getGrade();
		}
	}
	@Override
	public String getColumnName(int columnIndex){
		switch(columnIndex){
		case 0:
			return "Name";
		case 1:
			return "Neptun";
		case 2:
			return "Signature";
		case 3:
			return "Grade";
		default:
			return "N/A";
				
		}
	}
	@Override
	public Class getColumnClass(int columnIndex){
		switch(columnIndex){
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Boolean.class;
		case 3:
			return Integer.class;
		default:
			return String.class;
				
		}
	}
	@Override
	public boolean isCellEditable(int row, int col){
		if(col == 2 || col == 3){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public void setValueAt(Object newValue, int rowIndex, int columnIndex){
		switch(columnIndex){
		case 0:
			this.students.get(rowIndex).setName((String) newValue);
			break;
		case 1:
			this.students.get(rowIndex).setNeptun((String) newValue);
			break;
		case 2:
			this.students.get(rowIndex).setSignature((Boolean) newValue);
			break;
		case 3:
			this.students.get(rowIndex).setGrade((int) newValue);
			break;
		default:
			return;				
		}

	}
	
	public void	addStudent(String name, String neptun) {
		this.students.add(new Student(name,neptun,false,0));
	}
	

}
