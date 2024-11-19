package com.learning.MappingInSB.Controller;

import com.learning.MappingInSB.Model.Employee;
import com.learning.MappingInSB.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getDefaultEmployee(){
        return "Welcome to Employee Controller";
    }
    @GetMapping("/get-employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> res= employeeService.getAllEmployees();
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee res= employeeService.addEmployee(employee);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Employee(), HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{empId}/laptop/{lapId}")
    public ResponseEntity<Employee> addLaptopToEmployee(@PathVariable int empId, @PathVariable int lapId) {
        Employee res= employeeService.addLaptopToEmployee(empId, lapId);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Employee(), HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("delete-employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        Employee res= employeeService.deleteEmployee(id);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Employee(), HttpStatus.NOT_IMPLEMENTED);
    }

}
