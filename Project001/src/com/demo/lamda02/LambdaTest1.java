package com.demo.lamda02;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 主要练习lambda的基础语法
 */
public class LambdaTest1 {
    /**
     * 情景一：无返回值并且没有参数列表
     */
    @Test
    public void lambdaTest1() {
        Runnable r = new Runnable() {
            int num = 1;  //这个在JDK1.8以前必须显式的声明为final的

            @Override
            public void run() {
                System.out.println("new Runnable..." + num);
            }
        };
        r.run();
        System.out.println("-------------------------接下来看lambda表达式");
        Runnable r1 = () -> System.out.println("new Runnable....");
        r1.run();
    }

    /**
     * 情景二：有一个参数但是没有返回值。。(t) -> System.out.println(t)
     * 如果只有一个参数，参数的小括号可以不写
     */
    @Test
    public void lambdaTest2() {
        Consumer<String> con = (t) -> System.out.println(t);
        con.accept("厉害了，我的哥...");
    }

    /**
     * 情景三：有参数并且有返回值时，lambda体语句是多条，这个时候lambda体必须用{}进行包裹;
     * <p>
     * 当然：lambda体中只有一条语句时，return和{}可以省略不写
     * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
     */
    @Test
    public void lambdaTest3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("x:" + x + ",y:" + y);
            return Integer.compare(x, y);
        };
    }

}
