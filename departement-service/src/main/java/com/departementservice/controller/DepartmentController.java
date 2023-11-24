package com.departementservice.controller;

import com.departementservice.client.EmployeeClient;
import com.departementservice.config.WebClientConfig;
import com.departementservice.model.Department;

import com.departementservice.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    //private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeClient employeeClient;
    @PostMapping
    public Department add(@RequestBody Department d){
        //LOGGER.info("Department add:{}",d);
        return departmentRepository.addDepartment(d);
    }
    @GetMapping
    public List<Department> findAll(){
        return departmentRepository.getAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        return departmentRepository.findby(id);
    }
    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployee(){
        List<Department> departments=departmentRepository.getAll();
        departments.forEach(d->d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }
}
