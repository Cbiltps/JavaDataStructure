import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[5];
    }

    /**
     * 压栈
     * @param val
     */
    public void push(int val) {
        if(isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        int oldVal = this.elem[usedSize-1];
        this.usedSize--;
        return oldVal;
    }

    /**
     * 出栈但不删除
     * @return
     */
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return this.elem[usedSize-1];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
}
