package classical_150.java.hash;

/*
 * @author lawrence
 */

import java.util.HashSet;

public class Solution219 {
    public static void main(String[] args) {
Solution219 solution = new Solution219();
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        // 题目要求 i 和 j 之间的差值小于等于 k，所以我们只需要维护一个大小为 k 的窗口区间即可

        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i]))
                // 如果窗口区间内有重复的元素，
                return true;

            set.add(nums[i]);
            if(set.size()>k)
                // 如果窗口区间大于 k，我们就移除最前面的元素
                set.remove(nums[i-k]);
        }
        return false;

    }
}
