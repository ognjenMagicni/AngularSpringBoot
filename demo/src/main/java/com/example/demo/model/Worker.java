package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="worker")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @Column(name="idWorker")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer idWorker;

    @Column(name="name")
    String name;

    @Column(name="surname")
    String surname;

    @Column(name="age")
    Integer age;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="workerCompany",
            joinColumns = @JoinColumn(name="fkWorker"),
            inverseJoinColumns = @JoinColumn(name="fkCompany")
    )
    @ToString.Exclude
    @JsonBackReference
    List<Company> companies;

    public Worker(Integer idWorker, String name, String surname, Integer age){
        this.idWorker = idWorker;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void addCompany(Company company){
        this.companies.add(company);
    }

    public void removeCompany(Company company){
        this.companies.remove(company);
    }
}
