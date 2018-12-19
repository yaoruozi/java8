package com.demo.lamda02;

/**
 * 声明一个函数式接口，声明两个泛型参数，一个代表类型，一个代表参数，从而具体实现这个函数式接口，计算两个long
 * 类型的数字的和以及乘积
 */
public interface DealLongNumber<T, R> {

    public T dealLongNumber(R r1, R r2);
}
