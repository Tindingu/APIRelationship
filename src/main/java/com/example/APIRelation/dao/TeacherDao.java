package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Teacher;

public interface TeacherDao {
    public void saveTeacher(Teacher teacher);
    public Teacher getTeacher(int id);
    public void deleteTeacher(int id);
    public void update(Teacher teacher);
    public Teacher findTeacherByIdJoinFetch(int id);
}
