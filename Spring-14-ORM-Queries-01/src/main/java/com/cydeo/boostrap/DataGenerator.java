package com.cydeo.boostrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.SQLOutput;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===================REGION START========================");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingIOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findByCountryContainingIOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTopByCountry: "  + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("===================REGION END========================");


        System.out.println("===================DEPARTMENT START========================");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionIncludes: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("===================DEPARTMENT END========================");

        System.out.println("===================Employee START========================");
        System.out.println("getEmployeeByDetail: " + employeeRepository.getEmployeeByDetail("sdubber7@t-online.de"));
        System.out.println("getEmployeeSalary: " +   employeeRepository.getEmployeeSalary());

        System.out.println("===================Employee END========================");

        System.out.println("===================Course START========================");
        courseRepository.findAllByCategory("Sprint").forEach(System.out::println);

        courseRepository.findAllByCategoryOrderByName("Sprint").forEach(System.out::println);

        System.out.println("existsByName: " + courseRepository.existsByName("Java script"));
        courseRepository.existsByName("Java Script");
        System.out.println("===================Course END========================");
    }
}
