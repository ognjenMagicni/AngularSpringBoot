package com.example.demo.model;

import com.example.demo.dto.CompanyDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="company")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Company {
    @Id
    @Column(name="idCompany")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer idCompany;

    @Column(name="name")
    String name;

    @Column(name="location")
    String location;

    @JsonManagedReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="workerCompany",
        joinColumns = @JoinColumn(name="fkCompany"),
            inverseJoinColumns = @JoinColumn(name="fkWorker")
    )
    @ToString.Exclude
    List<Worker> workers;


    public void addWorker(Worker worker){
        workers.add(worker);
    }
    public void removeWorker(Worker worker){
        workers.remove(worker);
    }

    public Company(CompanyDTO dto) {
        this.idCompany = dto.getIdCompany();
        this.name = dto.getName();
        this.location = dto.getLocation();
        this.workers = null;
    }
}
