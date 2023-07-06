/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-07-06
 * Time: 18:17
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(0, 1);
        myArrayList.add(1, 2);
        myArrayList.add(2, 3);
        myArrayList.add(3, 4);
        myArrayList.display();
        myArrayList.remove(29);
        myArrayList.setPos(0, 0);
        myArrayList.display();
        System.out.println(myArrayList.contains(3));
        System.out.println(myArrayList.getPos(1));
        myArrayList.clear();
        myArrayList.display();
    }

    /**
     * 验证数组的扩容机制
     * @param args
     */
//    public static void main(String[] args) {
//        MyArrayList<String> list = new MyArrayList<>();
//        list.add("ab");
//        list.add("abc");
//        list.add("abcd");
//        list.add("abcde");
//        list.add(2,"xiangzi");
//        list.display();
//    }
}
