package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Student;

public interface StudentDao {
    public void save(Student student);
    public Student findStudentAndCourse(int id);
}
