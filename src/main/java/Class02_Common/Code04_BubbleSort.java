package Class02_Common;

import utils.NumUtils;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/1/16 0:19
 */
public class Code04_BubbleSort {

    public static void bubbleSort(int[] nums) {

        for (int end = nums.length - 1; end >=0; end --) {
            for (int j = 1; j <= end; j++) {
                if (nums[j-1] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }


    public static void main(String[] args) {
//        int[] ints = {5, 1, 2, 7, 10};
        int[] ints = NumUtils.getRandomArray(100);
        bubbleSort(ints);
        System.out.println("排序后");
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}
