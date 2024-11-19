package com.learning.MappingInSB.Service;

import com.learning.MappingInSB.Model.Employee;
import com.learning.MappingInSB.Model.Project;
import com.learning.MappingInSB.Repository.EmployeeRepo;
import com.learning.MappingInSB.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    public Project assignEmployeeToProject(int projId, int empId) {
        Optional<Project> resPro= projectRepo.findById(projId);
        Optional<Employee> resEmp= employeeRepo.findById(empId);

        if(resPro.isPresent() && resEmp.isPresent()) {
            Project project= resPro.get();
            Employee employee= resEmp.get();

            List<Project> projectList= employee.getProjectList();
            projectList.add(project);
            employee.setProjectList(projectList);

            List<Employee> employeeList= project.getEmployeeList();
            employeeList.add(employee);
            project.setEmployeeList(employeeList);

            employeeRepo.save(employee);
            return projectRepo.save(project);
        }
        return null;
    }
}
