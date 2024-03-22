package com.rudevelopers.healthcare.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Doctor {


    @Id
    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}


