import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class MyArrayList<E> {
    private Object[] elementData;// 数组，不写E，因为new的时候需要反射
    private int usedSize;// 代表有效的数据个数

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int capacity) {
        // 对参数进行判断
        if(capacity > 0) {
            this.elementData = new Object[capacity];
        }else if(capacity == 0) {
            this.elementData = new Object[0];
        }else {
            throw new IllegalArgumentException("初始化的容量不能为负数");
        }
    }

    /**
     * 添加元素,相当于存放在了数组的最后位置
     * @param e 数据
     * @return
     */
    public boolean add(E e) {
        // 确定一个真正的容量,预测->扩容【把检查顺序表空和满和扩容放到了一起】
        ensureCapacityInternal(usedSize+1);
        elementData[usedSize] = e;
        usedSize++;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        //1：计算出需要的容量
        int capacity = calculateCapacity(elementData,minCapacity);
        //2、拿着计算出的容量，去看，满了扩容；空的也是，给一个明确的容量。
        ensureExplicitCapacity(capacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // 进不去if语句，数组还没有放满
        if (minCapacity - elementData.length > 0)
            // 满了就扩容
            grow(minCapacity);
    }

    private static final int MAX_ARRAY_SIZE =  Integer.MAX_VALUE - 8;

    /**
     * 扩容
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);// 1.5倍扩容
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);// 说明你要的容量非常大
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();// 输出内存错误
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // 1：是否之前elementData数组分配过大小
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(10,minCapacity);
        }
        // 2：分配过，就返回+1后的值
        return minCapacity;
    }

    /**
     * 给index位置添加元素
     * @param index
     * @param e
     */
    public void add(int index,E e) {
        //1：检查下标是否合法
        rangeCheckForAdd(index);
        //2：确定真正的容量
        ensureCapacityInternal(usedSize+1);
        //3：挪数据
        copy(index,e);
        usedSize++;
    }

    /**
     * 数据往后移动后插入元素
     * @param index
     * @param e
     */
    private void copy(int index,E e) {
        for (int i = usedSize-1; i >= index ; i--) {
            elementData[i+1] = elementData[i];
        }
        elementData[index] = e;
    }

    /**
     * 判断下标书否合法
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index位置不合法，不能插入！");
        }
    }

    /**
     * 获取顺序表的大小
     * @return
     */
    public int size() {
        return this.usedSize;
    }

}

public class TestDemo {


