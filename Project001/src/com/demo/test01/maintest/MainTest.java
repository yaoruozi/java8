package com.demo.test01.maintest;

import com.demo.test01.model.Employee;
import com.demo.test01.service.FilterEmployeeByProperty;
import com.demo.test01.serviceimpl.FIlterEmployeeBySalaryImpl;
import com.demo.test01.serviceimpl.FilterEmployeeByAgeImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    //需求，过滤出所有的年龄大于34岁的员工
    static List<Employee> empsList = Arrays.asList(
            new Employee("科比", 40, 8343.34),
            new Employee("詹姆斯", 34, 8756.34),
            new Employee("韦德", 37, 7634.22),
            new Employee("保罗", 35, 5468.34),
            new Employee("库里", 31, 6574.89)
    );

    //实现方式一，使用最传统的方式
    private List<Employee> getEmployeesByAge(List<Employee> empsList) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : empsList) {
            if (e.getAge() > 34) {
                emps.add(e);
            }
        }
        return emps;
    }

    //ok,这个时候又来了一个需求，我们要找到工资大于5500的员工，还采用最上面的最传统的方式
    private List<Employee> getEmployeesBySalary(List<Employee> empsList) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : empsList) {
            if (e.getSalary() > 5500.00) {
                emps.add(e);
            }
        }
        return emps;//可以看到冗余代码一大堆
    }

    //实现方式二：有了上面的冗余代码，我们优化一下，使用一下设计模式
    public List<Employee> getEmployeeInfoByProperty(List<Employee> empsList, FilterEmployeeByProperty<Employee> emp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : empsList) {
            if (emp.getEmployees(e)) {
                emps.add(e);
            }
        }
        return emps;  //这样的话我们的实现方法只有一个，只需要传入不同的实现类即可，减少了一部分冗余,但是每次需求变更我们都需要
        //创建一个实现类，也比较麻烦
    }

    //优化方式三，我们使用匿名内部类
    @Test
    public void getEmployeeByAge() {
        List<Employee> emps = getEmployeeInfoByProperty(empsList, new FilterEmployeeByProperty<Employee>() {
            @Override
            public boolean getEmployees(Employee employee) {
                return employee.getAge() > 34;
            }
        });
        for (Employee e : emps) {
            System.out.println(e);
        }
    }

    //优化方式四：使用lambda表达式
    @Test
    public void testGetEmployeeByage() {
        List<Employee> list = getEmployeeInfoByProperty(empsList, (employee) -> employee.getAge() > 34);
        list.forEach(System.out::println);
    }

    //优化方式五：上面尽管已经实现的不错了，但是我们还是需要依赖额外的一个方法，所以使用一下StreamAPI
    @Test
    public void testGetEmployeeByAge1() {
        empsList.stream()
                .filter((e) -> e.getAge() > 34)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        //验证第一种实现方式
        MainTest m1 = new MainTest();
        List<Employee> emplist = m1.getEmployeesByAge(empsList);
        for (Employee e : emplist) {
            System.out.println("name:" + e.getName() + ",age:" + e.getAge() + ",salary:" + e.getSalary());
        }
        System.out.println("------------------------------");
        //验证使用第一种方式实现工资的需求
        List<Employee> emplist1 = m1.getEmployeesBySalary(empsList);
        for (Employee e : emplist1) {
            System.out.println("name:" + e.getName() + ",age:" + e.getAge() + ",salary:" + e.getSalary());
        }
        System.out.println("开始验证第二种实现方式---------验证年龄");
        List<Employee> emplist2 = m1.getEmployeeInfoByProperty(empsList, new FilterEmployeeByAgeImpl());
        for (Employee e : emplist2) {
            System.out.println("name:" + e.getName() + ",age:" + e.getAge() + ",salary:" + e.getSalary());
        }
        System.out.println("-----------------验证工资");
        List<Employee> emplist3 = m1.getEmployeeInfoByProperty(empsList, new FIlterEmployeeBySalaryImpl());
        for (Employee e : emplist3) {
            System.out.println("name:" + e.getName() + ",age:" + e.getAge() + ",salary:" + e.getSalary());
        }

    }
}
