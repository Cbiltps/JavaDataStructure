class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

public class MyQueue {
    public Node head;
    public Node last;

    /**
     * 尾插法
     * @param val
     */
    public void offer(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            last = last.next;
        }
    }

    /**
     * 出队
     * @return
     */
    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int oldVal = head.val;
        this.head = head.next;
        return oldVal;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }
}