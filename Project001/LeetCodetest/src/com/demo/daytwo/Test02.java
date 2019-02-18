package com.demo.daytwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串的长度，"pwke" 是一个子序列，不是子串。
 */
public class Test02 {
    public static void main(String[] args) {
        String s1 = "pwwkew";
        //String s = "abcabcbb";
        //int num = lengthOfLongestSubstring1(s);
        //System.out.println(num);
        int n = lengthOfLongestSubstring2(s1);
        System.out.println(n);
    }

    public static int lengthOfLongestSubstring1(String s) {  //空指针异常
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0; //最终返回的结果
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i) + 1));
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = 0; //最终返回的结果
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
