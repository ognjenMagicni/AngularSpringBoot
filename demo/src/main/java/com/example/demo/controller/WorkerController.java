package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.WorkerCompany;
import com.example.demo.dto.WorkerDTO;
import com.example.demo.model.Worker;
import com.example.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("worker")
@CrossOrigin
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = workerService.findAll();
        for(Worker worker: workers)
            System.out.println(worker);
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(workerService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Worker> save(@RequestBody WorkerDTO  worker){
        System.out.println("WorkerController:save started");
        Worker newWorker = new Worker(worker.getIdWorker(),worker.getName(),worker.getSurname(),worker.getAge());
        Worker postedWorker = workerService.save(newWorker);
        return new ResponseEntity<>(postedWorker,HttpStatus.OK);
    }

    @PostMapping("addcompany")
    public ResponseEntity<Worker> addCompany(@RequestBody WorkerCompany workerCompany){
        Worker worker = workerService.addCompany(workerCompany.getIdWorker(),workerCompany.getIdCompany());
        return new ResponseEntity<>(worker,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateCompany(@RequestBody WorkerDTO worker){
        workerService.updateWorker(worker);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        System.out.println("WorkerController:deleteById started");
        workerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("addcompany")
    public ResponseEntity<Worker> removeCompany(@RequestBody WorkerCompany workerCompany){
        Worker worker = workerService.removeCompany(workerCompany.getIdWorker(),workerCompany.getIdCompany());
        return new ResponseEntity<>(worker,HttpStatus.OK);
    }
}
