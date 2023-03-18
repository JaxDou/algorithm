package Class02_Common;

/**
 * @Describe 打印一个数二进制格式
 * @Author Jax
 * @Date 2023/1/15 22:17
 */
public class Code01_PrintNumber {

    static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }


    }

    public static void main(String[] args) {
        print(2);
        System.out.println();
        print(-1);
        System.out.println();
        print(-2);
        System.out.println();
        print(Integer.MIN_VALUE);
        System.out.println();
        print(Integer.MIN_VALUE + 1);

    }
}
