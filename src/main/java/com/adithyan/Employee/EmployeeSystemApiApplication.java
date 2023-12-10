package com.adithyan.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.adithyan.Employee.repository", "com.adithyan.Employee.model", "com.adithyan.Employee.controller", "com.adithyan.Employee.services"})
@EntityScan(basePackages = {"com.adithyan.Employee.model"})
public class EmployeeSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSystemApiApplication.class, args);
    }

}
