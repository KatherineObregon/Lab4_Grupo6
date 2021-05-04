package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int employee_id;

    @Column
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo es obligatorio")
    private String first_name;

    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo es obligatorio")
    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    @Email(message = "Debe tener el formato: nombre@correo.com")
    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo es obligatorio")
    private String email;

    @NotNull(message = "Este campo es obligatorio")
    @NotBlank(message = "Este campo es obligatorio")
    @Size(min =8 , message = "La contraseña debe tener mínimo 8 caracteres")
    private String password;
    private String phone_number;
    @Column(nullable = false)
    private Date hire_date;
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Jobs jobs;


    @NotNull(message = "Este campo es obligatorio")
    @Positive(message = "Tiene que ser mayor que 0")
    private BigDecimal salary;
    private  BigDecimal commission_pct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Departments departaments;
    private int enabled;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(BigDecimal commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Departments getDepartaments() {
        return departaments;
    }

    public void setDepartaments(Departments departaments) {
        this.departaments = departaments;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
