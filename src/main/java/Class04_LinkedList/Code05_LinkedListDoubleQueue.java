package Class04_LinkedList;

/**
 * @Describe 双向链表实现双端队列
 * @Author Jax
 * @Date 2023/2/12 23:16
 */

/**
 * 测试主类
 */
public class Code05_LinkedListDoubleQueue {
    public static void main(String[] args) {
        LinkedListDoubleQueue<Integer> integerLinkedListDoubleQueue = new LinkedListDoubleQueue<>();
        integerLinkedListDoubleQueue.pushHead(1);
        integerLinkedListDoubleQueue.pushHead(2);
        integerLinkedListDoubleQueue.pushHead(3);
//        System.out.println(integerLinkedListDoubleQueue.poptail().data);
//        System.out.println(integerLinkedListDoubleQueue.poptail().data);
//        System.out.println(integerLinkedListDoubleQueue.poptail().data);


        System.out.println(integerLinkedListDoubleQueue.popHead().data);
        System.out.println(integerLinkedListDoubleQueue.popHead().data);
        System.out.println(integerLinkedListDoubleQueue.popHead().data);
    }

}

/**
 * 双端队列实现类
 */
class LinkedListDoubleQueue<T> {

    /**
     * 队列长度
     */
    public int size;

    /**
     * 头结点
     */
    public DoubleQueueNode<T> head;

    /**
     * 尾节点
     */
    public DoubleQueueNode<T> tail;

    public LinkedListDoubleQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列当前长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 队头加入元素
     *
     * @param data 入队元素
     * @return
     */
    public boolean pushHead(T data) {
        DoubleQueueNode dataNode = new DoubleQueueNode(data);
        // 判断head或tail为空效果一样
        if (null == head) {
            // 为空则加入第一个元素
            head = dataNode;
            tail = dataNode;
            size++;
            return true;
        }

        // 若head不为空
        dataNode.next = head;
        head.pre = dataNode;
        head = dataNode;
        size++;
        return true;
    }

    public boolean pushTail(T data) {
        DoubleQueueNode dataNode = new DoubleQueueNode(data);
        // 判断head或tail为空效果一样
        if (null == tail) {
            // 为空则加入第一个元素
            head = dataNode;
            tail = dataNode;
            size++;
            return true;
        }

        // 若tail不为空
        tail.next = dataNode;
        dataNode.pre = tail;
        tail = dataNode;
        size++;
        return true;

    }

    /**
     * 从头部弹出元素
     *
     * @return
     */
    public DoubleQueueNode popHead() {
        if (0 == size) {
            return null;
        }
        DoubleQueueNode popNode = head;
        head = head.next;
        if (null == head) {
            tail = null;
            return popNode;
        } else {
            head.pre = null;
        }
        size--;
        return popNode;
    }

    /**
     * 从队尾弹出元素
     * @return
     */
    public DoubleQueueNode poptail() {
        if (0 == size) {
            return null;
        }
        DoubleQueueNode popNode = tail;
        tail = tail.pre;

        if (null == tail) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return popNode;
    }

}

/**
 * 节点定义
 *
 * @param <T> 存储的数据类型
 */
class DoubleQueueNode<T> {

    public DoubleQueueNode(T data) {
        this.data = data;
        next = null;
        pre = null;
    }

    public T data;
    /**
     * 后继节点指针
     */
    public DoubleQueueNode next;

    /**
     * 前驱节点指针
     */
    public DoubleQueueNode pre;

}


