package classical_150.java.backtracking;

import java.util.*;

public class Solution47 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                /*
                 * 前一个数和当前的数相等
                 * 
                 * 对于 !visited[i - 1]来去重主要是通过限制一下两个相邻的重复数字的访问顺序 对于两个相同的数{1,1}，我们将其命名为{1a,1b},
                 * 1a表示第一个1，1b表示第二个1； 那么，不做去重的话，会有两种重复排列{1a,1b}, {1b,1a}，我们只需要取其中任意一种排列；
                 * 为了达到这个目的，限制一下1a, 1b访问顺序即可。 比如我们只取{1a,1b}那个排列的话，只有当nums[i-1]被访问之后我们才去访问
                 * nums[i]，也就是如果nums[i-1]没有被访问的话则continue
                 */
                continue;
            }

            stack.addLast(nums[i]);
            System.out.println("前 => " + stack);

            visited[i] = true;
            backtrack(nums);
            visited[i] = false;

            stack.removeLast();
            System.out.println("后 => " + stack);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        Solution47 solution = new Solution47();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
