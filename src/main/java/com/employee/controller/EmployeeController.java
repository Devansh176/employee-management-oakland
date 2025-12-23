package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "SPRING MVC WORKING";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "registerPage";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee) {
        employeeService.registerEmployee(employee);
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String loginId, @RequestParam String password, Model model) {
        Employee emp = employeeService.login(loginId, password);
        if(emp != null) {
            model.addAttribute("name", emp.getName());
            return "Welcome";
        }
        return "login";
    }
}
