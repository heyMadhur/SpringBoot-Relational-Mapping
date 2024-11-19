package com.learning.MappingInSB.Service;

import com.learning.MappingInSB.Model.Laptop;
import com.learning.MappingInSB.Repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;


    public Laptop addLaptop(Laptop laptop) {
        return laptopRepo.save(laptop);
    }

    public List<Laptop> getAllLaptop() {
        return laptopRepo.findAll();
    }

}
