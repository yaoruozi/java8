package com.demo.test01.serviceimpl;

import com.demo.test01.model.Employee;
import com.demo.test01.service.FilterEmployeeByProperty;

public class FIlterEmployeeBySalaryImpl implements FilterEmployeeByProperty<Employee> {
    @Override
    public boolean getEmployees(Employee employee) {
        return employee.getSalary() > 5500.00;
    }
}
