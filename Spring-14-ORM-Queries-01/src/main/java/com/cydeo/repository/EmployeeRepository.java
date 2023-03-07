package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.hibernate.query.QueryParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByEmail(String email);
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String LastName, String email);
    List<Employee> findByFirstNameIsNot(String firstName);
    List<Employee> findByLastNameStartsWith(String pattern);
    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findBySalaryLessThanEqual(Integer salary);
    List<Employee> findByHireDateBetween(Date date1, Date date2);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);
    List<Employee> findByEmailIsNull();


    @Query("SELECT e from Employee e WHERE e.email=?1")
    Employee getEmployeeByDetail(String email);

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT e from Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Optional<Employee> getEmployeeDetail(String email, int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    @Query("SELECT e FROM Employee  e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(Date date);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    @Query("SELECT e FROM Employee e WHERE e.salary IS null ")
    List<Employee> getEmployeeEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.salary IS NOT null ")
    List<Employee> getEmployeeEmailIsNotNull();

    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryInAscOrder();

    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryInDescOrder();

    @Query(value="SELECT * FROM employees WHERE salary is ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e Set e.email = 'admin@gmail.com' WHERE e.id = :id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees Set email = 'admin@gmail.com' WHERE id = :id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);




}
