package com.learning.MappingInSB.Controller;

import com.learning.MappingInSB.Model.Employee;
import com.learning.MappingInSB.Model.Laptop;
import com.learning.MappingInSB.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/")
    private String getDefaultLaptop(){
        return "Welcome to Laptop Controller";
    }

    @GetMapping("/get-laptops")
    public ResponseEntity<List<Laptop>> getLaptops(){
        List<Laptop> res= laptopService.getAllLaptop();
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-laptop")
    public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop){
        Laptop res= laptopService.addLaptop(laptop);
        if(res!=null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Laptop(), HttpStatus.NOT_IMPLEMENTED);
    }

}
