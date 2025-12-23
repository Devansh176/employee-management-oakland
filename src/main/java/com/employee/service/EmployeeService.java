package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void registerEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee login(String loginId, String password) {
        Employee emp = employeeRepository.findByLoginId(loginId);

        if(emp == null) {
            throw new RuntimeException("User not registered");
        }

        if(!emp.getPassword().equals(password)) {
            throw new RuntimeException("Password does not match");
        }
        return emp;
    }
}
