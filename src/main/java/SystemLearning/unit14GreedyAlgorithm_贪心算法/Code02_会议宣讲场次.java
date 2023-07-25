package SystemLearning.unit14GreedyAlgorithm_贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Describe 多个会议时间点区间 [1,2] [2,9] [7,17] 返回最多可以安排的会议数量
 * @Author Jax
 * @Date 2023/7/25 10:05 下午
 */
public class Code02_会议宣讲场次 {
    public static void main(String[] args) {

        Program program = new Program(1, 2);
        Program program1 = new Program(2, 4);
        Program program2 = new Program(9, 10);
        Program program3 = new Program(19, 20);
        Program program4 = new Program(9, 10);

        Program[] programs = {program, program1, program2, program3, program4};
        System.out.println(maxProgramNum1(programs));


        System.out.println(maxProgramNum2(programs));

    }


    /**
     * 递归全遍历方式暴力获取最大值
     *
     * @param programs
     * @return
     */
    public static int maxProgramNum1(Program [] programs) {
        int max = process(programs, 0, 0);
        return max;
    }


    /**
     * 暴力递归方法
     *
     * @param programs 当前剩余的会议数组
     * @param done 目前排了多少个
     * @param currentTime 当前时间点
     * @return
     */
    public static int process(Program [] programs, int done, int currentTime) {
        if (null == programs || programs.length == 0) {
            return done;
        }

        int max = done;
        for (int i = 0; i < programs.length; i++) {
            // 如果当前计划可以排期则进行排期
            if (programs[i].start > currentTime) {
                // 移除当前排期
                Program[] programs1 = copyRemovedArray(programs, i);
                max = Math.max(max, process(programs1, done + 1, programs[i].end));
            }
        }
        return max;
    }


    /**
     * 拷贝数组(去掉下标的元素后)
     *
     * @param programs
     * @param i
     * @return
     */
    static Program[] copyRemovedArray(Program [] programs, int i) {
        Program [] res = new Program[programs.length-1];
        int k = 0;
        for (int i1 = 0; i1 < programs.length; i1++) {
            if (i != i1) {
                res[k] = programs[i1];
                k++;
            }
        }
        return res;
    }


    /**
     * 贪心思路
     * 按照结束时间升序排列
     *
     * @param programs
     * @return
     */
    public static int maxProgramNum2(Program [] programs) {

        Arrays.sort(programs, (o1, o2) -> o1.start-o2.end);
        int count = 0;
        int currentTime = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start > currentTime) {
                count++;
                currentTime = programs[i].end;
            }
        }
        return count;
    }




        static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
