package leetcode_hot_100.sub;

import java.util.*;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] res = new int[] { 0, s.length() + 1 };
        HashMap<Character, Integer> need = new HashMap<>();
        int needcount = t.length();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int left = 0, right = 0; left < s.length() && right < s.length(); right++) {
            char c = s.charAt(right);
            need.put(c, need.getOrDefault(c, 0));

            if (need.get(c) > 0)
                needcount--;

            need.put(c, need.get(c) - 1);

            if (needcount == 0) {
                while (left < right) {
                    if (need.get(s.charAt(left)) == 0)
                        break;
                    need.put(s.charAt(left), need.get(s.charAt(left)) + 1);
                    left++;
                }

                if (right - left < res[1] - res[0]) {
                    res[0] = left;
                    res[1] = right;
                }

                need.put(s.charAt(left), need.get(s.charAt(left)) + 1);
                left++;
                needcount++;
            }
        }

        return res[1] > s.length() ? "" : s.substring(res[0], res[1] + 1);
    }

    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] res = { 0, s.length() + 2 }; // 初始化最大的区间

        // 可以这样认为，needMap是记录一个滑动窗口，这个窗口记录了当前的窗口内的元素在窗口内的 -次数 （注意是负的）
        // 所以在遍历字符串s的时候进入滑动窗口needMap的元素都会-1，而出去的元素都会+1
        HashMap<Character, Integer> needMap = new HashMap<>(); // 记录滑动窗口内所有出现的字母次数
        int needCount = t.length(); // 需要最小需要的字符个数

        // 我们把需要的元素value +1,
        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1); // 记录所有需要的元素，value 记录可以重复的次数
        }

        for (int j = 0, i = 0; j < s.length() && i < s.length(); j++) {
            // 滑动窗口右指针j ， 左指针i
            needMap.put(s.charAt(j), needMap.getOrDefault(s.charAt(j), 0)); // 当前元素进入滑动窗口
            if (needMap.get(s.charAt(j)) > 0)
                needCount--; // 只有当前元素需要时才会进入，即只有开始的时候被初始化的时候才会 value>0
            needMap.put(s.charAt(j), needMap.get(s.charAt(j)) - 1); // 当前元素出现的次数 -1

            if (needCount == 0) { // 当前滑动 窗口包含了所有的 t 元素
                while (i < j) { //
                    if (needMap.get(s.charAt(i)) == 0)
                        break; // 当前元素为0表示已经被遍历过且是在t中的，没有在t中的元素经过前面的步骤，value一定小于0
                    needMap.put(s.charAt(i), needMap.get(s.charAt(i)) + 1); // 当前元素退出滑动窗口，让其在needMap中的元素+1。
                    i++; // 滑动窗口左指针后移
                }
                // 经过上面的遍历， 目前滑动窗口一定包含了所有需要的元素，记录下当前的长度
                if (j - i < res[1] - res[0]) {
                    res[1] = j;
                    res[0] = i;
                }

                // 当前结果并不是最小的，我们还要继续向后遍历
                // 此时当前左指针指向的就是滑动窗口中第一个 被需要 的元素 ，即这个元素一定在t中，此时右指针也是一样
                needMap.put(s.charAt(i), needMap.get(s.charAt(i)) + 1); // 我们让左指针当前的元素 出 滑动窗口
                i++; // 左指针右移
                needCount++; // 由于我们取出了一个被需要的元素，当前的needCount就需要+1.
            }
        }

        return (res[1] > s.length()) ? "" : s.substring(res[0], res[1] + 1); // 如果res[1]还是初始值代表没有被更新过
    }
}
