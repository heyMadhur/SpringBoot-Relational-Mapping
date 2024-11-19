package com.learning.MappingInSB.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lap_id_fk")
    @JsonManagedReference  // This will be serialized
    private Laptop laptop;

    @ManyToOne
    @JsonBackReference  // This will be ignored during serialization
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "employee_id"), // Employee ID
            inverseJoinColumns = @JoinColumn(name = "project_id")   // Project ID
    )
    @JsonManagedReference  // This will be serialized
    List<Project> projectList;

}
