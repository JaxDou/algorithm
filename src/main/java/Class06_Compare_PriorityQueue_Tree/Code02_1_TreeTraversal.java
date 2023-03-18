package Class06_Compare_PriorityQueue_Tree;

/**
 * @Describe 二叉树的遍历j
 *
 *       1
 *   2       3
 * 4   5   6   7
 *
 * 先序遍历: 头、左、右 - 1、2、4、5、3、6、7
 * 中序遍历: 左、头、右 - 4、2、5、1、6、3、7
 * 后续遍历: 左、右、头 - 4、5、2、6、7、3、1
 * 递归序: 1、2、4、4、4、2、5、5、5、2、1、3、6、6、6、3、7、7、7、3、1
 *
 * @Author Jax
 * @Date 2023/2/22 21:17
 */
public class Code02_1_TreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("先序遍历");
        // 先序遍历
        pre(root);

        System.out.println("中序遍历");
        // 中序遍历
        middle(root);

        System.out.println("后序遍历");
        // 后序遍历
        after(root);

        // 递归序遍历
        System.out.println("递归序遍历");
        recursion(root);
    }


    /**
     * 先序遍历
     *
     * @param root
     */
    public static void pre(TreeNode root) {
        if (null == root) {
            return;
        }

        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void middle(TreeNode root) {
        if (null == root) {
            return;
        }

        middle(root.left);
        System.out.println(root.val);
        middle(root.right);
    }

    /**
     * 后续遍历
     *
     * @param root
     */
    public static void after(TreeNode root) {
        if (null == root) {
            return;
        }

        after(root.left);
        after(root.right);
        System.out.println(root.val);
    }

    /**
     * 递归序遍历
     *
     * @param root
     */
    public static void recursion(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        recursion(root.left);
        System.out.println(root.val);
        recursion(root.right);
        System.out.println(root.val);
    }

}
