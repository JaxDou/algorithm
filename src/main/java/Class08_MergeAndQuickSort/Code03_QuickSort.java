package Class08_MergeAndQuickSort;

import utils.NumUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Describe 快速排序
 * @Author Jax
 * @Date 2023/2/25 22:25
 */
public class Code03_QuickSort {
    public static void main(String[] args) {
//        int[] ints = {5, 1, 2, 7, 10};
        int[] ints = NumUtils.getRandomArray(100);
        quickSort(ints, 0, ints.length - 1);
        System.out.println("排序后");
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }


    /**
     * 非递归
     *
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return;
        }

        Queue<QuickSortJob> jobs = new LinkedList<>();

        QuickSortJob quickSortJob = new QuickSortJob(0, arr.length - 1);
        // 队列不为空就一直执行
        while (!jobs.isEmpty()) {
            QuickSortJob job = jobs.poll();

            int[] res = partition(arr, job.L, job.R);

            if (res[0] > job.L) {
                jobs.add(new QuickSortJob(job.L, res[0] - 1));
            }

            if (res[1] < job.R) {
                jobs.add(new QuickSortJob(res[1] + 1, job.R));
            }

        }
    }


    /**
     * 需要排序的数组-递归
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int L, int R) {
        // 这里L > R时退出是因为当处理只有两个元素的数组分层后分层方法会返回两个相同的下标这样下一次调用会导致L > R的情况
        if (L >= R) {
            return;
        }
        // 当只有两个元素时 [小,大] 回返回大元素下标
        // [大,小] 会返回小元素下标
        int[] ints = partition(arr, L, R);
        quickSort(arr, L, ints[0] - 1);
        quickSort(arr, ints[1] + 1, R);
    }


    /**
     * 分层操作
     * 小于标记的元素放在左边 等于标记的元素放在中间大于标记的元素放在右边
     *
     * @param arr
     */
    public static int[] partition(int[] arr, int L, int R) {
        /*if (null == arr || 0 == arr.length) {
            return;
        }*/

        // 左区域
        int l = L - 1;

        // 右区域
        int r = R;

        // 当前元素的位置
        int index = L;
        while (index < r) {
            if (arr[index] < arr[R]) {
                swap(arr, ++l, index++);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                // 当前位置的值大于标记值
                swap(arr, --r, index);
            }
        }

        // 左右分层完毕后把分层的数和大于层中第一个交换
        swap(arr, index, R);

        // 返回相等的元素数组开始和结束的下标
        return new int[]{l + 1, index};
    }

    /**
     * 数组交换元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}


class QuickSortJob {
    int L;
    int R;

    public QuickSortJob(int l, int r) {
        L = l;
        R = r;
    }
}
