package Class02_Common;

import utils.NumUtils;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/1/15 23:53
 */
public class Code03_SelectionSort {
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minNum = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minNum]) {
                    minNum = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minNum];
            nums[minNum] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] ints = {5, 1, 2, 7, 10};
        int[] ints = NumUtils.getRandomArray(100);
        selectionSort(ints);
        System.out.println("排序后");
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}
