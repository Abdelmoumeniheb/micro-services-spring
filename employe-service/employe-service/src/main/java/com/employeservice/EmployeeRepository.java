package com.employeservice;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();
    public Employee addEmployee(Employee e){
        employees.add(e);
        return e;
    }
    public Employee findById(Long id){
        return employees.stream().filter(a->a.id()==id).findFirst().orElseThrow();
    }
    public List<Employee> findAll(){
        return employees;
    }
    public List<Employee> findByDepartment(Long DepartmentId){
        return employees.stream().filter(a->a.departmentId()==DepartmentId).toList();
    }


}
