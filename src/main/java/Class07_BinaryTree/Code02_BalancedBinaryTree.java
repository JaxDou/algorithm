package Class07_BinaryTree;

import Class06_Compare_PriorityQueue_Tree.TreeNode;

/**
 * @Describe 判断是否是平衡二叉树
 * @Author Jax
 * @Date 2023/4/29 18:25
 */
public class Code02_BalancedBinaryTree {


    static boolean isBalancedBinaryTree(TreeNode root) {
        return process(root).isBalanced;
    }

    static Info process (TreeNode root) {

        // 为null的时候为平衡树但是高度为0
        if (null == root) {
            new Info(true, 0);
        }

        Info letfInfo = process(root.left);
        Info rightInfo = process(root.right);


        int maxHeight = Math.max(letfInfo.height, rightInfo.height) + 1;
        boolean isBalanced = letfInfo.isBalanced && rightInfo.isBalanced && Math.abs(letfInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, maxHeight);

    }

    static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}



