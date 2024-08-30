package leetcode_hot_100.DP;

import java.util.*;

public class Solution118 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        solution118.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> onerows = new ArrayList<>();
        onerows.add(1);
        ans.add(onerows);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(ans.get(ans.size() - 1).get(j) + ans.get(ans.size() - 1).get(j - 1));
            }
            row.add(1);
            ans.add(row);
        }

        return ans;
    }
}
