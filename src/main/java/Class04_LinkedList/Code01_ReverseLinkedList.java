package Class04_LinkedList;

import utils.NodeUtils;

/**
 * @Describe 反转单项链表
 * <p>
 * 1->2->3->null
 * 3->2->1->null
 * @Author Jax
 * @Date 2023/2/7 23:11
 */
public class Code01_ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head) {
        if (null == head) {
            return null;
        }

        // 前指针
        ListNode pre = null;
        // 后指针
        ListNode next;

        /**
         * pre head next 三个节点 按顺序排列
         * 1.使next指向head的下一个元素
         * 2.调整head的下一个元素指向pre
         * 3。pre移动到head的位置
         * 4.head移动到next的位置
         * 5.最后使pre作为头结点返回pre
         */
        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = reverseLinkedList(head);
        NodeUtils.printLinkedList(head.next.next);
    }

}
