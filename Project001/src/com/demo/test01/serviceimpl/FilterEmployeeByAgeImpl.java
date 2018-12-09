package com.demo.test01.serviceimpl;

import com.demo.test01.model.Employee;
import com.demo.test01.service.FilterEmployeeByProperty;

public class FilterEmployeeByAgeImpl implements FilterEmployeeByProperty<Employee> {
    @Override
    public boolean getEmployees(Employee employee) {
        return employee.getAge() > 34;
    }
}
