/**
 * Created with IntelliJ IDEA.
 * Description: 无头单向非循环链表实现
 * User: cbiltps
 * Date: 2023-07-07
 * Time: 14:33
 */

/**
 * 创建结点
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    public ListNode head = null; // 列表的头引用

    public void createList() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(22);
        ListNode node4 = new ListNode(32);
        ListNode node5 = new ListNode(42);

        this.head = node1; // 设置头结点

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
    }

    public void display() {
        // 判断空节点
        if (head == null) {
            System.out.println("空结点!");
            return;
        }

        ListNode cur = this.head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);

        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    // 尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);

        if (this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            // 等到 cur.next == null 的时候
            cur.next = node;
        }
    }

    // 任意位置插入(第一个数据节点为0号下标)
    public void addIndex(int index, int data) {
        // 判断下标是否合法
        if (index < 0 || index > size()) {
            System.out.println("位置不合法!");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size()) {
            addLast(data);
            return;
        }

        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到 index - 1 号下标的位置
     * @return
     */
    private ListNode findIndex(int index) {
        // 上面方法中已经判断过下标的合法性了, 所以这里直接写即可(不用判断 head == null)
        ListNode cur = this.head;

        while (index-1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }


    // 查找是否包含关键字 key 是否在单链表当中
    public boolean contains(int key) {
        // 判断空节点
        if (this.head == null) {
            System.out.println("空结点!");
            return false;
        }

        ListNode cur = this.head;

        while (cur != null) {
            if (cur.val == key) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    // 删除第一次出现关键字为 key 的节点
    public void remove(int key) {
        // 判断空节点
        if (this.head == null) {
            System.out.println("空结点, 无法删除!");
            return;
        }

        // 删除头结点
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }

        ListNode cur = searchPerv(key);
        if (cur == null) {
            System.out.println("没找到结点, 无法删除!");
            return;
        }
        ListNode delNode = cur.next;
        cur.next = delNode.next;
    }

    /**
     * 找到 要删除的关键字的前驱
     * @param key
     * @return
     */
    public ListNode searchPerv(int key) {
        ListNode cur = this.head;

        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    // 删除所有值为 key 的节点
    public void removeAllKey(int key) {
        // 判断空节点
        if (this.head == null) {
            System.out.println("空结点, 无法删除!");
            return;
        }

        ListNode prev = this.head;
        ListNode cur = this.head.next;

        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        // 如果头结点也要删除, 最后处理
        if (this.head.val == key) {
            this.head = this.head.next;
        }

    }

    // 得到单链表的长度
    public int size() {
        int count = 0;
        // 判断空节点
        if (head == null) {
            System.out.println("空结点!");
            return 0;
        }

        ListNode cur = this.head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void clear(){
        if (head == null) {
            System.out.println("链表本来就是空的!");
            return;
        }

        // 不建议写的方式(简单粗暴)
//        this.head = null;

        while (this.head != null) {
            ListNode headNext = this.head.next;
            this.head.next = null;
            this.head = headNext;
        }
    }
}
