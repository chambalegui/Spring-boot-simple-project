package com.chambalegui.example.controller;

import com.chambalegui.example.dto.CourseDTO;
import com.chambalegui.example.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAll() {
        Optional<List<CourseDTO>> result = courseService.getAll();
        return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResponseEntity<CourseDTO> getById(@RequestParam ("id") Long id) {
        Optional<CourseDTO> result = courseService.getById(id);
        return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> add(@RequestParam ("courseDTO") String course) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CourseDTO courseDTO = objectMapper.readValue(course, CourseDTO.class);
            Optional<CourseDTO> result = courseService.add(courseDTO);
            return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<CourseDTO> delete(@RequestParam ("courseDTO") String course) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CourseDTO courseDTO = objectMapper.readValue(course, CourseDTO.class);
            Optional<CourseDTO> result = courseService.delete(courseDTO);
            return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
}
