package Class02_Common;

/**
 * @Describe 不等概率-给定一个函数 有P概率返回0 (1-P)概率返回1 构造等概率0、1发生器
 * @Author Jax
 * @Date 2023/1/28 23:16
 */
public class Code08_RandomIntPFrom0to1 {

    // 给定一个函数P概率返回0 (1-P)概率返回1
    public static int randomPFrom0to1() {
        double random = Math.random();
        if (random > 0.2) {
            return 0;
        } else {
            return 1;
        }
    }

    //
    public static int randomIntFrom0to1() {
        while (true) {
            int ans1 = randomPFrom0to1();
            int ans2 = randomPFrom0to1();
            if (ans1 == 0 && ans2 == 1) {
                return 0;
            }
            if (ans1 == 1 && ans2 == 0) {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        int [] arry = new int[100];
        for (int i = 0; i < 10000000; i++) {
            int random = randomIntFrom0to1();
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
