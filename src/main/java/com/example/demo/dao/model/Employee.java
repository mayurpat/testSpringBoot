package com.example.demo.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
//Causes Lombok to implement the Builder design pattern for the Pojo class.
//Usage can be seen in DefaultBookLoader.java -> createNewBook() method.
@Builder
//Causes Lombok to generate a constructor with no parameters.
@NoArgsConstructor
//// Causes Lombok to generate a constructor with 1 parameter for each field in your class.
@AllArgsConstructor
//Spring framework annotation
@Component
public class Employee {

 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    
    @Column(name = "first_name", nullable = false)
    String firstName;
    

    @Column(name = "last_name", nullable = false)
    String lastName;
    
    @Column(name = "email_address", nullable = false)
    String emailId;
 
 
}