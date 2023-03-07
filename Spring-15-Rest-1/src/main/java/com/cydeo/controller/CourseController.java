package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.entity.Course;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        CourseDTO courseDTO = courseService.getCourseById(courseId);
        return  courseDTO;
    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getCoursesByCategory(@PathVariable("name") String categoryName){
        List<CourseDTO> list = courseService.getCoursesByCategory(categoryName);
        return list;
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
        CourseDTO course = courseService.createCourse(courseDTO);
        return courseDTO;
    }

    @PutMapping("/{id}")
    public void updateCourse(@RequestBody CourseDTO courseDTO, @PathVariable("id") Long id){
        courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable("id") Long id){
        courseService.deleteCourseById(id);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }

}
