/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-07-07
 * Time: 14:33
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createList();
        myLinkedList.display();
        System.out.println(myLinkedList.contains(12));
        System.out.println(myLinkedList.size());
        myLinkedList.addFirst(8);
        myLinkedList.addLast(9);
        myLinkedList.display();
        myLinkedList.addIndex(2, 90);
        myLinkedList.display();
        myLinkedList.remove(12);
        myLinkedList.display();
        myLinkedList.addIndex(1, 32);
        myLinkedList.display();
        myLinkedList.removeAllKey(32);
        myLinkedList.display();
        myLinkedList.clear();
        myLinkedList.display();
    }
}
