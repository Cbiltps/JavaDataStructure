import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;// 实际使用大小

    public TestHeap() {
        this.elem = new int[10];
    }

    /**
     * 向下调整函数的实现
     * @param parent 每棵树的根节点
     * @param len 每棵树调整过的长度
     */
    public void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        //1、最起码是有左孩子的, 至少有1个孩子
        while (child < len) {
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;//保证当前左右孩子最大值的下标
            }
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 注意:这个方法的时间复杂度为O(n), 具体的过程看下面的链接.
     * https://gitee.com/gaobo1/java-102/blob/master/102-%E6%9D%BF%E4%B9%A6/2022-01-22-%E4%BA%8C%E5%8F%89%E6%A0%91%E5%AE%8C+%E5%A0%86.png
     * @param array
     */
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for (int parent = ((usedSize-1)-1)/2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 向上调整
     * @param child 孩子的下标
     */
    private void shiftUp(int child) {
        int parent = (child-1) / 2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1) / 2;
            } else {
                break;
            }
        }
    }

    public void offer(int val) {
        if(isFull()) {
            //扩容
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
        //注意这里传入的是最后一个孩子的下标
        shiftUp(usedSize-1);
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("优先级队列为空!");
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        usedSize--;
        shiftDown(0, usedSize);
        return tmp;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("优先级队列为空!");
        }
        return elem[0];
    }
}