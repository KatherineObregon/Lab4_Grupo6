package com.example.laboratorio4.repository;

import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value = "select jh.* from job_history jh\n" +
            "left join employees e on jh.employee_id=e.employee_id\n" +
            "left join jobs j on jh.job_id=j.job_id where e.salary > 8000",
            nativeQuery = true)
    List<History> listaEmpleadosMayorSalario();


    @Query(value = "select jh.* from job_history jh\n" +
            "left join employees e on jh.employee_id=e.employee_id\n" +
            "left join jobs j on jh.job_id=j.job_id where e.salary > 8000 and e.salary = ?1",
            nativeQuery = true)
    List<History> buscarInputBuscador(int salary);

}
