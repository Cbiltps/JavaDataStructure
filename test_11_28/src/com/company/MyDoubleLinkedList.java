package com.company;

/**
 * 无头双向链表实现
 */

class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyDoubleLinkedList {

    public ListNode head;// 指向双向链表的头节点
    public ListNode last;// 指向的是尾巴节点

    public void display() {
        // 和单链表的打印方式是一样的
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 得到单链表的长度
    public int size() {
        int count = 0;//计数器
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if (key == cur.val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 头插法
    public void addFirst(int data) {
        ListNode addNode = new ListNode(data);
        if (this.head == null) {
            this.head = addNode;
            this.last = addNode;
        }else {
            addNode.next = this.head;
            this.head.prev = addNode;
            this.head = addNode;
        }
    }

    // 尾插法
    public void addLast(int data){
        ListNode addNode = new ListNode(data);
        if (this.head == null) {
            this.head = addNode;
            this.last = addNode;
        }else {
            this.last.next = addNode;
            addNode.prev = this.last;
            this.last = addNode;
        }

    }

    // 寻找下标位置的结点
    public ListNode searchIndex(int index) {
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    // 判断结点是否合法
    public boolean isIndex(int index) {
        if (index < 0 || index > size()) {
            System.out.println("位置不合法！");
            return false;
        }else {
            return true;
        }
    }

    // 任意位置插入(第一个数据节点为0号下标)
    public void addIndex(int index,int data) {
        ListNode addNode = new ListNode(data);
        if (!isIndex(index)) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        }else if(index == size()) {
            addLast(data);
        }else {
            ListNode cur = searchIndex(index);
            addNode.next = cur;
            cur.prev.next = addNode;
            addNode.prev = cur.prev;
            cur.prev = addNode;
        }
    }

    // 删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;

//        while (cur != null) {
//            if (cur.val == key) {
//                if (cur == head) { //删除的结点是头结点
//                    this.head = head.next;
//                    this.head.prev = null;
//                    break;
//                }else if(cur == last){ //删除的结点是尾巴结点
//                    cur.prev.next = cur.next;
//                    last = last.prev;
//                    break;
//                }else { //删除的是中间的结点
//                    cur.prev.next = cur.next;
//                    cur.next.prev = cur.prev;
//                    break;
//                }
//            }else {
//                cur = cur.next;
//            }
//        }

        // 看看更高级的代码！
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) { // 删除头结点
                    this.head = head.next;
                    if (head != null) { // 当只有一个节点的时候，head为空，会报错
                        this.head.prev = null;
                    }else {
                        this.last = null;// 这样就相当于删了
                    }
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;// 删除中间
                    }else {
                        this.last = last.prev;// 删除尾巴
                    }
                }
                return;
            }
            cur = cur.next;
        }

    }

    // 删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) { // 删除头结点
                    this.head = head.next;
                    if (head != null) { // 当只有一个节点的时候，head为空，会报错
                        this.head.prev = null;
                    }else {
                        this.last = null; // 这样就相当于删了
                    }
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev; // 删除中间
                    }else {
                        this.last = last.prev; // 删除尾巴
                    }
                }
            }
            cur = cur.next;
        }
    }


    public void clear() {
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode curNext = head.next;
//            if(cur.next != null) {
//                cur.next = null;
//            }
//            if(cur.prev != null) {
//                cur.prev = null;
//            }
//            cur = cur.next;
//        }
//        head = null;
//        last = null;
//        System.out.println("null");

        // 上面是自己写的, 看看下面的
        while (head != null) {
            ListNode headNext = head.next;
            head.next = null;
            head.prev = null;
            head = headNext;
        }
        last = null;
        System.out.println("All Null!");
    }
}

// 注意；检测为空 可以用一个前面讲过的命令 jps jmap -histo:live xxxx > c:\\ xxx.txt
// 看看ListNode的实例个数是不是少了！