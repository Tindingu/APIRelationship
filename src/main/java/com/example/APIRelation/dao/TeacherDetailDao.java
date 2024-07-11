package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Teacher;
import com.example.APIRelation.entity.TeacherDetail;

public interface TeacherDetailDao {
    public void saveTeacher(TeacherDetail teacherDetail);
    public TeacherDetail getTeacher(int id);
    public void deleteTeacher(int id);
}
