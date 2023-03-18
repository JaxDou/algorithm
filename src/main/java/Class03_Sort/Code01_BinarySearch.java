package Class03_Sort;

import utils.NumUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/1/29 23:11
 */
public class Code01_BinarySearch {

    // 二分查找
    public static int binarySearch(int [] arr, int target) {
        if (null == arr) {
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int mid;
        // 边界条件
        while (L <= R) {
            // 不要忘记每次给mid赋值
            mid = (L + R) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                // 调整右边界
                R = mid-1;
            } else {
                // 调整左边界
                L = mid+1;
            }
        }
        return -1;
    }

    // 暴力搜索
    public static int searchNum(int [] arr, int target) {
        if (null == arr) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            // 定义随机数组长度(含重复)
            int len = 10;
            // 生成随机数组
            int[] randomArrays = NumUtils.getRandomArray(len);
            // 转set去重
            Set<Integer> integers = new HashSet<>();
            Arrays.stream(randomArrays).forEach(item -> {
                integers.add(item);
            });


            int[] randomNums = new int[len];
            int j = 0;
            // 转回数组
            for (Integer integer : integers) {
                randomNums[j] = integer;
                j++;
            }
            // 排序
            Arrays.sort(randomNums);

            // 打印验证
          /*  for (int randomNum : randomNums) {
                System.out.println(randomNum);
            }*/

            // 调用二分查找
            int target = (int) (Math.random() * 100) + 1;
            int resBS = binarySearch(randomNums, target);

            int resSearch = searchNum(randomNums, target);

            if (resBS == resSearch){
                System.out.println(resBS == resSearch);
            }else {
                System.out.println("查找错误");
                System.out.println("二分查找结果:" + resBS);
                System.out.println("暴力查找结果:" + resSearch);

                System.out.println("目标值:" + target);

                System.out.println("随机数组:");
                for (int randomNum : randomNums) {
                    System.out.println(" " + randomNum);
                }
            }
        }

//        int [] arr = {0, 0, 3, 12, 18, 22, 54, 57, 64, 80};
//        System.out.println(binarySearch(arr, 18));

    }

}
