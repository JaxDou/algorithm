package Class06_Compare_PriorityQueue_Tree;

/**
 * @Describe 二叉树节点定义
 * @Author Jax
 * @Date 2023/2/22 21:45
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}