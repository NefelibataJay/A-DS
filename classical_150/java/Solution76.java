package classical_150.java;

import java.util.HashMap;

public class Solution76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution76.minWindow(s,t));

    }

    // 返回 s 中涵盖 t 所有字符的最小子串。
    public String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int[] num1 = new int[128]; // 修改数组长度为 128，确保覆盖所有 ASCII 字符
        int count = t.length();
        for (char temp : t1) {
            num1[temp]++;
        }
        int start = -1;
        int l = 0;
        int end = s.length();
        int minLength = Integer.MAX_VALUE; // 用于记录最小窗口的长度
        int minStart = -1; // 用于记录最小窗口的起始位置

        for (int i = 0; i < s.length(); i++) {
            if (num1[s1[i]] > 0) {
                count--;  // 只有 t 中的字符才会进入
            }
            num1[s1[i]]--; // 将此处移到if条件内部
            while (count == 0) {
                if (i - l + 1 < minLength) {
                    minLength = i - l + 1;
                    minStart = l;
                }
                if (num1[s1[l]] >= 0) { // 修改判断条件
                    count++;
                }
                num1[s1[l]]++;
                l++;
            }
        }

        return minStart == -1 ? "" : s.substring(minStart, minStart + minLength); // 返回最小窗口的子串
    }

    public String minWindow1(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }

        int[] res = {0,s.length()+2};  // 初始化最大的区间

        // 可以这样认为，needMap是记录一个滑动窗口，这个窗口记录了当前的窗口内的元素在窗口内的 -次数 （注意是负的）
        // 所以在遍历字符串s的时候进入滑动窗口needMap的元素都会-1，而出去的元素都会+1
        HashMap<Character, Integer> needMap = new HashMap<>();  // 记录滑动窗口内所有出现的字母次数
        int needCount = t.length(); // 需要最小需要的字符个数

        // 我们把需要的元素value +1,
        for (int i=0; i<t.length(); i++){
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0)+1); // 记录所有需要的元素，value 记录可以重复的次数
        }

        for (int j=0,i=0; j<s.length() && i<s.length(); j++){
            // 滑动窗口右指针j ， 左指针i
            needMap.put(s.charAt(j),needMap.getOrDefault(s.charAt(j),0)); // 当前元素进入滑动窗口
            if (needMap.get(s.charAt(j))>0) needCount--; // 只有当前元素需要时才会进入，即只有开始的时候被初始化的时候才会 value>0
            needMap.put(s.charAt(j),needMap.get(s.charAt(j))-1);  // 当前元素出现的次数 -1

            if (needCount == 0){ // 当前滑动 窗口包含了所有的 t 元素
                while (i<j){  //
                    if (needMap.get(s.charAt(i)) == 0) break;  // 当前元素为0表示已经被遍历过且是在t中的，没有在t中的元素经过前面的步骤，value一定小于0
                    needMap.put(s.charAt(i), needMap.get(s.charAt(i))+1);  // 当前元素退出滑动窗口，让其在needMap中的元素+1。
                    i++; // 滑动窗口左指针后移
                }
                // 经过上面的遍历， 目前滑动窗口一定包含了所有需要的元素，记录下当前的长度
                if (j-i < res[1]-res[0]){
                    res[1] = j;
                    res[0] = i;
                }

                // 当前结果并不是最小的，我们还要继续向后遍历
                // 此时当前左指针指向的就是滑动窗口中第一个 被需要 的元素 ，即这个元素一定在t中，此时右指针也是一样
                needMap.put(s.charAt(i), needMap.get(s.charAt(i))+1);  // 我们让左指针当前的元素 出 滑动窗口
                i++; // 左指针右移
                needCount++; // 由于我们取出了一个被需要的元素，当前的needCount就需要+1.
            }
        }

        return (res[1] > s.length()) ? "" : s.substring(res[0],res[1]+1); // 如果res[1]还是初始值代表没有被更新过
    }
}
