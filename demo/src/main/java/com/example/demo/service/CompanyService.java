package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.model.Company;
import com.example.demo.model.Worker;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    WorkerRepository workerRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company save(Company company){
        Company companyInserted = companyRepository.save(company);
        return companyInserted;
    }
    public void updateCompany(CompanyDTO company){
        companyRepository.updateCompany(company.getName(),company.getLocation(),company.getIdCompany());
    }
    public void deleteById(Integer id){
        companyRepository.deleteById(id);
    }

    public Company findById(Integer id){
        Company company = companyRepository.findByIdCompany(id);
        return company;
    }

    public Company addWorker(Integer idCompany, Integer idWorker){
        Company comapny = companyRepository.findByIdCompany(idCompany);
        Worker worker = workerRepository.findByIdWorker(idWorker);
        comapny.addWorker(worker);
        return companyRepository.save(comapny);
    }

    public Company removeWorker(Integer idCompany, Integer idWorker){

        Company comapny = companyRepository.findByIdCompany(idCompany);
        Worker worker = workerRepository.findByIdWorker(idWorker);
        comapny.removeWorker(worker);
        return companyRepository.save(comapny);
    }
}
