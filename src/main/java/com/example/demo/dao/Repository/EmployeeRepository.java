package com.example.demo.dao.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
