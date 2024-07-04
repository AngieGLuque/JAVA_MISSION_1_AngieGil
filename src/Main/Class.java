package Main;

import java.util.ArrayList;
import java.util.stream.IntStream;

//This class stablishes the variables needed for a Class
public class Class {
	private ArrayList<Student> students = new ArrayList<Student>(); //ArrayList to group multiple students
	private double javaAvg = 0d; //Class' average grade in Java subject
	private double sqlAvg = 0d; //Class' average grade in SQL subject
	private double mathAvg = 0d; //Class' average grade in Mathematics subject
	private double englishAvg = 0d; //Class' average grade in English subject
	private double drawingAvg = 0d;
	
	public Class() {} //Empty class constructor
	
	//Getters and setters for each variable
	public ArrayList<Student> getStudents() {
		return students;
	}
	//Students arraylist does not have a set, instead students gets added one by one
	public void addStudent(Student student) {
		students.add(student);
	}

	public double getJavaAvg() {
		return javaAvg;
	}

	public double getSqlAvg() {
		return sqlAvg;
	}

	public double getMathAvg() {
		return mathAvg;
	}

	public double getEnglishAvg() {
		return englishAvg;
	}
	
	public double getDrawingAvg() {
		return drawingAvg;
	}
	
	//This function loops through the final students arraylist, calculates the average
	//grade for each subject and updates the rank variable for each student
	public void setClassAvg() {
		for(int i = 0; i < students.size();i++) {
			javaAvg += (double) students.get(i).getJavaScore();
			sqlAvg += (double) students.get(i).getSqlScore();
			mathAvg += (double) students.get(i).getMathScore();
			englishAvg += (double) students.get(i).getEnglishScore();
			drawingAvg += (double) students.get(i).getDrawingScore();
			students.get(i).setRank(i+1);
		}
		javaAvg = (double) javaAvg/students.size();
		sqlAvg = (double) sqlAvg/students.size(); 
		mathAvg = (double) mathAvg/students.size(); 
		englishAvg = (double) englishAvg/students.size();
		drawingAvg = (double) drawingAvg/students.size();
	}
	
	//This function sorts students arraylist descending by average grade
	public void sortStudentsByAvg() {
		students.sort((o1,o2)->o2.getAvg().compareTo(o1.getAvg()));
	}
	
	//This function calls the sorting function, search for a specific ID and returns the student's rank depending on it's position in the arraylist
	public int setRanking(String id) {
		if(students.size()>1) {
			sortStudentsByAvg();
			return IntStream.range(0, students.size()).filter(i -> students.get(i).getId()== id).findFirst().orElse(-1) +1;
		}else {
			return 1;
		}
	};
	

}
