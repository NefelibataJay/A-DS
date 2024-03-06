package classical_100.java;

public class Solution28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("mississippi", "issipi"));

    }

    public int strStr1(String haystack, String needle) {
        int cur=0;
        for(;cur<haystack.length()-needle.length()+1;cur++){
            // 查看 haystack字符串 当前未知开始到 needle字符串的长度位置 的子串是否等于 needle字符串
            if(haystack.substring(cur,cur+needle.length()).equals(needle)){
                return cur;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        for (i=0;i<haystack.length();i++){
            for (j=0;j<needle.length() && i+j<haystack.length();j++){
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) break;
        }
        if (j == needle.length()) return i;
        else return -1;
    }
}
