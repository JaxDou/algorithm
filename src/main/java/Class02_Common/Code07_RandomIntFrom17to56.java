package Class02_Common;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/1/27 23:43
 */
public class Code07_RandomIntFrom17to56 {

    public static int randomIntFrom1to5() {
        // random函数 生成[0, 1) 区间的数字
        // 乘5后得到[0, 5) 取整则得到[0, 4] 最后+1得到[0, 5]--先加1或先取整无区别
        int random = (int)((Math.random() * 5) + 1);
        return random;
    }

    // 0、1发生器
    public static int randomIntFrom0to1() {
        while (true) {
            int ans = randomIntFrom1to5();
            if (ans <= 2) {
                return 0;
            }
            if(ans >= 4) {
                return 1;
            }
        }
    }

    // 使用0、1发生器构造0-56的函数

    // 56的2进制表达为111000 一共6位二进制数
    public static int randomIntFrom17to56() {
        int ans = 0;
        while (true) {
            ans = (randomIntFrom0to1() << 5) + (randomIntFrom0to1() << 4) + (randomIntFrom0to1() << 3) + (randomIntFrom0to1() << 2) + (randomIntFrom0to1() << 1) + (randomIntFrom0to1() << 0);
            // 这里 会生成[0, 63]的数字所以执行起来性能较差
            // 优化思路-构建[0, 39] 函数 然后加17
            if (ans >= 17 && ans <= 56) {
                return ans;
            }
        }
    }

    public static void main(String[] args) {
        int [] arry = new int[100];
        for (int i = 0; i < 10000000; i++) {
            int random = randomIntFrom17to56();
            arry[random]++;
        }

        for (int i = 0; i < arry.length; i++) {
            if (arry[i] != 0) {
                System.out.print(i);
                System.out.println("---这个数字出现了" + arry[i] + "次");
            }

        }
    }

}
