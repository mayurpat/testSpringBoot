package com.example.demo.bootstrap;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.model.Book;
import com.example.demo.dao.model.Employee;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeeService;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
// Causes Lombok to generate a logger field.
@Slf4j
// Causes Lombok to generate a constructor with 1 parameter for each field that requires special handling.
@RequiredArgsConstructor
@Component
public class DefaultEmployeeLoader implements CommandLineRunner {
 
    @Autowired
	private EmployeeService employeeService;
    
 
    @Override
    public void run(String... args) {
    	loadEmployeeData();
    }
 
    private void loadEmployeeData() {
        if (employeeService.getEmployeesCount() == 0) {
            log.info("Saving the default employees into the database.");
            for (int x = 0; x < 5; x++) {
                employeeService.createEmployee(createNewEmployee());
            }
        } else {
            log.info("Default books are already present in the database.");
        }
    }
 
    private Employee createNewEmployee() {
        final int randomNumber = new Random().nextInt(10 - 5 + 1) + 5;
        Faker faker = new Faker();
        return Employee.builder()
        		.firstName(faker.funnyName().name())
        		.lastName(faker.animal().name())
        		.emailId("abc@abc.com").build();
    }
}

