package Class04_LinkedList;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/2/8 21:54
 */
public class Code03_LinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(10);
        queue.offer(1);
        queue.offer(2);
        queue.printQueue();
        System.out.println("---");
        queue.offer(3);
        queue.printQueue();
        System.out.println("弹出-" + queue.pool());
        queue.printQueue();
        System.out.println("弹出-" + queue.pool());
        queue.printQueue();
        System.out.println("弹出-" + queue.pool());
        queue.printQueue();
        System.out.println("弹出-" + queue.pool());
        queue.printQueue();
        System.out.println("弹出-" + queue.pool());
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);

        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
    }

}

/**
 * 队列定义
 * @param <T>
 */
class LinkedListQueue<T> {
    /**
     * 头指针
     */
    public QueueNode<T> head;

    /**
     * 尾指针
     */
    public QueueNode<T> tail;

    /**
     * 队列大小
     */
    int size;

    /**
     * 当前节点长度
     */
    int currentCount = 0;

    public LinkedListQueue(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return currentCount == 0;
    }

    public int size() {
        return currentCount;
    }


    /**
     * 添加元素
     *
     * @param data
     * @return
     */
    public boolean offer(T data) {
        QueueNode<T> queueNode = new QueueNode(data);
        if (null == head && null == tail) {
            head = queueNode;
            tail = queueNode;
            currentCount++;
            return true;
        }

        // 队列已满
        if (size == currentCount) {
            System.out.println("队列已满");
            return false;
        }

        // 入队操作
        tail.next = queueNode;
        tail = queueNode;
        currentCount++;
        return true;
    }

    /**
     * 出队元素
     *
     * @return
     */
    public QueueNode pool() {
        if (null == head) {
            System.out.println("队列不存在元素");
            return null;
        }
        QueueNode tmp = head;
        head = head.next;
        currentCount--;
        return tmp;
    }

    /**
     * 查看下一个要出队的节点信息,但不出队
     *
     * @return
     */
    public QueueNode peek() {
        return head;
    }


    public void printQueue() {
        if (currentCount == 0) {
            return;
        }
        QueueNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}




/**
 * 队列节点定义
 * @param <T>
 */
class QueueNode<T> {
    public QueueNode(T data) {
        this.data = data;
    }

    /**
     * 数据
     */
    T data;

    /**
     * 指向下一元素的指针
     */
    QueueNode<T> next;


}
