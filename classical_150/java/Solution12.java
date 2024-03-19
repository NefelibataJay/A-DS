package classical_150.java;

public class Solution12 {
    private String getValue(int num) {
        return switch (num) {
            case 1 -> "I";
            case 4 -> "IV";
            case 5 -> "V";
            case 9 -> "IX";
            case 10 -> "X";
            case 40 -> "XL";
            case 50 -> "L";
            case 90 -> "XC";
            case 100 -> "C";
            case 400 -> "CD";
            case 900 -> "CM";
            case 1000 -> "M";
            default -> "";
        };
    }
    public String intToRoman1(int num) {


        return "";
    }

    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < nums.length) {
            // 从最大的数开始，逐渐减小。 也就是说逐渐从M位开始，当num小于1000时，就开始减少到900，然后500，400，100，90，50，40，10，9，5，4，1

            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 当前的num大于等于当前nums[index]对应的值，就添加对应的罗马数字。 并在num中减去对应罗马数字的值
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }

            if (num == 0) break; // 如果num已经为0，就不需要再继续循环了

            index++;
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution12 solution = new Solution12();
        System.out.println(solution.intToRoman(1994));
    }
}
