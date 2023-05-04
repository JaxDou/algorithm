package Class07_BinaryTree;

import Class06_Compare_PriorityQueue_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author Jax 113.路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * @Date 2023/5/4 22:08
 */
public class Code05_PathSum02 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> sumArray = new ArrayList<>();
        List<List<Integer>> sumArrayList = new ArrayList<>();
        if (null == root) {
            return sumArrayList;
        }


        process(root, 0, targetSum, sumArray, sumArrayList);
        return sumArrayList;
    }

    public void process(TreeNode root, int preSum, int targetSum, List<Integer> sumArray, List<List<Integer>> sumArrayList) {

        // 如果符合则直接添加后return
        if (null == root.left && null == root.right && targetSum == preSum + root.val) {
            sumArray.add(root.val);
            sumArrayList.add(copyList(sumArray, new ArrayList()));

            // 返回后要递归到另一个节点 所以这边需要复原
            sumArray.remove(sumArray.size()-1);
            return;
        }

        // 若不满足要求则添加节点到数组
        preSum += root.val;
        sumArray.add(root.val);

        // 若不符合
        if (null != root.left) {
            process(root.left, preSum, targetSum, sumArray, sumArrayList);
        }


        if (null != root.right) {
            process(root.right, preSum, targetSum, sumArray, sumArrayList);
        }

        // 方法结束前要复原数组
        sumArray.remove(sumArray.size()-1);



    }

    List<Integer> copyList(List<Integer> source, List<Integer> target) {
        source.forEach(item -> target.add(item));
        return target;
    }
}
