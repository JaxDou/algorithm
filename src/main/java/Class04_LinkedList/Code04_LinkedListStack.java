package Class04_LinkedList;

/**
 * @Describe
 * @Author Jax
 * @Date 2023/2/8 23:10
 */
public class Code04_LinkedListStack {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
    }
}


class LinkedListStack<T> {
    public StackNode<T> head;
    public int size;

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    /**
     * 压栈
     *
     * @return
     */
    public boolean push(T data) {
        if (size == 0) {
            StackNode<T> stackNode = new StackNode<>(data);
            head = stackNode;
            size++;
            return true;
        }
        StackNode<T> stackNode = new StackNode<>(data);
        stackNode.next = head;
        head = stackNode;
        size++;
        return true;
    }

    public StackNode<T> pop() {
        if (0 == size) {
            return null;
        }
        StackNode res = head;
        head = head.next;
        return res;
    }


}


class StackNode<T> {
    public StackNode(T data) {
        this.data = data;
    }

    /**
     * 数据
     */
    T data;

    /**
     * 指向下一元素的指针
     */
    StackNode<T> next;
}