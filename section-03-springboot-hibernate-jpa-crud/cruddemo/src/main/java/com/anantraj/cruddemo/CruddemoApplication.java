package com.anantraj.cruddemo;

import com.anantraj.cruddemo.dao.StudentDAO;
import com.anantraj.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//readAllStudents(studentDAO);
			//readStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//updateLastNameOfSomeStudents(studentDAO);
			//deleteStudent(studentDAO);
			//deleteSomeStudents(studentDAO);
		};
	}

	private void deleteSomeStudents(StudentDAO studentDAO) {
		int rowsAffected = studentDAO.deleteSomeStudents();
		System.out.println("Rows affected = " + rowsAffected);
	}

	private void updateLastNameOfSomeStudents(StudentDAO studentDAO) {
		int rowsAffected = studentDAO.updateLastNameOfSomeStudents();
		System.out.println("Rows affected = " + rowsAffected);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.deleteStudent(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on ID
		int studentId = 1;
		Student student = studentDAO.findById(studentId);

		//change first name
		student.setFirstName("Aditya");

		//update the student
		studentDAO.updateStudent(student);

		//display the updated student
		System.out.println("Updated Student = " + student);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> students = studentDAO.findAllStudents();

		//display list
		for(Student student: students){
			System.out.println(student);
		}

	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> students = studentDAO.findStudentsByLastName("Raj");

		//display list
		for(Student student: students){
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object");
		Student student = new Student("Himanshu", "Rai", "himanshu.rai@gmail.com");

		//save it
		System.out.println("Saving the student...");
		studentDAO.save(student);

		//display ID of saved student
		int id = student.getId();
		System.out.println("Saved Student ID = " + id);

		//retrieve student
		System.out.println("Retrieving Student with ID = " + id);
		Student myStudent = studentDAO.findById(id);

		//display student
		System.out.println("Found Student = " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 new students");
		Student student1 = new Student("Ajay", "Sharma", "sharmaajay@gmail.com");
		Student student2 = new Student("Aryan", "Singh", "aryan@gmail.com");
		Student student3 = new Student("Aditya", "Ydv", "adiydv@gmail.com");

		//save students
		System.out.println("Saving students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object");
		Student student = new Student("Anant", "Raj", "anantaditya6@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(student);

		//display ID of saved student
		System.out.println("Saved Student ID = " + student.getId());
	}

}
