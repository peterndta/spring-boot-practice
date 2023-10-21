package com.peterndta.cruddemo.dao;

import com.peterndta.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOIml implements StudentDAO {
    //define field for entity manager
    private EntityManager entityManager;

    //Inject entity manager bằng constructor injection
    @Autowired
    public StudentDAOIml(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // imple save object xuong DB
    @Override
    @Transactional // import đúng package spring
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        // default order by là asc
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // ascending
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        // descending
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);

        // return kết quả query
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query param
        theQuery.setParameter("theData", lastName);

        // return kết quả
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // find Student
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numberRowsDeleted;
    }
}
