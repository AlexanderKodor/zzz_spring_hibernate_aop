package com.alex.spring.mvc_hibernate_aop.controller;

import com.alex.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.alex.spring.mvc_hibernate_aop.entity.Employee;
import com.alex.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @Transactional
    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);
        return "employee-info";
    }
    @RequestMapping("/deleteInfo")
    public String deleteInfo(@RequestParam("employeeId") int id, Model model){
        employeeService.deleteInfo(id);
        return "redirect:/";
    }
}
