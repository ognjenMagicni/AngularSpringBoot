package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDTO {
    Integer idCompany;
    String name;
    String location;
}
