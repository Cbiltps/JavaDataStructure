import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description: 当key是一个引用类型(就会使用泛型)的时候, 有什么不一样? 接下来怎么办?
 * 看下面代码:
 *     int index = key % array.length;
 *     key是一个引用, 这个时候没有办法计算哈希地址啊!
 *     此时, hashCode可以将这个引用转化为合法正数用于计算哈希地址!
 * User: cbiltps
 * Date: 2023-02-27
 * Time: 01:49
 */
class Person {
    public String ID;

    public Person(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID);
    }

    /**
     * 确定哈希地址
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    /**
     * 确定key是否一致
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                '}';
    }
}

public class HashBuck2<K, V> {
    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.val = val;
            this.key = key;
        }
    }

    public Node<K, V>[] array = (Node<K, V>[])new Node[10];// 尽量不要这样写代码
    public int usedSize;

    public void put(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node<K, V> node = new Node<>(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1,"bit");

        System.out.println(hashBuck2.get(person2));// 拿到的还是bit

        /*
        最后提出问题:
        hashCode一样, equals一样吗? 不一定
        equals一样, hashCode一样吗? 一定
         */
    }


    /**
     * 引出hashCode方法及作用
     * @param args
     */
//    public static void main(String[] args) {
//        Person person1 = new Person("123");
//        Person person2 = new Person("123");
//
//        System.out.println(person1.hashCode());
//        System.out.println(person2.hashCode());
//        /*
//        没写重写hashCode的时候运行结果, 打印的值是不一样的!
//        但是, 他们的ID是一样的, 就是一个人啊!
//        让他们变成一个人,
//        这就是hashCode的的作用!
//         */
//    }
}
