package Class08_MergeAndQuickSort;

import utils.NumUtils;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/2/24 21:34
 */
public class Code02_MergeSort {

    public static void main(String[] args) {
//        int[] ints = {5, 1, 2, 7, 10};
        int[] ints = NumUtils.getRandomArray(100);
//        process(ints, 0, ints.length - 1);
        mergeSort(ints);
        System.out.println("排序后");
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }

    /**
     * 归并排序-递归
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {

        // 递归终止条件
        if (L == R) {
            return;
        }
        int M = (L + R) >> 1;
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);

    }

    /**
     * 归并排序-非递归
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        // 判空
        if (null == arr || arr.length < 2) {
            return;
        }

        // 默认步长为1
        int step = 1;
        int N = arr.length;

        // 步长小于N, 步长等于N的时候就已经是有序的状态了
        while (step < N) {
            // 每次步长增加后L都从0开始
            int L = 0;
            while (L < N) {
                int M = 0;

                //给M赋值
                // 判断M是否会越界,如果剩下的元素个数大于等于步长 则可以给M赋值
                if (((N - 1) - L + 1) >= step) {
                    M = L + step - 1;
                } else {
                    // 若都不够一个步长则代表这些剩下的元素肯定都是有序的(为上一个步长已经排序好的)则不需要归并调整
                    break;
                }

                int R = 0;
                // 给R赋值
                // 判断R是否会越界,如果剩下的元素大于等于步长,则从M+1开始(包括M+1)截取step个元素
                if ((N - 1) - (M + 1) + 1 >= step) {
                    R = (M + 1) + step - 1;
                } else {
                    // 如果剩下的不够一个步长则全部截取下来归并
                    R = N-1;
                }
                merge(arr,L, M, R);
                L = R + 1;
            }

            // 每次步长乘2,if判断是避免数据太多导致步长*2后越界
            if (step > N >> 1) {
                break;
            } else {
                step <<= 1;
            }
        }

    }

    /**
     * 将L-M (M+1)-R归并
     *
     * @param arr
     * @param L
     * @param M
     * @param R
     */
    public static void merge(int[] arr, int L, int M, int R) {
        if (null == arr || 0 == arr.length) {
            return;
        }

        // 定义临时数组
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        while (p1 <= M && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 收集剩下的元素
        while (p1 <= M) {
            temp[i++] = arr[p1++];
        }

        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }

        // 写回数组
        for (int j = 0, k = L; j < temp.length; j++, k++) {
            arr[k] = temp[j];
        }
    }
}
