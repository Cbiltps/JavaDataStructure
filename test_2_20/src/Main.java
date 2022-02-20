
    // 可以将类型作为参数进行传递——泛型 本质 做的事情就是把类型参数化了

    // 泛型的意义：1：自动对类型进行检查 2：自动对类型进行强制类型转换

    /*
    * 泛型第一个需要注意的问题：
    * 1：泛型不能够实例化泛型数组
    * 2：泛型中尖括号当中的内容，不参与类型的组成*/

    /*
    * 面试问题；泛型是如何编译的？
    * 1：泛型是编译期的一种机制，这种机制叫做擦除机制，就是运行的时候会把尖括号的东西擦掉，擦成Object（可以去看反汇编代码）*/


    import java.util.ArrayList;

    class MyArrayList<E> {
    private E[] elem;
    private int usedSize;
    public MyArrayList() {
        this.elem = (E[])new Object[10];
        //this.elem = new E[10];
    }

    public void add(E val) {
        this.elem[usedSize] = val;
        usedSize++;
    }

    public E get(int pos) {
        return this.elem[pos];
    }

    /*public <T> T[] getArray(int size) {
        T[] genericArray = new T[size]; // suppose this is allowed
        return genericArray;
    }*/

    // 擦除后是下面这样的!

    public Object[] getArray(int size) {
        Object[] genericArray = new Object[size];
        return genericArray;
    }

}
public class Main {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();

//        String[] rets = (String[])myArrayList1.getArray(10);// 通过上面的方法创建一个大小为10的数组
        /*想要得到泛型数组，代码是不能向上面一样写的，就像之前说的：整体虽然转换了，但是内容是没有转换的！
        * 所以，上面的代码（this.elem = (E[])new Object[10];）也是错误的，正确的是通过反射获取的！
        * 这一点了解一下就可！
        *
        * 相比较之下，类库ArrayList不是这样创建的！
        * 点进去自己看！*/


    }

    // 这里打印的时候，就可以发现一个问题：泛型中尖括号当中的内容，不参与类型的组成
    public static void main4(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        System.out.println(myArrayList1);
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        System.out.println(myArrayList2);
        MyArrayList<Boolean> myArrayList3 = new MyArrayList<>();
        System.out.println(myArrayList3);
    }

    public static void main3(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("ABC");
        myArrayList1.add("bit");
        String ret = myArrayList1.get(1);
        System.out.println(ret);

        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(12);
        myArrayList2.add(31);
        int ret2 = myArrayList2.get(1);
        System.out.println(ret2);
    }

    /**
     * 有了泛型之后就可以放置指定的元素
     * @param args
     */
    public static void main2(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        MyArrayList<Boolean> myArrayList3 = new MyArrayList<>();
    }


    /**
     * 写成Object类型的数组之后里面什么都可以放
     * @param args
     */
    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add("hello");
        String ret = (String)myArrayList.get(1);
        System.out.println(ret);
    }
}