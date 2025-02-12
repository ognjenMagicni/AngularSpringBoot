package com.example.demo.dto;

import com.example.demo.model.Company;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {
    Integer idWorker;
    String name;
    String surname;
    Integer age;
}
