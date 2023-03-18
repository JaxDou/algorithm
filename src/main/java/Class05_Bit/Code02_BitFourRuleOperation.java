package Class05_Bit;

/**
 * @Describe 位运算实现四则运算
 * @Author Jax
 * @Date 2023/2/18 20:33
 */
public class Code02_BitFourRuleOperation {
    public static void main(String[] args) {
        Computer computer = new Computer();
//        System.out.println(computer.add(1, 2));
//        System.out.println(computer.multiply(2, 6));
        System.out.println(computer.divide(Integer.MIN_VALUE, 1));
    }

}

class Computer {
    /**
     * 位运算实现加法
     * 1.对num1和num2进行无进位相加(num1 ^-异或 num2)得到sum
     * 2.获取num1 + num2的进位信息(num1 & num2) << 1
     * 3.使得无进位相加的结果 + 进位结果得到最终结果
     * 4.直至进位信息为0返回
     *
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1, int num2) {
        int sum = num1;

        while (num2 != 0) {
            // 无进位相加
            sum = num1 ^ num2;
            // 获取进位信息
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }

    /**
     * 减法
     * <p>
     * 负数表示的值为32位二进制去掉符号位后的31位数字全部取反然后+1表示值的大小
     * 所以整型最小值比最大值大1
     * 符号位： 0正、1负
     * 0占用的是正数里的数值 所以负数中10 0000000000 0000000000 0000000000 应该位-0但是和0一样所以用正数的0来表示了，所以负数比正数多一个数字 即最小值的绝对值比最大值的绝对值大1
     * 一个数可以通过 先取反再加1变为其相反数
     */
    public int subtraction(int num1, int num2) {
        return add(num1, add(~num2, 1));
    }

    /**
     * 乘法,模拟乘法竖式计算
     *
     * @param num1
     * @param num2
     * @return
     */
    public int multiply(int num1, int num2) {
        int res = 0;

        while (0 != num2) {
            if ((num2 & 1) != 0) {
                res = add(res, num1);
            }
            // num1左移模拟乘法竖式中的计算完一个数字后第二个数字在上一个数字结果上左移一个的操作
            num1 <<= 1;
            // >>> 表示无符号右移即最高位补0
            num2 >>>= 1;
        }
        return res;
    }

    /**
     * 相除运算
     * 被除数每次移动一位变大当小于num1的最大值时使num1减去
     *
     * @param num1
     * @param num2
     * @return
     */
    private int division(int num1, int num2) {
        int a = negNum(num1) ? ~num1 + 1 : num1;
        int b = negNum(num2) ? ~num2 + 1 : num2;
        int res = 0;

        for (int i = 31; i >= 0; i = subtraction(i, 1)) {

            // 移动b不移动a是防止左移最后覆盖掉符号位
            if ((a >> i) >= b) {
                // 对应位置标记为1
                res |= (1 << i);
                a = subtraction(a, b << i);
            }
        }
        return negNum(num1) == negNum(num2) ? res : (~res + 1);
    }


    /**
     * 除法、leetcode29题
     * @param num1
     * @param num2
     * @return
     */
    public int divide(int num1, int num2) {
        // 1.num1、num2 都为最整型小值 如果是最小值除以最小值直接得到1
        if (Integer.MIN_VALUE == num1 && Integer.MIN_VALUE == num2) {
            return 1;

            // 2.num2为最小值 任意一个值除以最小值得到0
        } else if (Integer.MIN_VALUE == num2) {
            return 0;

            // 3.num1为最小值 分情况讨论
        } else if (Integer.MIN_VALUE == num1) {
            // 3.1 最小值除以-1约定为最大值返回
            // PS当除以1时返回 MIN_VALUE
            if (-1 == num2) {
                return Integer.MAX_VALUE;
            }
            // 3.2 最小值+1后再补偿
            int res = division(add(num1, 1), num2);
            return add(res, division(subtraction(num1, multiply(num2, res)), num2));
            // 4.正常除法
        } else {
            return division(num1, num2);
        }
    }

    /**
     * 判断是否为负数
     *
     * @param num
     * @return
     */
    public boolean negNum(int num) {
        return num >> 31 == 0 ? false : true;
    }
}
