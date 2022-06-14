package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Display all employees with email address ''
    List<Employee>findAllByEmail(String email);

    //Display all employees with first name '' and last name additionally show all employees with an email address;
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String LastName, String email);

    //Display all employees that first name is not ''
    List<Employee>findByFirstNameIsNot(String firstName);

    //Display all employees where last name start with ''
    List<Employee> findByLastNameStartingWith(String pattern);



    //Display all employees with salary grater then ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salary less than ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to '' in order
    //List<Employee> finDistinctBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ''
    //List<Employee>findDistinctTop3BySalaryLessThanOrderBySalary(Integer salary);

    //Display all employees that don't have an email address
    List<Employee> findByEmailIsNull();


    //=================JPQL====================

    @Query("SELECT e FROM Employee e WHERE e.email = 'myakovlivf@ucsd.edu'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'myakovlivf@ucsd.edu'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmplyeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeDetail(String email, int salary);




}
