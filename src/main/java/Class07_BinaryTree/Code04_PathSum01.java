package Class07_BinaryTree;

import Class06_Compare_PriorityQueue_Tree.TreeNode;

/**
 * @Describe leetcode 112.路径总和
 * @Author Jax
 * @Date 2023/5/4 21:42
 */
public class Code04_PathSum01 {
    public static boolean isPathSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        isPathSum = false;

        // 因为头结点之前没有节点所以preSum传0
        process(root, 0, targetSum);
        return isPathSum;

    }

    /**
     *
     * @param root 头结点
     * @param preSum 之前路径的总和
     * @param targetSum 目标数值
     */
    public void process(TreeNode root, int preSum, int targetSum) {
        // 判断是否符合路径和(是叶子节点同时符合路径和)
        if (null == root.left && null == root.right && targetSum == preSum + root.val) {
            // 符合则设置为true
            isPathSum = true;
        }

        // 若不符合
        preSum += root.val;
        if (null != root.left) {
            process(root.left, preSum, targetSum);
        }

        if (null != root.right) {
            process(root.right, preSum, targetSum);
        }

    }


}
