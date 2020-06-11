package com.chambalegui.example.service;

import com.chambalegui.example.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<List<CourseDTO>> getAll();
    Optional<CourseDTO> getById(Long id);
    Optional<CourseDTO> add(CourseDTO courseDTO);
    Optional<CourseDTO> delete(CourseDTO courseDTO);
}