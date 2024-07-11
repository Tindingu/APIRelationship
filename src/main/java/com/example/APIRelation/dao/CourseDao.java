package com.example.APIRelation.dao;

import com.example.APIRelation.entity.Course;

public interface CourseDao {

    public void save(Course course);
    public Course findCourseAndStudent(int id);
}
