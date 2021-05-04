package com.example.laboratorio4.repository;

import com.example.laboratorio4.entity.Departments;

import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {

    @Query(value = "select e.department_id, d.department_name, floor(avg(e.salary)) as `promedio` from employees e\n" +
            "left join departments d\n" +
            "on e.department_id = d.department_id\n" +
            "group by e.department_id",
            nativeQuery = true)
    List<History> reporteSalarioMaximoPorDepar();
}
