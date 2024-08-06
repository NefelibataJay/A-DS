package leetcode_hot_100.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import javax.print.DocFlavor.STRING;

/**
 * Solution78
 */
public class Solution78 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution78 solution78 = new Solution78();
        solution78.subsets(nums);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>(list));
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        // 利用二进制表示
        // {1，2，3} 3位 从0开始一直到 1 << 3 = 8
        // 000 {}
        // 001 {3}
        // 010 {2}
        // 011 {2,3}
        // ...
        // 111 {1,2,3}
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    t.add(nums[i]);
            }
            res.add(new ArrayList<Integer>(t));
        }
        return res;
    }
}
