/**
 * Created with IntelliJ IDEA.
 * Description:
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

public class TestDemo {
    public Node root = null;

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
}
