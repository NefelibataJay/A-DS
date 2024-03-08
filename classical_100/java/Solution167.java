package classical_100.java;

public class Solution167 {

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        int[] numbers = new int[]{5,25,75};
        int target = 9;
        int[] result = solution167.twoSum(numbers, target);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = 1;
        while (left < numbers.length-1){
            while (right < numbers.length){
                if (numbers[left] + numbers[right] == target){
                    return new int[]{left+1, right+1};
                } else if (numbers[left] + numbers[right] > target){
                    break;
                }
                right++;
            }
            left++;
            right = left+1;
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int i = 0; // 左指针
        int j = numbers.length - 1;  // 右指针

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                // 当前和小于目标值，左指针右移
                // 因为数组是有序的，左指针右移后的值肯定比之前的大
                i++;
            } else if (sum > target) {
                // 当前和大于目标值，右指针左移
                // 因为数组是有序的，右指针左移后的值肯定比之前的小
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }

}
