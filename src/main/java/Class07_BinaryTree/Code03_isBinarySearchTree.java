package Class07_BinaryTree;

import Class06_Compare_PriorityQueue_Tree.TreeNode;

/**
 * @Describe 判断是否为搜索二叉树 leetcode 98
 * @Author Jax
 * @Date 2023/5/3 22:14
 */
public class Code03_isBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }


    IsBSTInfo process(TreeNode root) {

        // 若节点为空则返回空
        if (null == root) {
            return null;
        }

        IsBSTInfo leftIsBSTInfo = process(root.left);
        IsBSTInfo rightIsBSTInfo = process(root.right);

        // 初始化
        int max = root.val;
        int min = root.val;

        // 获取该子树的 最大 最小 值
        if (null != leftIsBSTInfo) {
            max = Math.max(leftIsBSTInfo.maxValue, max);
            min = Math.min(leftIsBSTInfo.minValue, min);
        }

        if (null != rightIsBSTInfo) {
            max = Math.max(rightIsBSTInfo.maxValue, max);
            min = Math.min(rightIsBSTInfo.minValue, min);
        }

        boolean isBST = true;

        if (null != leftIsBSTInfo && !leftIsBSTInfo.isBST) {
            isBST = false;
        }

        if (null != rightIsBSTInfo && !rightIsBSTInfo.isBST) {
            isBST = false;
        }

        // 左子树的最大值小于root节点
        boolean leftMaxLessValue = null == leftIsBSTInfo ? true : leftIsBSTInfo.maxValue < root.val;

        // 右子树的最小值大于root节点
        boolean rightMinMoreValue = null == rightIsBSTInfo ? true : rightIsBSTInfo.minValue > root.val;

        if (!leftMaxLessValue || !rightMinMoreValue) {
            isBST = false;
        }


        return new IsBSTInfo(max, min, isBST);
    }

    static class IsBSTInfo {

        // 子树最大值
        public int maxValue;
        // 子树最小值
        public int minValue;
        // 当前子树是否是BST
        public boolean isBST;

        public IsBSTInfo(int maxValue, int minValue, boolean isBST) {
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.isBST = isBST;
        }
    }
}
