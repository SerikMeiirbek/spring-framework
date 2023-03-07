package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

     List<Course> findAllByCategory(String category);


     List<Course> findAllByCategoryOrderByName(String category);

     boolean existsByName(String name);

     int countAllByCategory(String name);

     List<Course>findAllByNameContains(String pattern);

     Stream<Course> streamAllByName(String name);

     @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
     List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);




}
