package com.departementservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}
