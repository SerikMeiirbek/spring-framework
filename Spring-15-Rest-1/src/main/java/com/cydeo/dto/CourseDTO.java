package com.cydeo.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class CourseDTO {

    private Long id;

    private String name;

    private String category;

    private int rating;

    private String description;

}
