package Class06_Compare_PriorityQueue_Tree;

/**
 * @Describe leetcode-100.相同的树 判断两个root节点的树是否结构数据完全相同
 * @Author Jax
 * @Date 2023/2/22 22:24
 */
public class Code02_2_SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果都为空则表示树结构相同
        if (null == p && null == q) {
            return true;
        }

        // 异或运算两边结果不同时返回true这里表示有其中一个root节点为空则返回
        if ((null == p) ^ (null == q)) {
            return false;
        }


        // 利用递归序最后会回到头节点的性质最后回到头节点时校验是否两个子节点都为true
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
