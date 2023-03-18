package Class03_Sort;

import utils.NumUtils;

/**
 * @Describe 局部最小-给定一个相邻数字不相等的数组，返回任意一个局部最小值的下标
 * @Author Jax
 * @Date 2023/2/6 22:00
 */
public class Code03_minValueIndex {
    /**
     * 若局部最小值不存在两边界则开始的趋势是降低最后的趋势是升高
     * 中间必有局部最小值所以采用二分法
     * @param array
     * @return
     */
    public static int minValueIndex(int[] array) {
        if (null == array || array.length == 0) {
            return -1;
        }

        int N = array.length;
        if (N == 1) {
            return 0;
        }

        if (array[0] < array[1]) {
            return 0;
        }
        if (array[N - 1] < array[N - 2]) {
            return N - 1;
        }

        // 如果不在边界则表示开始是下降趋势末尾是上升趋势中间必存在局部最小
        int L = 0;
        int R = N - 1;
        int mid;

        // 之所以L < R-1 是因为mid会根mid-1或mid+1比较 L<R条件最终会只剩下2个元素导致数组越界
        while (L < R - 1) {
            mid = (L + R) / 2;
            // 第一次中间的位置就是局部最小
            if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                return mid;
            }
            if (array[mid] > array[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        // 最终会剩下两个元素,数值较小的元素下标为局部最小值的下标
        if (array[L] < array[R]) {
            return L;
        } else {
            return R;
        }
    }

    // 校验结果是否为局部最小值
    public static boolean check(int[] array, int index) {
        if (null == array || array.length == 0) {
            return -1 == index;
        }

        int N = array.length;
        if (N == 1) {
            return 0 == index;
        }

        // 当数组只有两个元素的时候
        if (N == 2) {
            if (array[0] < array[1]) {
                return 0 == index;
            } else {
                return 1 == index;
            }
        }

        int left = index - 1;
        int right = index + 1;

        // 如果是左边界局部最小则right判断局部最小是否成立
        // 如果是右边界局部最小则left判断局部最小是否成立
        boolean leftBigger = left >= 0 ? array[left] > array[index] : true;
        boolean rightBigger = right < array.length ? array[right] > array[index] : true;

        return leftBigger && rightBigger;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int[] randomArray = NumUtils.getRandomArrayNoRepetition(1000, 155);
            int res = minValueIndex(randomArray);
            boolean check = check(randomArray, res);
            if (!check) {
                System.out.println("1");
            }
        }
        System.out.println("结束");

    }
}
