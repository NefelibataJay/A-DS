package classical_150.java.pointer;

public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] height = {1,8,1,8,20000,4,5,3,7};
        System.out.println(solution11.maxArea(height));
    }
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1 ;
        int maxArea = 0;
        while(left < right){
            int h = Math.min(height[left], height[right]);  // 高
            int b = right - left; // 底
            int curArea = h * b;
            if (curArea>=maxArea) maxArea=curArea;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
