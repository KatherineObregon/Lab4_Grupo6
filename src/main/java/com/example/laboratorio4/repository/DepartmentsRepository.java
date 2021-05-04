package com.example.laboratorio4.repository;

import com.example.laboratorio4.entity.Departments;

import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {

    @Query(value = "",/////falta query
            nativeQuery = true)
    List<History> reporteSalarioMaximoPorDepar();
}
