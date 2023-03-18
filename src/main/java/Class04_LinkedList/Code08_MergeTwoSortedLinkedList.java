package Class04_LinkedList;

import utils.NodeUtils;

/**
 * @Describe 合并两个有序链表
 * <p>
 * 已知两个有序链表的头结点head1、head2
 * 将两个有序链表为一个有序链表并返回头结点head
 * @Author Jax
 * @Date 2023/2/14 23:11
 */
public class Code08_MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(9);

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);


        NodeUtils.printLinkedList(mergeTwoSortedLinkedList(head1, head2));
    }


    /**
     * 1.找到两个链表中头节点较小的那个作为最后返回的头结点并使pre指向该节点
     * 2-1.当两个链表都有元素时,依次遍历每次pre.next指向较小的
     * 2-2.只剩下一个链表时,pre.next直接连接剩下的元素
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2) {
        if (null == head1 || null == head2) {
            return null == head1 ? head2 : head1;
        }
        // 起始值小的作为head
        ListNode head = head1.value >= head2.value ? head2 : head1;

        ListNode pre = head;

        // 拿到第一个节点以后
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;

        // 每次pre连接小的节点
        while (null != cur1 && null != cur2) {
            if (cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        // 连接剩下链表的节点
        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }
}
