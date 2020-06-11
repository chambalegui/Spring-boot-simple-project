package com.chambalegui.example.service.impl;

import com.chambalegui.example.dao.CourseDAO;
import com.chambalegui.example.model.Course;
import com.chambalegui.example.dto.CourseDTO;
import com.chambalegui.example.service.CourseService;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public Optional<List<CourseDTO>> getAll() {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<CourseDTO> courseList = new ArrayList<>();

            List<Course> result = courseDAO.findAll();
            if (!result.isEmpty()) {
                for (Course course : result) {
                    courseList.add(modelMapper.map(course, CourseDTO.class));
                }
            }

            return Optional.ofNullable(courseList);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CourseDTO> getById(Long id) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            CourseDTO courseDTO = new CourseDTO();

            Optional<Course> result = courseDAO.findById(id);
            if (result.isPresent()) {
                courseDTO = modelMapper.map(result.get(), CourseDTO.class);
            }

            return Optional.ofNullable(courseDTO);
        } catch (ObjectNotFoundException | NullPointerException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CourseDTO> add(CourseDTO courseDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Course course = modelMapper.map(courseDTO, Course.class);
            course = courseDAO.save(course);
            courseDTO.setId(course.getId());
            return Optional.ofNullable(courseDTO);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CourseDTO> delete(CourseDTO courseDTO) {
        try {
            courseDAO.deleteById(courseDTO.getId());
            return Optional.ofNullable(courseDTO);
        } catch (ObjectNotFoundException | NullPointerException e) {
            return Optional.empty();
        }
    }
}
