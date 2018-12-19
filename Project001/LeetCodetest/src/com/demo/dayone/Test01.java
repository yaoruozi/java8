package com.demo.dayone;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 例如：输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * "pwwkew"
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.next();
            //String[] strs = str.split(" ");
            char strs[] = str.toCharArray();
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < strs.length; i++) {
                set.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(strs[i]==strs[j]){
                        set.clear();
                    }
                    set.add(strs[j]);
                }
            }
            System.out.println("最长子串长度:" + set.size());
        }
    }
}
