package classical_150.java.binarySearch;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = { -1, -1 };
        if (n == 0)
            return res;

        int low = 0, high = n - 1;
        int index = -1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (index != -1) {
            for (int i = index; i < n; i++) {
                if (nums[i] == target)
                    res[1] = i;
                else
                    break;
            }

            for (int i = index; i > 0; i--) {
                if (nums[i] == target)
                    res[0] = i;
                else
                    break;
            }
        }

        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; // 重点
                // 把右指针移动到当前位置middle-1，就是继续循环找当前first位置的前半段是否还有
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1; // 重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 3, 3, 4, 5, 9 };
        Solution34 solution = new Solution34();
        solution.searchRange2(nums, 3);
    }
}
