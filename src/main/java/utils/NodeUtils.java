package utils;

import Class04_LinkedList.ListNode;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/2/7 23:22
 */
public class NodeUtils {
    public static void printLinkedList(ListNode head) {
        if (null == head) {
            return;
        }

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void printLinkedListRevert(ListNode head) {
        if (null == head) {
            return;
        }

        while (head != null) {
            System.out.println(head.value);
            head = head.pre;
        }
    }
}
