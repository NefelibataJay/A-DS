package classical_150.java;

public class Solution58 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                if (count > 0) return count;
            }
            else count++;
        }

        return count;
    }


    public static void main(String[] args) {
        String s = "Hello World";
        Solution58 solution = new Solution58();
        System.out.println(solution.lengthOfLastWord(s));
    }
}
