

/*注意了：到这里关于队列知识暂时就先到这里了，
* 还有一个PriorityQueue，需要二叉树的知识，
* 所以，等学完二叉树回头学PriorityQueue!*/






import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;



public class Main {
    // MyQueue的测试
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());//1
        System.out.println(queue.poll());//1
        System.out.println(queue.poll());//2
        System.out.println(queue.poll());//3
        System.out.println(queue.poll());// 抛异常
    }

    // 方法演示
    public static void main3(String[] args) {
        Deque<Integer> queue2 = new LinkedList<>();
        queue2.offerLast(1);//默认队尾入队的
        queue2.offerFirst(2);
        //2 1
        System.out.println(queue2.peekFirst());//2
        System.out.println(queue2.peekLast());//1
    }

    // 方法演示
    public static void main2(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        System.out.println(queue.peek());//1
        System.out.println(queue.poll());//1
    }

    public static void main1(String[] args) {
        // 下面三个有什么不一样
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
    }
}
