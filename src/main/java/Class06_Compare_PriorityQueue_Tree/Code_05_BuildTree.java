package Class06_Compare_PriorityQueue_Tree;

/**
 * @Describe leetcode-105.从前序与中序遍历序列构造二叉树
 * @Author Jax
 * @Date 2023/3/19 22:25
 *
 * 思路 根据先序的第一个元素获得头节点然后去中序中拿到左右子树递归调用生成二叉树，因为不存在重复节点
 */
public class Code_05_BuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 判断条件是否满足构建树
        if (null == preorder || null == inorder || preorder.length != inorder.length) {
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


    }


    public TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        // 当先序 1 2 3 中序2 3 1的时候 会出现right子树的生成越界所以代表无子树应返回空

        if (L1 > R1) {
            return null;
        }

        TreeNode head = new TreeNode(pre[L1]);

        if (L1 == R1) {
            return head;
        }

        // 遍历在中序遍历中寻找头结点的下标
        int find = L2;
        while (pre[L1] != in[find]) {
            find++;
        }

        head.left = f(pre, L1 + 1, L1 + (find - L2), in, L2, find - 1);
        head.right = f(pre, L1 + (find - L2) + 1, R1, in, find + 1, R2);
        return head;
    }
}


























