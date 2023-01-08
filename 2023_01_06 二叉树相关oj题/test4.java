/**
KY11 二叉树遍历
https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&&tqId=29483&rp=1&ru=/activity/oj&qru=/ta/tsing-kaoyan/question-ranking

注意:
真正的创建一课二叉树, 之前创建的方法是 穷举法, 太low了
因为题目给的是前序遍历, 我们都知道"前序遍历"没法直接画图, 但是这个题给出了空格(就是一个空树), 这就可以画出一个唯一的树了
 */

import java.util.*;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int i = 0;
    public static TreeNode createTree(String str) {
        TreeNode newNode = null;
        if (str.charAt(i) != '#') {
            newNode = new TreeNode(str.charAt(i));
            i++;
            newNode.left = createTree(str);
            newNode.right = createTree(str);
        } else {
            // 遇见#, 就是空树
            i++;
        }
        return newNode;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            TreeNode root = createTree(str);
            inOrder(root);
        }
    }
}