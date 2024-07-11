package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Course;
import com.example.APIRelation.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Courseimpl implements CourseDao {
    private EntityManager entityManager;
    @Autowired
    public Courseimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndStudent(int id) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select t from Course t "+
                        "JOIN FETCH t.students "+
                        "where t.id=:x",Course.class
        );
        query.setParameter("x",id);
            Course c1=query.getSingleResult();
            return c1;
    }
}
