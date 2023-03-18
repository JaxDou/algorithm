package Class04_LinkedList;

/**
 * @Describe K个节点组内逆序链表
 * <p>
 * 找到链表的第K个元素并返回第几K个节点
 * 3->1->5->2->9 , K = 2
 * |1->3|->|2->5|-> 9
 * PS:K个节点分组反转不足K的不反转
 * leetcode-25. K 个一组翻转链表
 * @Author Jax
 * @Date 2023/2/13 22:27
 */
public class Code06_ReverseNodeInKGroup {

    /**
     * @param head
     * @param k
     * @return
     */
    public static ListNode nodeGroupByK(ListNode head, int k) {
        while (--k > 0 && null != head) {
            head = head.next;
        }
        return head;
    }


    /**
     * 反转指定链表并将反转后的最后一个节点指向反转前end节点的下一个节点
     *
     * @param head
     * @param end
     * @return
     */
    public static void reverseNode(ListNode head, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cuurent = head;
        ListNode next = null;

        while (cuurent != end) {
            next = cuurent.next;
            cuurent.next = pre;
            pre = cuurent;
            cuurent = next;
        }
        head.next = end;
    }


    /**
     * 1.将规定的K个元素划分为子链表,并返回尾节点
     * 2.对子链表先执行反转并将反转后的最后一个节点连像下一个K组的首个节点
     * 3.上一组最后一个节点指向调整,指向下一组的第一个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseNodeInKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode start = head;
        // 获取第K个节点
        ListNode end = nodeGroupByK(start, k);

        // 若为空则直接返回head(表示当前链表长度不够K)
        if (null == end) {
            return head;
        }

        // 不为空则令返回的end作为head(最后返回调整完毕的头节点一定是第一次旋转的后的头节点)
        head = end;

        // 执行局部反转得到局部反转后的最后一个节点作为last
        reverseNode(start, end);
        // 保存当次反转的最后一个节点
        ListNode lastEnd = start;
        // 当次反转后下一个节点不为空则继续反转
        while (null != lastEnd.next) {
            start = lastEnd.next;
            end = nodeGroupByK(start, k);
            // end等于空时则表示后续长度不够k返回head
            if (null == end) {
                return head;
            }
            reverseNode(start, end);
            lastEnd.next = end;
            // 将lastEnd节点的值更新为当次反转的结尾
            lastEnd = start;
        }
        return head;
    }
}
