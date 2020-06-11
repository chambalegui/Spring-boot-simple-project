package com.chambalegui.example.dao;

import com.chambalegui.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {
}
