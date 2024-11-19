package com.learning.MappingInSB.Repository;

import com.learning.MappingInSB.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
