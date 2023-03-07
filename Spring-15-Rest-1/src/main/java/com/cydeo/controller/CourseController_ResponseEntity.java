package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V2")
                .header("Operation", "Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V2")
                .header("Operation", "Get List")
                .body(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .body(courseService.createCourse(courseDTO));
    }
}
