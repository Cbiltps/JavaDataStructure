/**
 * Created with IntelliJ IDEA.
 * Description: 二叉搜索树的基本操作
 * 时间复杂度(插入和删除首先要查找, 查找效率代表了二叉搜索树各个操作的性能):
 *     O(logn)-完全搜索二叉树 ~ O(n)-只有左子树/右子树
 *     所以, 如果能够保持平衡, 平衡左右高度差是1(高度差差的不要太高, 尽量保持平衡),
 *     那就有了AVL树(高度平衡的二叉搜索树)!
 *     但是AVL树也不好的地方是要不停的旋转, 消耗资源太大!
 *     于是, 就有了和红黑树!
 * User: Cbiltps
 * Date: 2023-02-22
 * Time: 18:09
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class BSTree {
    public Node root = null;

    /**
     * 查找结点
     * @param key
     * @return
     */
    public Node search(int key) {
        Node cur = root;
        while (cur != null){
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }

        return null;
    }

    /**
     * 插入结点
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if(root == null) {
            root = new Node(key);
            return true;
        }

        Node parent = null;
        Node cur = root;
        while (cur != null){
            if (key < cur.val) {
                parent = cur;
                cur = cur.left;

            } else if (key > cur.val) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;// 搜索二叉树不能有相同数据
            }
        }

        Node newNode = new Node(key);
        if (key < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return true;
    }

    /**
     * 删除结点
     * @param key
     */
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                //这里开始删除
                removeNode(cur,parent);
                break;
            }else if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    /**
     * 删除结点的核心方法
     * @param cur
     * @param parent
     */
    public void removeNode(Node cur, Node parent) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = cur.right;// 替罪羊(真正删除的结点)
            // 上面为什么要找左树?
            // 因为删除的时候要替换一个结点,
            // 左树中找最大值, 右树中找最小值!

            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            // 直接和cur右树最小的数据交换
            cur.val = target.val;
            // 删除替罪羊结点
            if (targetParent.left == target) {
                targetParent.left = target.right;
            } else { // targe的左边为null
                targetParent.right = target.right;
            }
        }
    }

    public void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] array = {10, 8, 19, 3, 9, 4, 7};
        BSTree bSTree = new BSTree();
        for (int i = 0; i < array.length; i++) {
            bSTree.insert(array[i]);
        }
        bSTree.inOrder(bSTree.root);
        System.out.println(bSTree.insert(3));// 插入重复的数据

        bSTree.remove(7);// 删除结点
        bSTree.inOrder(bSTree.root);
    }
}