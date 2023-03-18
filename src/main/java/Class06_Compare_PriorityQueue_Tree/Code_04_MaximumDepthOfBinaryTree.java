package Class06_Compare_PriorityQueue_Tree;

/**
 * @Describe leetcode-104.二叉树的最大深度
 * 返回二叉树的最大深度
 * @Author Jax
 * @Date 2023/2/24 21:14
 */
public class Code_04_MaximumDepthOfBinaryTree {


    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }
}
