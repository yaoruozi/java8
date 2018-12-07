package com.demo.one;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * lambda进阶练习
 */
public class Test {
    public static void main(String[] args) {

    }

    //使用最原始的匿名内部类进行两个int型数据大小的比较
    @org.junit.Test
    public void test() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    //对上面的方法进行升级，使用lambda表达式
    @org.junit.Test
    public void testLambda() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> int_set = new TreeSet<>(com);
    }


}
