package com.employee.repository;

import com.employee.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee findByLoginId(String loginId) {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Employee where loginId = :loginId",
                        Employee.class
                ).setParameter("loginId", loginId)
                .uniqueResult();
    }
}
