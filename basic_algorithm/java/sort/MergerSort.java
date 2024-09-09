package basic_algorithm.java.sort;

/**
 * MergerSort
 */
public class MergerSort {
    public static void mergerSort(int[] nums) {
        if (nums.length < 2)
            return;
        process(nums, 0, nums.length);
    }

    public static void process(int[] arr, int L, int R) {
        if (L <= R)
            return;

        int mid = ((R - L) >> 1) + L;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int p1 = L, p2 = M + 1;

        int i = 0;
        int[] res = new int[R - L + 1];

        while (p1 <= M && p2 <= R) {
            if (arr[p1] > arr[p2]) {
                res[i++] = arr[p2++];
            } else {
                res[i++] = arr[p1++];
            }
        }

        while (p1 <= M) {
            res[i++] = arr[p1++];
        }
        while (p2 <= R) {
            res[i++] = arr[p2++];
        }

        for (int j = 0; j < res.length; j++) {
            arr[L + j] = arr[j];
        }
    }
}