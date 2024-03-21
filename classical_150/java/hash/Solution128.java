package classical_150.java.hash;

import java.util.*;

/*
 * @author lawrence
 */
public class Solution128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive1(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num)) continue;
            numSet.add(num);
        }

        int maxStreak = 1;  // 数组中的元素都不连续，则默认为1
        for (int num : numSet){
            if (!numSet.contains((num-1))){
                // 若当前数字减一的值不在set集合中
                // 也就是，当前元素的上一个连续值不存在时
                int curNum = num;
                int curStreak = 1;

                while (numSet.contains(curNum + 1)) {
                    // 遍历当前元素后面的连续值是否存在
                    // 存在则从后面的连续值一直开始查找
                    curNum += 1;
                    curStreak += 1;
                }

                // 获取最大连续数量
                maxStreak = Math.max(maxStreak, curStreak);
            }

        }
        return maxStreak;
    }

    public int longestConsecutive1(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();  // key 是元素值， value 是 连续区间的长度
        int maxL = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) { // 当前数未在map中
                int left = map.getOrDefault(num - 1, 0);  // 获取当前元素上一个连续值的连续区间长度
                int right = map.getOrDefault(num + 1, 0);  // 获取当前元素下一个连续值的连续区间长度
                int curL = left + right + 1;  // 计算当前元素的连续区间长度

                map.put(num, curL); // 存入map中
                map.put(num - left, curL);  // num + left 更新当前连续区间中，最小的那个元素对应的区间长度
                // left 是当前元素的左区间长度，num+left 就是当前区间最左边的那个元素值
                // right 是当前元素的右区间长度
                map.put(num + right, curL); // num + right 更新当前连续区间中，最大的那个元素对应的区间长度

                if (curL>maxL) maxL=curL; // 更新最大连续区间长度
            }
        }

        return maxL;
    }
}
