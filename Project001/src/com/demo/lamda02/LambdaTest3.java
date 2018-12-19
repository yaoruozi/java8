package com.demo.lamda02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 主要学习练习java8的四大内置函数式接口
 */

public class LambdaTest3 {
    //消费型接口 Consumer<T> {void accept(T t)}
    //没有返回值，有一个参数的函数式接口
    public void buySth(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test1() {
        buySth(1000, (money) -> System.out.println("买东西消费了" + money + "元"));
    }


    //供给型接口 Supplier<T> {T get()},主要用于产生一些对象
    //有返回值，但是没有参数
    public List<Integer> getSomeMoney(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer m = supplier.get();
            list.add(m);
        }
        return list;
    }

    @Test
    public void test2() {
        List<Integer> list = getSomeMoney(10, () -> (int) (Math.random() * 100));
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    //函数型接口 Function<T,R> {apply(t,r)}
    //声明了函数类型以及返回值
    public String dealStr(String str, Function<String, String> function) {
        return function.apply(str);
    }

    @Test
    public void test3() {
        String str = dealStr("andbbdnsbns", (str1) -> str1.toUpperCase());
        System.out.println(str);

        String str2 = dealStr("andbbdnsbns", (str1) -> str1.substring(2, 5));
        System.out.println(str2);
    }

    //断言型接口 Predicate<T> {boolean test(T t)}
    //满足某些条件去执行的接口
    public List<String> getFilterStrList(List<String> list, Predicate<String> predicate) {
        List<String> list1 = new ArrayList<String>();
        for (String str : list) {
            if (predicate.test(str)) {
                list1.add(str);
            }
        }
        return list1;
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("Kobe Bryant", "Lerbron James", "Curry", "Harden", "Paul");
        List<String> strList = getFilterStrList(list, (str) -> str.length() > 5);
        for (String str : strList) {
            System.out.println(str);
        }
    }

}
