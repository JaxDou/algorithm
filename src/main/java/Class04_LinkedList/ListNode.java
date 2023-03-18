package Class04_LinkedList;

/**
 * @Describe 双向链表节点定义
 * @Author Jax
 * @Date 2023/2/7 23:12
 */
public class ListNode {

    public ListNode(int value) {
        this.value = value;
    }

    /**
     * 值
     */
    public int value;

    /**
     * 指向后一个节点
     */
    public ListNode next;

    /**
     * 指向前一个节点
     */
    public ListNode pre;
}
