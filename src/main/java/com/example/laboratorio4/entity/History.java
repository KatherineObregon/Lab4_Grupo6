package com.example.laboratorio4.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "job_history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_history_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
    @Column(name = "start_date")
    private String hiredate;
    @Column(name = "end_date",nullable = false)
    private String enddate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentid;

    public int getJobhistoryid() {
        return id;
    }

    public void setJobhistoryid(int id) {
        this.id = id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employeeid) {
        this.employee = employeeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs jobid) {
        this.job = jobid;
    }

    public Departments getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Departments departmentid) {
        this.departmentid = departmentid;
    }

    public long setHiredate(long time) {
        return 0;
    }
}
