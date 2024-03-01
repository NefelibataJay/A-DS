package classical_100.java;

public class Solution13 {

    private int getValue(String ch) {
        return switch (ch) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default -> 0;
        };
    }

    private int getNum(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public int romanToInt(String s) {
        // 把一个小值放在大值的左边，就是做减法，否则为加法。
        int sum = 0;
        String[] strings = s.split("");
        int before = 0;
        for (int i=strings.length-1; i>=0; i--){
            int value = getValue(strings[i]);
            if (value >= before) sum+=value;
            else sum-=value;
            before = value;
        }
        return sum;
    }

    public int romanToInt2(String s) {
        int sum = 0;
        int preNum =getNum(s.charAt(0)) ;
        for (int i = 1; i < s.length(); i++) {
            int num = getNum(s.charAt(i)) ;
            if(preNum >= num) sum+=preNum;
            if(preNum < num) sum-=preNum;
            // 前缀向后移动
            preNum = num ;
        }
        // 最后一个数字还要处理
        sum+= preNum ;
        return sum ;
    }

    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        String s = "IVXLCDM";
        System.out.println(solution.romanToInt(s));
    }
}
