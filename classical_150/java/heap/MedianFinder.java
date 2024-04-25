package classical_150.java.heap;

import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a)); // 小于等于中位数的数
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b)); // 大于中位数的数
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            // queMin 为空， 或者当前插入的数字小于等于中位数时
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                // queMax的长度+1 小于 queMin.size() 意味着 queMin 中的数字过多
                // 将queMin中最大的数（队尾），出队并添加到queMax中
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                // queMax的长度 大于 queMin.size() 意味着 queMax 中的数字过多
                // 将queMax中最小的数（队尾），出队并添加到queMin中
                queMin.offer(queMax.poll());
            }
        }

    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek(); // 奇数
        }
        return (queMin.peek() + queMax.peek()) / 2.0; // 偶数
    }
}
