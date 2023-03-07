package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    List<Department> findByDepartment(String department);

    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEquals(String division);

    List<Department> findDistinctTop3ByDivisionContains(String name);

    @Query("SELECT d FROM Department d WHERE d.division in ?1")
    List<Department> getDepartmentByDivision(List<String> division);


    List<Employee> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);



}
