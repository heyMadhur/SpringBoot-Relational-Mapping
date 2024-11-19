package com.learning.MappingInSB.Service;

import com.learning.MappingInSB.Model.Employee;
import com.learning.MappingInSB.Model.Laptop;
import com.learning.MappingInSB.Repository.EmployeeRepo;
import com.learning.MappingInSB.Repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private LaptopRepo laptopRepo;


    public Employee addEmployee(Employee employee) {
        if(employee.getLaptop()!=null) {
            employee.getLaptop().setEmployee(employee);
        }
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }


    public Employee addLaptopToEmployee(int empId, int lapId) {
        Optional<Employee> empRes= employeeRepo.findById(empId);
        Optional<Laptop> lapRes= laptopRepo.findById(lapId);
        if(empRes.isPresent() &&  laptopRepo.existsById(lapId)) {
            Employee employee= empRes.get();
            Laptop laptop= lapRes.get();
            employee.setLaptop(laptop);
            return employeeRepo.save(employee);
        }
        return null;
    }

    public Employee deleteEmployee(int id) {
       Optional<Employee> e= employeeRepo.findById(id);
       if(e.isPresent()){
         employeeRepo.deleteById(id);
         return e.get();
       }
       return null;
    }
}
