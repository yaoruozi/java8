package com.demo.daytwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class Test01 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();  //key是当前数字，value是数组的索引
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 18;
        int[] arr1 = twoSum(arr, target);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }
}
