package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Teacher;
import com.example.APIRelation.entity.TeacherDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDetailimpl implements TeacherDetailDao{
    private EntityManager entityManager;
    @Autowired
    public  TeacherDetailimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveTeacher(TeacherDetail teacherDetail) {
        entityManager.persist(teacherDetail);
    }

    @Override
    public TeacherDetail getTeacher(int id) {
        TeacherDetail teacherDetail = entityManager.find(TeacherDetail.class, id);
        return teacherDetail;
    }

    @Override
    public void deleteTeacher(int id) {
        TeacherDetail teacherDetail = entityManager.find(TeacherDetail.class, id);
        entityManager.remove(teacherDetail);
    }
}
