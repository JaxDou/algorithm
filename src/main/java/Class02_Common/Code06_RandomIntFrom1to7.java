package Class02_Common;

/**
 * @Describe 给定可以随机生成1-5的函数randomFrom1to5()需要得到随机数生成1-7的函数
 * @Author Jax
 * @Date 2023/1/27 22:40
 */
public class Code06_RandomIntFrom1to7 {


    public static int randomIntFrom1to5() {
        // random函数 生成[0, 1) 区间的数字
        // 乘5后得到[0, 5) 取整则得到[0, 4] 最后+1得到[0, 5]--先加1或先取整无区别
        int random = (int)((Math.random() * 5) + 1);
        return random;
    }

    public static void main(String[] args) {
        int [] arry = new int[10];
        for (int i = 0; i < 100000000; i++) {
            int random = randomIntFrom1to7();
            arry[random]++;
        }

        for (int i = 0; i < arry.length; i++) {
            System.out.print(i);
            System.out.println("---这个数字出现了" + arry[i] + "次");
        }
    }

    /**
     * 1.根据已有条件函数构建0、1发生器(只产生0或1)
     * 2.使用0、1发生器构建和需要生成的数字二进制化后位数相等的数字
     * 3.裁切
     */

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

    // 7的二进制是111 由三由二进制组成
    public static int randomIntFrom1to7() {
        int ans = 0;

        // 0-7
        while(true) {
            ans = (randomIntFrom0to1() << 2) + (randomIntFrom0to1() << 1) + (randomIntFrom0to1() << 0);
            if (0 != ans) {
                return ans;
            }
        }


    }

}
