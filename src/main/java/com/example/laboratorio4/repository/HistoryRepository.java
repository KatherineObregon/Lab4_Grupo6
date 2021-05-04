package com.example.laboratorio4.repository;

import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value = "SELECT * FROM job_history\n" +
            "WHERE employee_id NOT IN (SELECT max(salary) FROM employees);",
            nativeQuery = true)
    List<History> listaEmpleadosMayorSalario();


    @Query(value = "SELECT h.*, j.max_salary FROM job_history h, jobs j \n" +
            "WHERE h.employee_id NOT IN (SELECT max(salary) FROM employees)\n" +
            "AND j.max_salary= ?1\n" +
            "group by h.job_history_id;",
            nativeQuery = true)
    List<History> buscarInputBuscador(String textBuscador);

}
