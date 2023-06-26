package SystemLearning.unit14GreedyAlgorithm_贪心算法;

import java.util.*;

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

    public static List<String> process(String[] strs) {

        List<String> res = new ArrayList<>();
        // 如果为空则返回一个空字符串
        if (Objects.isNull(strs) || 0 == strs.length) {
            res.add("");
            return res;
        }

        // 不为空则遍历字符串
        for (int i = 0; i < strs.length; i++) {
            String first = strs[i];
            String[] removeStrs = removeByIndex(strs, i);
            List<String> process = process(removeStrs);

            for (String s : process) {
                res.add(first + s);
            }
        }
        return res;
    }


    public static String [] removeByIndex (String [] strs, int index) {
        String [] res = new String [strs.length-1];

        int j = 0;
        for (int i = 0; i < strs.length; i++) {
            if (i == index) {
                continue;
            }
            res[j++] = strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String [] s = {"b", "a"};

//        Arrays.sort(s, (i, j) -> Integer.parseInt(String.valueOf(i.compareTo(j))));

        List<String> process = process(s);

        process.forEach(System.out::println);
    }


}
