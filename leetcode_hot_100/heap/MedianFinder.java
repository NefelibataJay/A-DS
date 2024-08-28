package leetcode_hot_100.heap;

import java.util.*;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
    }

    PriorityQueue<Integer> queMax = new PriorityQueue<>(); // 存放大于中位数的数
    PriorityQueue<Integer> queMin = new PriorityQueue<>((o1, o2) -> o2 - o1); // 存放小于中位数的数

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size())
                queMax.offer(queMin.poll());
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size())
                queMin.offer(queMax.poll());
        }
    }

    public double findMedian() {
        if (queMax.size() - queMin.size() == 0) {
            return (queMax.peek() + queMin.peek()) / 2.0;
        } else if (queMax.size() - queMin.size() > 0) {
            return queMax.peek();
        } else {
            return queMin.peek();
        }
    }
}
