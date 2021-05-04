package com.example.laboratorio4.repository;

import com.example.laboratorio4.dtos.EmployeeDurationDto;
import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    List<Employees> findByDepartaments(int depId);

    @Query(value = "select e.first_name, e.last_name, j.job_title, jh.start_date, jh.end_date,\n" +
            "floor(DATEDIFF(jh.end_date, jh.start_date)/365) as `anios`,\n" +
            "floor((DATEDIFF(jh.end_date, jh.start_date)-(floor(DATEDIFF(jh.end_date, jh.start_date)/365))*365)/30) as `meses`\n" +
            "from job_history jh\n" +
            "left join jobs j on jh.job_id=j.job_id\n" +
            "left join employees e on jh.employee_id=e.employee_id\n" +
            "order by `anios` desc",
            nativeQuery = true)
    List<EmployeeDurationDto> listarEmpleadosConAnios();

}
