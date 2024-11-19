package com.learning.MappingInSB.Controller;

import com.learning.MappingInSB.Model.Department;
import com.learning.MappingInSB.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    private String getDefaultDepartment(){
        return "Welcome to Department Controller";
    }

    @GetMapping("/get-departments")
    private ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> res= departmentService.getAllDepartment();
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-department")
    private ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department res= departmentService.addDepartment(department);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Department(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/add/{depId}/employee/{empId}")
    private ResponseEntity<Department> addEmployeeToDepartment(@PathVariable int depId, @PathVariable int empId) {
        Department res= departmentService.addEmployeeToDepartment(depId, empId);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Department(), HttpStatus.NOT_FOUND);
    }

}
