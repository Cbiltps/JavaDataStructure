import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-07-06
 * Time: 17:53
 */
class MyArrayList<E> {
    private Object[] elem; // 数组
    private int usedSize; // 有效的数据个数

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elem = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int capacity) {
        // 对参数进行判断
        if(capacity > 0) {
            this.elem = new Object[capacity];
        }else if(capacity == 0) {
            this.elem = new Object[0];
        }else {
            throw new IllegalArgumentException("初始化的容量不能为负数!");
        }
    }

    /**
     * 添加元素(扩容版)
     * @param e 数据
     * @return
     */
    public boolean add(E e) {
        // 确定一个真正的容量, 把检查顺序表空/满/扩容放到了一起
        ensureCapacityInternal(usedSize + 1);
        elem[usedSize] = e;
        usedSize++;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        // 1. 计算出需要的容量
        int capacity = calculateCapacity(elem,minCapacity);
        // 2. 如果满了就扩容, 空的也是
        ensureExplicitCapacity(capacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // 未进if语句, 数组还没有放满
        if (minCapacity - elem.length > 0)
            // 扩容
            grow(minCapacity);
    }

    private static final int MAX_ARRAY_SIZE =  Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = elem.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 1.5倍扩容
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            // 说明你要的容量非常大
            newCapacity = hugeCapacity(minCapacity);
        elem = Arrays.copyOf(elem, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // 1. 是否之前elementData数组分配过大小
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(10,minCapacity);
        }
        // 2. 分配过就返回+1后的值
        return minCapacity;
    }

    /**
     * 添加元素, 相当于存放在了数组的最后位置(扩容版)
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        // 1. 检查下标是否合法
        rangeCheckForAdd(index);
        // 2. 确定真正的容量
        ensureCapacityInternal(usedSize + 1);
        // 3. 挪数据
        copy(index, e);
        usedSize++;
    }

    private void copy(int index, E e) {
        for (int i = usedSize - 1; i >= index ; i--) {
            elem[i + 1] = elem[i];
        }
        elem[index] = e;
    }

    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index位置不合法, 不能插入!");
        }
    }

    /**
     * 获取顺序表的有效数据长度
     * @return
     */
    public int size() {
        return this.usedSize;
    }

    /**
     * 打印顺序表
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    /**
     * 添加元素, 相当于存放在了数组的最后位置(简易版-扩容版在上面)
     * @param pos
     * @param e
     */
    public void easyToAdd(int pos, E e) {
        if(pos < 0 || pos > usedSize) {
            System.out.println("pos 位置不合法!");
            return;
        }
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = e;
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 判定是否包含某个元素
     * @param toFind
     * @return
     */
    public boolean contains(E toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素对应的位置, 找不到返回-1
     * @param toFind
     * @return
     */
    public int search(E toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取 pos 位置的元素
     * @param pos
     * @return
     */
    public Object getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos 位置不合法");
            return -1;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空!");
            return -1;
        }
        return this.elem[pos];
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 给 pos 位置的元素设为(更新) value
     * @param pos
     * @param value
     */
    public void setPos(int pos, E value) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法!");
            return;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空!");
            return;
        }
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字 key
     * @param toRemove
     */
    public void remove(E toRemove) {
        if(isEmpty()) {
            System.out.println("顺序表为空!");
            return;
        }
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("没有你要删除的数字!");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
//        this.elem[usedSize] = null; // 如果数组当中是引用数据类型
    }

    /**
     * 清空顺序表
     */
    public void clear() {
//        for (int i = 0; i < usedSize; i++) {
//            this.elem[i] = null;
//        }
        this.usedSize = 0;
        System.out.println("置空!");
    }
}