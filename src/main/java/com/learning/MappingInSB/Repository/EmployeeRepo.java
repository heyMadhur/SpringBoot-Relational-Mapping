package com.learning.MappingInSB.Repository;

import com.learning.MappingInSB.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
