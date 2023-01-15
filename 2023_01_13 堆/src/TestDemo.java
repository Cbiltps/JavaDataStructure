public class TestDemo {
//    public static void main(String[] args) {
//        //它默认是一个大堆还是小堆?
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        // 没放置一个元素, 都要保证当前堆是大堆或者是小堆
//        priorityQueue.add(15);
//        priorityQueue.add(13);
//        priorityQueue.add(20);
//        System.out.println(priorityQueue.peek());// 验证默认是小堆
//    }

    public static void main(String[] args) {
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);
        testHeap.offer(80);
        System.out.println(testHeap.poll());
        System.out.println("此处断点看数组是什么情况!");
    }
}
