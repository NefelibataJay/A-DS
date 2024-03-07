package classical_100.java;

public class Solution125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution125 solution = new Solution125();
        System.out.println(solution.isPalindrome2(s));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i=0, j=s.length()-1;
        while (j>i){
            if (!Character.isLetterOrDigit(s.charAt(i)) ) {
                i++;
                continue;
            }else if (!Character.isLetterOrDigit(s.charAt(j)) ) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int index = 0;
        // 65 - 90 是大写
        // 97 - 122 是小写
        // 差了32
        for (int i = 0; i < n; i++) {
            // 处理大小写数字， 去除其他符号
            if (s[i] >= 'A' && s[i] <= 'Z') {
                // 大写
                s[index++] = (char) (s[i] + 32);
            } else if ((s[i] >= 'a' && s[i] <= 'z') ||
                    (s[i] <= '9' && s[i] >= '0')) {
                //  小写和数字
                s[index++] = s[i];
            }
        }
        // System.out.println(new String(s, 0, index));
        int left = 0, right = index - 1;
        while (left < right) {
            if (s[left] != s[right]) return false;
            left++;
            right--;
        }

        return true;
    }
}
