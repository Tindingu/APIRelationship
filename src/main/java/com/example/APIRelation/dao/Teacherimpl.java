package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Teacherimpl implements TeacherDao{
    private EntityManager entityManager;
    @Autowired
    public Teacherimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
        entityManager.flush();
    }

    @Override
    public Teacher findTeacherByIdJoinFetch(int id) {
        TypedQuery<Teacher> query=entityManager.createQuery(
                    "select t from Teacher t "+
                        "JOIN FETCH t.courseList "+
                        "JOIN FETCH t.teacherDetail "+
                        "where t.id=:x"
                        , Teacher.class);
        query.setParameter("x", id);
        Teacher teacher=query.getSingleResult();
        return teacher;
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public Teacher getTeacher(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        return teacher;
    }

    @Override
    public void deleteTeacher(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
    }
}
