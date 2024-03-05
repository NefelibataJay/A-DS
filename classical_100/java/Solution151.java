package classical_100.java;

public class Solution151 {
    public static void main(String[] args) {
        String s = " the  sky is blue ";
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords2(s));

    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].isBlank())
                stringBuilder.append(strings[i]).append(" ");
        }
        // 删除最后一个空格
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
        return stringBuilder.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        String cur = "";

        for (int i = s.length()-1; i>=0; i--){
            if (s.charAt(i) != ' ')
                cur = s.charAt(i) + cur;
            else {
                if (!cur.isEmpty()) stringBuilder.append(cur).append(" ");
                cur = "";
            }
        }

        // 最后一个单词
        stringBuilder.append(cur);

        return stringBuilder.toString();
    }
}
