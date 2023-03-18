package Class02_Common;

/**
 * @Describe 阶乘
 * @Author Jax
 * @Date 2023/1/15 23:42
 */
public class Code02_Factorial {
    static int factorial(int n) {
        int sum = 0;
        int current = 1;
        for (int i = 1; i <= n; i++) {
            current = current * i;
            sum = sum + current;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));


    }



}
