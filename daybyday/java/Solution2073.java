package daybyday.java;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        for (int i = 0; i <= n; i++) {
            if (i > k) {
                time += Math.min(tickets[i], tickets[k] - 1);
            } else {
                time += Math.min(tickets[i], tickets[k]);
            }
        }
        return time;
    }
}
