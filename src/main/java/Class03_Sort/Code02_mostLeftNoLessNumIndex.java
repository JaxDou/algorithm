package Class03_Sort;

import utils.NumUtils;

import java.util.Arrays;

/**
 * @Describe 寻找有序数组中最左边的=num的数字下标
 * @Author Jax
 * @Date 2023/2/6 20:52
 */
public class Code02_mostLeftNoLessNumIndex {

    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return -1;
        }

        // 左边界
        int L = 0;
        // 右边界
        int R = arr.length - 1;
        // 最后一个符合的数
        int res = -1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }


    // 对照组
    public static int mostLeftNoLessNumIndex02(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            // 生成随机数组
            int[] randomArrays = NumUtils.getRandomArray(1000);
            int num = (int) ((Math.random()*100) +1);

            Arrays.sort(randomArrays);
            int res1 = mostLeftNoLessNumIndex(randomArrays, num);
            int res2 = mostLeftNoLessNumIndex02(randomArrays, num);

//            System.out.println(res1 == res2);
            if(res1 != res2){
                System.out.println("-----------------------");
                System.out.println("数组---");
                for (int randomArray : randomArrays) {
                    System.out.print(randomArray + " ");
                }
                System.out.println("num---" + num);
                System.out.println("结果：res1 = " + res1);
                System.out.println("结果：res2 = " + res2);
            }
            System.out.println(i);
        }
        System.out.println("结束");
    }


}
