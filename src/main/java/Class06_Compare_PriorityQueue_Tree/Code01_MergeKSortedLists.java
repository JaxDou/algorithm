package Class06_Compare_PriorityQueue_Tree;

import Class04_LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Describe leetcode-23.合并K个升序链表-给定一个头节点List 每个元素是一个有序链表的头节点，将这些链表合并为一个有序链表
 * @Author Jax
 * @Date 2023/2/20 23:44
 */
public class Code01_MergeKSortedLists {


    public static void main(String[] args) {

    }


    /**
     * 1.构建一个小根堆
     * 2.将所有头节点压入,此时最小的头节点在堆顶
     * 3.依次弹出每次弹出后连接并且将弹出节点的下一个节点压入这样保证了所有链表元素的有序
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKSortedLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }

        // 定义最后返回的结果链表的头节点
        ListNode resHead;
        ListNode currentNode;
        PriorityQueue<ListNode> smallHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v.value));
//        PriorityQueue<ListNode> smallHeap = new PriorityQueue<>((v1, v2) -> v1.value - v2.value);

        // 先将所有头节点压入堆
        for (ListNode head : lists) {
            if (null != head) {
                smallHeap.add(head);
            }
        }
        // 若传入的都为空则直接返回
        if (smallHeap.isEmpty()) {
            return null;
        }
        ListNode minNode = smallHeap.poll();
        resHead = minNode;
        currentNode = resHead;
        if (null != currentNode.next) {
            smallHeap.add(currentNode.next);
        }
        while (!smallHeap.isEmpty()) {
            // 弹一个节点出来并连接到当前链表尾端
            ListNode t = smallHeap.poll();
            currentNode.next = t;

            // 获取该节点的下一个节点
            ListNode addNode = t.next;
            // 若不为空则入堆
            if (null != addNode) {
                smallHeap.add(addNode);
            }
            currentNode = currentNode.next;
        }
        return resHead;
    }
}
