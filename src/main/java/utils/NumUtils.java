package utils;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/1/16 14:28
 */
public class NumUtils {
    public static int[] getRandomArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        /*System.out.println("生成的随机数组为: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();*/
        return arr;
    }

    /**
     * 生成指定长度的数组-相邻数字不重复
     *
     * @param len
     * @return
     */
    public static int[] getRandomArrayNoRepetition(int len, int maxValue) {
        int[] array = new int[len];
        array[0] = (int) (Math.random() * maxValue);
        int t = (int) (Math.random() * maxValue);
        for (int i = 1; i < len; i++) {
            while (t == array[i - 1]) {
                t = (int) (Math.random() * maxValue);
            }
            array[i] = t;
        }
        return array;
    }
}
