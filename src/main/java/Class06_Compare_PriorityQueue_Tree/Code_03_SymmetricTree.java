package Class06_Compare_PriorityQueue_Tree;

/**
 * @Describe leetcode-101.对称二叉树
 * @Author Jax
 * @Date 2023/2/22 22:55
 */
public class Code_03_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        // 如果都为空则表示树结构相同
        if (null == p && null == q) {
            return true;
        }

        // 异或运算两边结果不同时返回true这里表示有其中一个root节点为空则返回
        if ((null == p) ^ (null == q)) {
            return false;
        }


        // 利用递归序最后会回到头节点的性质最后回到头节点时校验是否两个子节点都为true
        // 和校验相同树的代码不同的地方是这里分别传入p的左子节点和q的右子节点
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
