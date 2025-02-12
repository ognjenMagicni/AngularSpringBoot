package com.example.demo.repository;

import com.example.demo.model.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    public Company findByIdCompany(Integer id);

    @Transactional
    @Modifying
    @Query(value= """
            update Company company set company.name= :name, company.location = :location where company.idCompany = :idCompany
            """)
    public void updateCompany(@Param("name")String name, @Param("location")String location,@Param("idCompany")Integer idCompany);
}
