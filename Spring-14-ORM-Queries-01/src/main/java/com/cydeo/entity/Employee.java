package com.cydeo.entity;


import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Data
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private Date hireDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department")
    Department department;
    @Enumerated(EnumType.STRING)
    Gender gender;
    private Integer salary;
    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

}
