package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.WorkerDTO;
import com.example.demo.model.Company;
import com.example.demo.model.Worker;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    CompanyRepository companyRepository;

    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Worker findById(Integer id){
        return workerRepository.findByIdWorker(id);
    }

    public Worker save(Worker worker){
        return workerRepository.save(worker);
    }

    public void updateWorker(WorkerDTO worker){
        workerRepository.updateWorker(worker.getName(),worker.getSurname(),worker.getIdWorker(),worker.getAge());
    }

    public void deleteById(Integer id){
        workerRepository.deleteById(id);
    }

    public Worker addCompany(Integer idWorker, Integer idCompany){
        Worker worker = workerRepository.findByIdWorker(idWorker);
        Company company = companyRepository.findByIdCompany(idCompany);

        worker.addCompany(company);
        return workerRepository.save(worker);
    }

    public Worker removeCompany(Integer idWorker, Integer idCompany){
        Worker worker = workerRepository.findByIdWorker(idWorker);
        Company company = companyRepository.findByIdCompany(idCompany);

        worker.removeCompany(company);
        return workerRepository.save(worker);
    }
}
