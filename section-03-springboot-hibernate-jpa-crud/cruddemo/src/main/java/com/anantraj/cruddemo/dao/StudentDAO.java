package com.anantraj.cruddemo.dao;

import com.anantraj.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAllStudents();

    List<Student> findStudentsByLastName(String lastName);

    void updateStudent(Student student);

    int updateLastNameOfSomeStudents();

    void deleteStudent(int studentId);

    int deleteSomeStudents();

}
