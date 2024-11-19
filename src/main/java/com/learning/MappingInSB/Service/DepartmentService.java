package com.learning.MappingInSB.Service;

import com.learning.MappingInSB.Model.Department;
import com.learning.MappingInSB.Model.Employee;
import com.learning.MappingInSB.Repository.DepartmentRepo;
import com.learning.MappingInSB.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }


    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department addEmployeeToDepartment(int depId, int empId) {
        Optional<Department> resDep= departmentRepo.findById(depId);
        Optional<Employee> resEmp= employeeRepo.findById(empId);

        if(resDep.isPresent() && resEmp.isPresent()) {
            Employee employee= resEmp.get();
            Department department= resDep.get();
            employee.setDepartment(department);
            List<Employee> employeeList= department.getEmployees();
            employeeList.add(employee);
            department.setEmployees(employeeList);
            return departmentRepo.save(department);
        }
        return null;
    }
}
