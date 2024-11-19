package com.learning.MappingInSB.Controller;

import com.learning.MappingInSB.Model.Employee;
import com.learning.MappingInSB.Model.Laptop;
import com.learning.MappingInSB.Model.Project;
import com.learning.MappingInSB.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    private String getDefaultProject(){
        return "Welcome to Project Controller";
    }

    @GetMapping("/get-projects")
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> res= projectService.getAllProjects();
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-project")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project res= projectService.addProject(project);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Project(), HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{projId}/employee/{empId}")
    public ResponseEntity<Project> assignEmployeeToProject(@PathVariable int projId, @PathVariable int empId) {
        Project res= projectService.assignEmployeeToProject(projId, empId);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Project(), HttpStatus.NOT_IMPLEMENTED);
    }

}
