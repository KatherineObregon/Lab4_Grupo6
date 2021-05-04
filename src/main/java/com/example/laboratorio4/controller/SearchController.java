package com.example.laboratorio4.controller;


import com.example.laboratorio4.repository.DepartmentsRepository;
import com.example.laboratorio4.repository.EmployeesRepository;
import com.example.laboratorio4.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    HistoryRepository historyRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalario (Model model){
        model.addAttribute("listaEmpleadosMayorSalario", historyRepository.listaEmpleadosMayorSalario());
        return "Search/lista2";
    }

    @PostMapping("/busqueda") //falta validar que ingrese numeros
    public String buscar (@RequestParam("textBuscador") String textBuscador, Model model){
        int salary = -1;
        try{
            salary = Integer.parseInt(textBuscador);
        }catch (NumberFormatException e){

        }
        if(salary==-1){
            model.addAttribute("error", true);
            return "redirect:/Salario";
        }else{
            model.addAttribute("listaEmpleadosMayorSalario", historyRepository.buscarInputBuscador(salary));
            model.addAttribute("texto", textBuscador);
            return "Search/lista2";
        }
    }

    @GetMapping(value = "/Filtro2")//falta implementar
    public String reporteSalarioMaximoPorDepar (Model model){
        model.addAttribute("reporteSalarioMaximoPorDepar", departmentsRepository.reporteSalarioMaximoPorDepar());
        return "/Search/salario";
    }

    @GetMapping("/listar")//falta implementar
    public String listarEmpleadoDep(@RequestParam("depId") int depId,Model model) {
        model.addAttribute("listarEmpleadoDep", employeesRepository.findByDepartment_id(depId));
        return "/Search/lista3";
    }



}
