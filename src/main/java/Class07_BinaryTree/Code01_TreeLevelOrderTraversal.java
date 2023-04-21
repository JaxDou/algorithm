package Class07_BinaryTree;

import Class06_Compare_PriorityQueue_Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Describe leetcode-107. 二叉树的层序遍历 II
 * @Author Jax
 * @Date 2023/4/19 23:27
 */
public class Code01_TreeLevelOrderTraversal {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.push(root);


        // treeNodeList长度不为0
        while (treeNodeList.size() != 0) {
            List<Integer> currentValueList = new ArrayList<>();

            // treeNodeList长度不为0 则循环 长度数的次数
            int currentSize = treeNodeList.size();

            for (int i = 0; i < currentSize; i++) {
                TreeNode pop = treeNodeList.pop();

                currentValueList.add(pop.val);

                // 弹出元素记录到list里然后将左右子树入队
                if (null != pop.left) {
                    treeNodeList.add(pop.left);
                }

                if (null != pop.right) {
                    treeNodeList.add(pop.right);
                }
            }
            // 循环完后入队
            res.add(currentValueList);
        }
        Collections.reverse(res);
        return res;
    }
}


