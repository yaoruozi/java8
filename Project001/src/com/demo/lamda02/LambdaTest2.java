package com.demo.lamda02;

import com.demo.test01.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javafx.scene.input.KeyCode.L;

public class LambdaTest2 {
    /**
     * 这个主要是lambda的一个简单的实战练习
     */
    static List<Employee> empsList = Arrays.asList(
            new Employee("科比", 40, 8343.34),
            new Employee("詹姆斯", 34, 8756.34),
            new Employee("韦德", 37, 7634.22),
            new Employee("保罗", 35, 5468.34),
            new Employee("库里", 31, 6574.89),
            new Employee("诺维茨基", 37, 7834.22),
            new Employee("凯里欧文", 31, 7934.22)
    );

    //使用lambda表达式完成定制排序，先按照年龄排序，年龄一样按照工资排序,
    @Test
    public void test1() {
        Collections.sort(empsList, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : empsList) {
            System.out.println(emp);
        }
    }

    //声明一个处理字符串的方法
    public String dealStr(String str, MyFunction myFunction) {
        return myFunction.getVal(str);
    }

    @Test
    public void test2() {
        /*
         * 这个方法的实现：调用已经声明的dealStr()方法，其中第一个参数传入需要处理的字符串，第二个参数就是myFuncation的具体实现，
         * 因为myfunction在接口声明的时候，这个方法有返回值且有一个参数，所以实现就是如下形式
         * (a)->a.Method()
         * */
        String str = dealStr("abdcd", (str1) -> str1.toUpperCase());
        System.out.println(str);
    }

    //声明一个处理两个long类型数据的方法
    public Long dealLongNum(Long t1, Long t2, DealLongNumber<Long, Long> dealLongNumber) {
        return dealLongNumber.dealLongNumber(t1, t2);
    }

    @Test
    public void test3() {
        Long t3 = dealLongNum(100L, 200L, (x, y) -> x + y);
        System.out.println(t3);
        Long t4 = dealLongNum(100L, 200L, (x, y) -> x * y);
        System.out.println(t4);
    }

}
