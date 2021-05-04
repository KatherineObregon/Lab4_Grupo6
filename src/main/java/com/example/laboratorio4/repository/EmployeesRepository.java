package com.example.laboratorio4.repository;

import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {



    @Query(value = "",/////falta query pero no piden
            nativeQuery = true)
    List<History> cantidadEmpleadosPorPais();

    @Query(value = "",/////falta query
            nativeQuery = true)
    List<History> listarEmpleadoDep();

}
