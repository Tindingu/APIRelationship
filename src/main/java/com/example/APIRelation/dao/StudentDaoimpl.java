package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoimpl implements StudentDao{
    private EntityManager entityManager;
    @Autowired
    public StudentDaoimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Student student) {
        this.entityManager.persist(student);
        this.entityManager.flush();
    }

    @Override
    public Student findStudentAndCourse(int id) {
        TypedQuery<Student> query=entityManager.createQuery(
                    "select s from Student s "+
                        "JOIN FETCH s.courses "+
                        "where s.id=:x",Student.class
        );
        query.setParameter("x",id);
        Student s1=query.getSingleResult();
        return s1;
    }
}
