package daybyday.java;

import java.util.Random;

/**
 * Solution912
 */
public class Sort {
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r)
            return;

        int mid = ((r - l) >> 1) + l;
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid + 1, r, temp);

        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                temp[cnt++] = nums[j++];
            } else {
                temp[cnt++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[cnt++] = nums[i++];
        }

        while (j <= r) {
            temp[cnt++] = nums[j++];
        }

        for (int k = 0; k < r; k++) {
            nums[k + l] = temp[k];
        }

    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            swap(nums, r, l);
            int pos = partition(nums, l, r); //
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}