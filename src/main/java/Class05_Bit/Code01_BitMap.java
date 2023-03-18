package Class05_Bit;

import java.util.HashSet;

/**
 * @Describe 位图
 * <p>
 * 使用long类型的数组才表示指定范围内每个数字是否存在
 * @Author Jax
 * @Date 2023/2/17 20:24
 */
public class Code01_BitMap {

    public static void main(String[] args) {
        int maxValue = 1000000;
        BitMap bitMap = new BitMap(maxValue);
        HashSet<Integer> integers = new HashSet<>();
        System.out.println("开始");
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < maxValue; i1++) {
                double random = Math.random();
                if (random < 0.3) {
                    bitMap.add(i1);
                    integers.add(i1);
                } else if (random < 0.6) {
                    bitMap.delete(i1);
                    integers.remove(i1);
                } else {
                    if (bitMap.contains(i1) != integers.contains(i1)) {
                        System.out.println("错误-" + i1);
                    }
                }
            }
        }
        System.out.println("结束");
    }

}


class BitMap {

    /**
     * 位图数组
     */
    private long[] bits;

    /**
     * 初始化位图矩阵
     *
     * @param maxValue
     */
    public BitMap(int maxValue) {
        // 使用long类型存储位图数据 一个long类型64位,所以(最大值/64)+1代表需要多少个元素即矩阵有多少行
        bits = new long[((maxValue / 64) + 1)];
    }

    public boolean add(int num) {
        /**
         * 1.num/64 = num >> 6 可以获取到第几个元素
         * 2.获取到行号以后获取位数 num % 64 = num & 63 -值是相等的
         * 3.1L左移得到的位数个单位再和该行进行或运算使该位置变为1标记为已存储
         * PS:1L表示64位如果只用1的话默认为int 左移超过32位数据会错误
         */
        bits[num >> 6] |= (1L << (num & 63));
        return true;
    }

    public boolean delete(int num) {
        /**
         * 1L左移位置数后取反得到的结果再和行去AND可以将指定位置设置为0
         */
        bits[num >> 6] &= ~(1L << (num & 63));
        return true;
    }

    public boolean contains(int num) {
        /**
         * &运算 结果为0则代表已存的行对应位值位0
         */
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }
}
