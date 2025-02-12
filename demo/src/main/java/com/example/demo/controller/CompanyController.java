package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.WorkerCompany;
import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("company")
@CrossOrigin
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(companyService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody  CompanyDTO companyDTO){
        Company company = new Company(companyDTO);
        return new ResponseEntity<>(companyService.save(company), HttpStatus.OK);
    }

    @PostMapping("addworker")
    public ResponseEntity<Company> addWorker(@RequestBody WorkerCompany workerCompany){
        return new ResponseEntity<>(companyService.addWorker(workerCompany.getIdCompany(),workerCompany.getIdWorker()), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateCompany(@RequestBody CompanyDTO company){
        companyService.updateCompany(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("addworker")
    public ResponseEntity<Company> removeWorker(@RequestBody WorkerCompany workerCompany){
        System.out.println("CompanyController:removeWorker started");
        return new ResponseEntity<>(companyService.removeWorker(workerCompany.getIdCompany(),workerCompany.getIdWorker()), HttpStatus.OK);
    }


}
