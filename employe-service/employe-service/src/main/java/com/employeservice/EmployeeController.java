package com.employeservice;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee e){
        return employeeRepository.addEmployee(e);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeRepository.findById(id);
    }
    @GetMapping("/department/{departmentid}")
    public List<Employee> findByDepartment(@PathVariable Long departmentid){
        return employeeRepository.findByDepartment(departmentid);
    }

}
