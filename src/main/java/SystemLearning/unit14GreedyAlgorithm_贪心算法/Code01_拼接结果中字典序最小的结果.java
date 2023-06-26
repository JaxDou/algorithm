package SystemLearning.unit14GreedyAlgorithm_贪心算法;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Describe
 * @Author Jax
 * @Dscript 一个数组包含多个字符串 返回字典序最小的拼接结果
 * @Date 2023/6/25 21:42
 */
public class Code01_拼接结果中字典序最小的结果 {

    /**
     * 解法1 贪心
     * 策略1：这里不能用直接对字符串数组进行字典序排序i字典序小于j则i放前j放后
     * ["b","ba"] 这个数组直接排序策略的反例 (bba > bab)
     * <p>
     * 正确策略：按照 字符串i拼接j小于字符串j拼接i则i放前面j放后
     */
    public static String separate1(String[] args) {
        if (Objects.isNull(args) || 0 == args.length) {
            return null;
        }
        Arrays.sort(args, (i, j) -> Integer.parseInt(i + j.compareTo(j + i)));

        String res = null;
        for (String arg : args) {
            res += arg;
        }
        return res;
    }


    /**
     * 非贪心策略 直接求出所有组合按字典序排列
     */
    public static String[] separate2(String[] args) {

       return null;
    }
//    process(String[] args)

//    public static void main(String[] args) {
//        String [] s = {"b", "a"};
//
//        Arrays.sort(s, (i, j) -> Integer.parseInt(String.valueOf(i.compareTo(j))));
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
//    }


}
