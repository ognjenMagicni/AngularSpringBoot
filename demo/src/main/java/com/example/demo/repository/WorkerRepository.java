package com.example.demo.repository;

import com.example.demo.model.Worker;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {
    public Worker findByIdWorker(Integer id);

    @Transactional
    @Modifying
    @Query(value= """
            update Worker worker set worker.name= :name, worker.surname = :surname, worker.age = :age where worker.idWorker = :idWorker
            """)
    public void updateWorker(@Param("name")String name, @Param("surname")String surname, @Param("idWorker")Integer idWorker, @Param("age") Integer age);
}
