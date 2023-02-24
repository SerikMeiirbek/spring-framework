package com.cydeo.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
