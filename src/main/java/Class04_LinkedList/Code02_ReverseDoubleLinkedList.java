package Class04_LinkedList;

import utils.NodeUtils;

/**
 * @Describe 反转双向链表
 * @Author Jax
 * @Date 2023/2/8 21:14
 */
public class Code02_ReverseDoubleLinkedList {


    public static ListNode reverseDoubleLinkedList(ListNode head) {
        if (null == head) {
            return null;
        }

        // 前指针
        ListNode pre = null;

        // 后指针
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        // 这里注意操作完毕后返回pre节点 才是最后一个存在的节点
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.pre = head;

        head.next.next = new ListNode(3);
        head.next.next.pre = head.next;
//        NodeUtils.printLinkedList(head);
//        NodeUtils.printLinkedListRevert(head.next.next);

        reverseDoubleLinkedList(head);
        NodeUtils.printLinkedList(head.pre.pre);

    }


}
