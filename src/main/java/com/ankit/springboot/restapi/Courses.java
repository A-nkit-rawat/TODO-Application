package com.ankit.springboot.restapi;

public class Courses {
	public Courses(){
		
	}
	private int courseId;
	private String courseName;
	private String Instructor;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	public Courses(int courseId, String courseName, String instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		Instructor = instructor;
	}
	
}
