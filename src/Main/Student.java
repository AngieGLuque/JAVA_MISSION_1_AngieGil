package Main;

//This class stablishes the variables needed for a single student
public class Student {
	private String id; //Student's ID
	private int javaScore; //Student's grade in Java class
	private int sqlScore; //Student's grade in SQL class
	private int mathScore; //Student's grade in Mathematics class
	private int englishScore; //Student's grade in English class
	private int drawingScore;
	private Double avg; //Student's grades average
	private int rank = 0; //Student's ranking
	
	public Student() {} //Class empty constructor
	
	//Class constructor with obligatory parameters
	public Student(String id, int javaScore, int sqlScore, int mathScore, int englishScore, int drawingScore) {
		this.id = id;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.drawingScore = drawingScore;
		this.avg =(double) (javaScore+sqlScore+mathScore+englishScore+drawingScore)/5;
	}
	
	//Getters and setters for each variable
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}

	public int getSqlScore() {
		return sqlScore;
	}

	public void setSqlScore(int sqlScore) {
		this.sqlScore = sqlScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	
	public int getDrawingScore() {
		return drawingScore;
	}

	public void setDrawingScore(int drawingScore) {
		this.drawingScore = drawingScore;
	}

	//Average variable does not have a set function
	public Double getAvg() {
		return avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