    public static void main56(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("ab");
        list.add("abc");
        list.add("abcd");
        list.add("abcde");
        list.add(2,"gaobo");
        System.out.println("fdsafdsafafaf");// 在这断点进行调试检测
    }


    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();// 初始的大小是几？答案是0
        list1.add("haha!");// 当第一次存放数据元素的时候，顺序表被分配大小为10
        System.out.println(list1);
        ArrayList<String> list2 = new ArrayList<>(13);//初始大小是指定的13
        /*关于ArrayList的扩容机制，可以单独的写一篇博客！写博客的时候一定要看博哥的上课笔记！*/
    }


    /**
     * ArrayList的各种方法
     * @param args
     */
    public static void main5(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");// 尾插元素
        list2.add("b");
        list2.add("c");
        list2.add("a");
        System.out.println(list2);

        /*list2.add(0,"xiangzi");// 再0位置插元素
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("我是测试List1");
        list3.add("我是测试List2");
        list3.add("我是测试List3");
        list2.addAll(list3);// 在list2后加加list3
        System.out.println(list2);*/

        /*String ret = list2.remove(0);// 删除0下标的元素
        System.out.println(ret);
        System.out.println(list2);

        boolean ret2 = list2.remove("b");// 删除“b”元素
        System.out.println(ret2);
        System.out.println(list2);

        String ret3 = list2.get(0);// 获取0下标的值
        System.out.println(ret3);

        String ret4 = list2.set(0, "r");// 返回的是原来的字符串
        System.out.println(list2);

        list2.clear();// 清除元素
        System.out.println(list2);*/

       /* boolean ret = list2.contains("a");// 判断a是否在线性表中
        System.out.println(ret);

        System.out.println(list2.indexOf("a"));// 返回第一个a的下标
        System.out.println(list2.lastIndexOf("a"));// 返回最后一个a的下标*/

        List<String> sub = list2.subList(1, 3);
        System.out.println(sub);// 截取1到3的元素

        /*在这里注意一个问题：*/
        System.out.println("=================");
        list2.set(1, "p");
        System.out.println(sub);// 打印的是 [p, c]
        System.out.println(list2);// 打印的是 [a, p, c, a]
        /*发现上面两个打印的都有“p”，这个可以得出一个结论：其实这个不是真正的截取下来了，而是将1到3的元素的起始地址给了sub！*/
    }

    /**
     * 注意：抛出异常 java.util.ConcurrentModificationException
     * @param args
     */
    public static void main4(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();// 不是线程安全的 单线程
//        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();// 线程安全的 多线程
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");

        /*Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            String ret = it.next();
            if(ret.equals("hello")) {
                it.add();//没有add方法
            }else {
                System.out.print(ret + " ");
            }
        }*/

        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if(ret.equals("bit")) {
                it2.add("xiangzi");// 这个时候不会报错
//                list2.add("gaobo");//抛出异常 java.util.ConcurrentModificationException
            }else {
                System.out.print(ret + " ");
            }
        }
        System.out.println("=================");
        System.out.println(list2);// 迭代器打印出来非常的特殊，这里不明白的话去看博哥上课的笔记
        /*注意：一般实现了List接口的都可以用ListIterator打印！*/
    }

    /**
     * java.lang.IllegalStateException
     * 注意上面的异常
     * @param args
     */
    public static void main3(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");

        Iterator<String> it = list2.iterator();

         /* while (it.hasNext()) { // 这个时候就会有一个异常
            it.remove();// 通过迭代器删除时报错：java.lang.IllegalStateException
            System.out.print(it + " ");
        }*/

        /*while (it.hasNext()) {
            String ret = it.next();//首先需要使用next方法迭代出集合中的元素 ，然后才能调用remove方法
            if(ret.equals("hello")) {
                it.remove();
                System.out.print(ret + " ");
            }
        }*/

        System.out.println();
        System.out.println("========迭代器List相关打印==========");
        ListIterator<String> it2 = list2.listIterator();

        while (it2.hasNext()) {
            String ret = it2.next();// 首先需要使用next方法迭代出集合中的元素 ，然后才能调用remove方法
            if(ret.equals("hello")) {
                it2.remove();
                /*通过迭代器遍历List的时候，首先要迭代出所有的元素。然后上面的代码中根据所给的条件删除迭代出的元素！*/
            }else {
                System.out.print(ret + " ");
            }
        }
    }

    /**
     * 打印ArrayList
     * @param args
     */
    public static void main2(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");
        System.out.println(list2);
        System.out.println("================");
        for(int i = 0; i< list2.size();i++) {
            System.out.print (list2.get(i)+" ");
        }
        System.out.println();
        System.out.println("==================");
        for (String s : list2) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("========迭代器打印==========");
        Iterator<String> it = list2.iterator();// 它没有add方法和remove方法，ListIterator有的
        while (it.hasNext()) {
            System.out.print(it.next()+" ");// 这里的it首先指向第一个元素的前一个位置
        }

        System.out.println();
        System.out.println("========迭代器List相关打印==========");
        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next()+" ");
        }
        /*关于迭代器的打印有两个注意点（两个异常）要注意，看下面的代码！*/
    }

    public static void main1(String[] args) {

        List<String> list = new ArrayList<>(20);// 这个好像用的多一点

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");
        System.out.println(list2);

        //使用另外一个ArrayList对list3进行初始化
        ArrayList<String> list3 = new ArrayList<>(list2);

    }
}