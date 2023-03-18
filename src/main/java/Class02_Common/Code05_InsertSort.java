package Class02_Common;

import utils.NumUtils;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/1/16 14:20
 */
public class Code05_InsertSort {

    public static void insertSort(int[] nums) {

        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] < nums[j - 1]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                }
            }
        }

    }


    public static void main(String[] args) {
//        int[] ints = {5, 1, 2, 7, 10};
        int[] ints = NumUtils.getRandomArray(100);
        insertSort(ints);
        System.out.println("排序后");
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}
