package classical_150.java.bitOperation;

public class Solution67 {
    public static void main(String[] args) {
        String a = "1";
        String b = "11";
        Solution67 solution = new Solution67();
        System.out.println(solution.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int ca = 0; // 每一步的下一步
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2); // sum % 2 = 0:1:2
            ca = sum / 2; // 当sum = 2时，ca=1. sum=1或0,ca=0.
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int len1 = a.length(), len2 = b.length();
        int p1 = len1 - 1, p2 = len2 - 1;
        char pre = '0';
        while (p1 >= 0 && p2 >= 0) {
            if (a.charAt(p1) == '1' && b.charAt(p2) == '1') {
                sb.append(pre);
                pre = '1';
            } else if (a.charAt(p1) == '0' && b.charAt(p2) == '0') {
                sb.append(pre);
                pre = '0';
            } else {
                // 一个为0 一个为1
                if (pre == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                    pre = '1';
                }
            }
            p1--;
            p2--;
        }

        while (p1 >= 0) {
            if (pre == '1' && a.charAt(p1) == '1') {
                sb.append('0');
            } else if (pre == '0' && a.charAt(p1) == '0') {
                sb.append('0');
            } else {
                sb.append('1');
                pre = '0';
            }
            p1--;
        }
        while (p2 >= 0) {
            if (pre == '1' && b.charAt(p2) == '1') {
                sb.append('0');
            } else if (pre == '0' && b.charAt(p2) == '0') {
                sb.append('0');
            } else {
                sb.append('1');
                pre = '0';
            }
            p2--;
        }

        if (pre != '0')
            sb.append(pre);

        return sb.reverse().toString();
    }
}