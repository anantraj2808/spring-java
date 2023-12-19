package com.anantraj.cruddemo.dao;

import com.anantraj.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplementation implements  StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional //only needed when DB is to be updated/write-mode
    public void save(Student student) {
        entityManager.persist(student); //saves the student in DB
    }

    //implement retrieve method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudents() {
        //create query
        //TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        //return results
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {

        //create enquiry
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        //set query params
        query.setParameter("theData", lastName);

        //return results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateLastNameOfSomeStudents() {
        int rowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Rai' WHERE firstName='Himanshu'").executeUpdate();
        return rowsUpdated;
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        //retrieve student
        Student student = entityManager.find(Student.class, studentId);

        //delete student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteSomeStudents() {
        int rowsUpdated = entityManager.createQuery("DELETE FROM Student WHERE firstName='Himanshu'").executeUpdate();
        return rowsUpdated;
    }
}
