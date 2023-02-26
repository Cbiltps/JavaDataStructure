/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-02-26
 * Time: 23:25
 */
public class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;// 每放置一个元素就++, 用于计算负载因子

    public static final double DEFAULT_LOAD_FACTOR = 0.75;// 负载因子默认值是0.75

    public HashBuck() {
        this.array = new Node[10];
    }

    /**
     * put函数
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        // 1. 找位置key所在的位置
        int index = key % this.array.length;// 自定义一个哈希函数, 并假设key是正数(所以这是有缺陷的)
        // 2. 遍历index下边的链表, 查看是否有相同的key, 有则覆盖其val值
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;// 覆盖其val值
                return;// 覆盖之后此次插入就结束了
            }
            cur = cur.next;
        }
        // 3. 没有相同的key, 创建并插入元素至链表(头插/尾插), jdk1.7是头插, jdk1.8是尾插(多写一个循环), 下面用头插展示
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        // 4. 插入元素之后, 检查当前散列表的负载因子, 考虑是否扩容
            if (loadFactor() >= DEFAULT_LOAD_FACTOR) {
                resize();// 扩容
            }
    }

    /**
     * 如果选择扩容数组, 那么数组里面的每个链表的每个元素都 要重新哈希 !!!
     * 因为
     * 14 % 10 = 4
     * 24 % 10 = 14
     */
    private void resize() {
        Node[] newArray = new Node[2 * this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int newIndex = cur.key % newArray.length;// 获取新的下标
                // 然后把cur这个节点, 插入到新的数组对应下标的链表当中(以头插/尾插的形式)
                Node curNext = cur.next;// 记录原数组某链表中一个元素的cur.next, 防止后面的节点丢失(因为一个链表中不只有一个元素)
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curNext;
            }
        }
        array = newArray;// 改变引用, 原数组被JVM垃圾回收
    }

    /**
     * 计算负载因子
     * @return
     */
    private double loadFactor() {
        return 1.0 * this.usedSize / this.array.length;
    }

    /**
     * 根据key获取val值
     * @param key
     * @return
     */
    public int get(int key) {
        // 1. 找位置key所在的位置
        int index = key % this.array.length;
        // 2. 遍历index下边的链表, 查看是否有相同的key, 有则直接返回
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return  -1;
    }

    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(12,12);
        hashBuck.put(3,3);
        hashBuck.put(6,6);
        hashBuck.put(7,7);
        hashBuck.put(2,2);
        hashBuck.put(11,11);
        hashBuck.put(8,8);// 从第八个开始扩容
        System.out.println(hashBuck.get(11));
    }
}
