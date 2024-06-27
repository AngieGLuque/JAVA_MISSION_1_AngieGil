package Main;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numStudents = 0; //variable for storing the number of students entered by the user
		
		Student student; //Student object for storing student data before adding the object to the arraylist
		Class class1 = new Class(); //Class object for storing students data and class data
		
		//InputDialog for number of students
		numStudents = onlyNumbers(JOptionPane.showInputDialog("How many students are in this class?"));
		
		System.out.println("How many students are in this class? : "+numStudents);
		
		//With the number of students we can establish a loop that allows the user to enter students grade in order one by one
		for(int i = 1; i <= numStudents ; i++) {
			int javaScore = onlyNumbers(JOptionPane.showInputDialog("Insert Java score for student "+i));
			int sqlScore = onlyNumbers(JOptionPane.showInputDialog("Insert SQL score for student "+i));
			int mathScore = onlyNumbers(JOptionPane.showInputDialog("Insert Math score for student "+i));
			int engScore = onlyNumbers(JOptionPane.showInputDialog("Insert English score for student "+i));
			String id = ""; //variable for storing student's ID
			if(i<10) { //With this if we can format the student's ID
				id = "STD0"+i;
			}else {
				id = "STD"+i;
			}
			student = new Student(id,javaScore,sqlScore,mathScore,engScore); //We declare the student object with all the variables
			class1.addStudent(student); //We add the student object to the Students arraylist
			student.setRank(class1.setRanking(id)); //We set the rank for the student using the setRanking function from Class class
			printStudentStatus(student); //We then print the student status
		}

		class1.setClassAvg(); //Here we set all average grades and update the ranking
		printClassRanking(class1); //We print the class ranking
		printClassStatus(class1); //Finally, we print the class status
	}
	
	//This function verifies the input data is numbers only
	//The verification is made with regular expressions 
	public static Integer onlyNumbers(String input) {
		int inputNum = 0;
		do {
			if(input.matches("^\\d*$")) {
				inputNum = Integer.parseInt(input);
			}else {
				JOptionPane.showMessageDialog(null, "Invalid input, please type numbers onnly");
			}
		}while(!input.matches("^\\d*$"));
		return inputNum;
	}
	
	//This function is the printing template for each student status
	public static void printStudentStatus(Student student) {
		System.out.println(student.getId()+" Student's Java Score: "+student.getJavaScore());
		System.out.println(student.getId()+" Student's SQL Score: "+student.getSqlScore());
		System.out.println(student.getId()+" Student's Math. Score: "+student.getMathScore());
		System.out.println(student.getId()+" Student's English Score: "+student.getEnglishScore());
		System.out.println("-------------------------------------------");
		System.out.println("["+student.getId()+"] Student's Score Status");
		System.out.println("Java "+student.getJavaScore()+", SQL "+student.getSqlScore()+", Math. "+student.getMathScore()+", English "+student.getEnglishScore());
		System.out.println("-------------------------------------------");
		System.out.println("Avg.: "+student.getAvg()+", Rank: "+student.getRank());
		System.out.println("-------------------------------------------");
	}
	
	//This function is the printing template for the class ranking
	public static void printClassRanking(Class class1) {
		for(Student student : class1.getStudents()) {
			System.out.println(student.getId()+":=> Avg.:"+student.getAvg()+", Rank:"+student.getRank());
		}
	}
	
	//This function is the printing template for each subject average grade in the class
	public static void printClassStatus(Class class1) {
		System.out.println("===============================");
		System.out.println("Java Class Avg.: "+class1.getJavaAvg());
		System.out.println("SQL Class Avg.: "+class1.getSqlAvg());
		System.out.println("Math. Class Avg.: "+class1.getMathAvg());
		System.out.println("English Class Avg.: "+class1.getEnglishAvg());
		System.out.println("===============================");
	}

}
