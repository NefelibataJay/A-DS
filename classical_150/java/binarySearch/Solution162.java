package classical_150.java.binarySearch;

public class Solution162 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        Solution162 solution = new Solution162();
        System.out.println(solution.findPeakElement(nums));
    }

    // 峰值元素是指其值严格大于左右相邻值的元素。
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) { // 其实就是在寻找最大值，每次都向值大的那一边走
            int mid = ((high - low) >> 1) + low;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0)
                // (mid-1) 越界 或 nums[mid] >= nums[mid-1] 时第一个判断为 -1
                // (mid+1) 越界 或 nums[mid] > nums[mid+1] 时第二个判断为 1
                // 也就是说，当前 nums[mid-1] < nums[mid] > nums[mid+1]
                return mid;

            if (compare(nums, mid, mid + 1) < 0) // num[mid + 1] >= num[mid] 或 mid+1 越界
                low = mid + 1; // 大的数在右边
            else
                high = mid - 1; // 大的数在左边
        }

        return ans;
    }

    public int findPeakElement1(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        int idx = (int) (Math.random() * n);

        while (!(compare(nums, idx - 1, idx) < 0 && compare(nums, idx, idx + 1) > 0)) {
            if (compare(nums, idx, idx + 1) < 0) {
                idx += 1;
            } else {
                idx -= 1;
            }
        }

        return idx;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[] { 0, 0 };
        }
        return new int[] { 1, nums[idx] };
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) { // 检查越界情况
            return num1[0] > num2[0] ? 1 : -1; // 如果 idx2 越界了就返回 1，如果 idx1 越界了就返回 -1
        }
        if (num1[1] == num2[1]) { // 检查是否相等
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }
}
