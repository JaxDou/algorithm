package Class04_LinkedList;

import utils.NodeUtils;

/**
 * @Describe 两个链表相加
 * <p>
 * 相加两个链表,从左到右位数从低到高进行数字加法
 * 例如: 3->5->7
 * 4->9->9
 * 7->4->7->1
 * 从右往左位数由高到低所以是
 * 735 + 994 = 1747
 * @Author Jax
 * @Date 2023/2/14 21:19
 */
public class Code07_AddTwoNumberLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(9);

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);

        ListNode res = addTwoNumberLinkedList(head1, head2);
        NodeUtils.printLinkedList(res);
    }

    /**
     * @param head1
     * @param head2
     */
    public static ListNode addTwoNumberLinkedList(ListNode head1, ListNode head2) {
        int len1 = countLinkedListSize(head1);
        int len2 = countLinkedListSize(head1);

        // 分别给长短头结点赋值
        ListNode lHead = len1 >= len2 ? head1 : head2;
        ListNode sHead = lHead == head1 ? head2 : head1;

        ListNode lCurrent = lHead;
        ListNode sCurrent = sHead;


        // 整个相加过程一共分为三个阶段
        // 1.l链表和s链表都有元素-加法竖式计算并用一个临时变量保存进位
        // 保存进位信息
        int carry = 0;
        ListNode lastNode = null;

        int temValue = 0;

        while (null != sCurrent) {
            lastNode = lCurrent;
            // 计算当前的值
            temValue = (carry + lCurrent.value + sCurrent.value);
            // 进位值
            carry = temValue / 10;
            // 个位值
            lCurrent.value = temValue % 10;

            // 向下移动
            lCurrent = lCurrent.next;
            sCurrent = sCurrent.next;
        }

        // 2.l链表有元素s链表无元素
        while (lCurrent != null) {
            lastNode = lCurrent;
            temValue = carry + lCurrent.value;

            lCurrent.value = temValue % 10;
            carry = temValue / 10;
            lCurrent = lCurrent.next;
        }

        // 3.l无元素s也无元素,此时判断是否需要生成新节点进位
        if (0 != carry) {
            ListNode newNode = new ListNode(1);
            lastNode.next = newNode;
        }
        return lHead;
    }


    // 计算当前链表的长度
    public static int countLinkedListSize(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
