import java.util.*;

class MyArrayList<E> {
    private Object[] elementData;//数组
    private int usedSize;//代表有效的数据个数

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int capacity) {
        //对参数进行判断
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
        //确定一个真正的容量,预测->扩容【把检查顺序表空和满和扩容放到了一起】
        ensureCapacityInternal(usedSize+1);
        elementData[usedSize] = e;
        usedSize++;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        //1、计算出需要的容量
        int capacity = calculateCapacity(elementData,minCapacity);
        //2、拿着计算出的容量，去看，满了扩容。空的也是。给一个明确的容量
        ensureExplicitCapacity(capacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // 进不去if语句，数组还没有放满
        if (minCapacity - elementData.length > 0)
            //扩容了
            grow(minCapacity);
    }

    private static final int MAX_ARRAY_SIZE =  Integer.MAX_VALUE-8;
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//1.5倍扩容
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE> 0)
            //说明你要的容量非常大
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //1、是否之前elementData数组分配过大小
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(10,minCapacity);
        }
        //2、分配过 就返回+1后的值
        return minCapacity;
    }

    /**
     * 给index位置添加元素
     * @param index
     * @param e
     */
    public void add(int index,E e) {
        //1/检查下标是否合法
        rangeCheckForAdd(index);
        //2、确定真正的容量
        ensureCapacityInternal(usedSize+1);
        //3、挪数据
        copy(index,e);
        usedSize++;
    }

    private void copy(int index,E e) {
        for (int i = usedSize-1; i >= index ; i--) {
            elementData[i+1] = elementData[i];
        }
        elementData[index] = e;
    }

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


    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("ab");
        list.add("abc");
        list.add("abcd");
        list.add("abcde");
        list.add(2,"gaobo");
        System.out.println("fdsafdsafafaf");
    }


    public static void main6(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();//初始的大小是几？答案是0
        list1.add("haha!");//当第一次存放数据元素的时候，顺序表被分配大小为10
        System.out.println(list1);
        ArrayList<String> list2 = new ArrayList<>(13);//初始大小是指定的13
    }



    public static void main5(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        list2.add("g");
        list2.add("a");
        list2.add("o");
        List<String> sub = list2.subList(1,3);
        System.out.println(sub);
        System.out.println(list2);
        System.out.println("==================");
        sub.set(0,"p");
        System.out.println(sub);
        System.out.println(list2);

       /*System.out.println(list2);
        System.out.println(list2.lastIndexOf("c"));

 String ret = list2.set(2,"gaobo");
        System.out.println("原来的字符串"+ret);
        System.out.println(list2);
 list2.add(0,"gaobo");
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("我是测试List1");
        list3.add("我是测试List2");
        list3.add("我是测试List3");
        list2.addAll(list3);
        System.out.println(list2);*/


    }

    public static void main4(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        //CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
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
            String ret = it2.next();//抛出异常
            if(ret.equals("bit")) {
                list2.add("gaobo");
            }else {
                System.out.print(ret + " ");
            }
        }
        System.out.println("=================");
        System.out.println(list2);
    }

    public static void main3(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");
        /*Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            String ret = it.next();
            if(ret.equals("hello")) {
                it.remove();//首先需要使用next方法迭代出集合中的元素 ，然后才能调用remove方法
            }else {
                System.out.print(ret + " ");
            }
        }*/

        System.out.println();
        System.out.println("========迭代器List相关打印==========");
        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if(ret.equals("hello")) {
                it2.remove();//首先需要使用next方法迭代出集合中的元素 ，然后才能调用remove方法
            }else {
                System.out.print(ret + " ");
            }
        }
    }
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
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }

        System.out.println();
        System.out.println("========迭代器List相关打印==========");
        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next()+" ");
        }
    }
    public static void main1(String[] args) {

        List<String> list = new ArrayList<>(20);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");
        System.out.println(list2);

        //使用另外一个ArrayList对list3进行初始化
        ArrayList<String> list3 = new ArrayList<>(list2);

    }
}