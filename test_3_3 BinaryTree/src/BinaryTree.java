import java.util.*;

// 下面的创建方法不是常用的创建方式 比较简单 等到后期的时候 才会展示真正的创建方式
class TreeNode {
    public char val;
    public TreeNode left;// 左孩子的引用
    public TreeNode right;// 右孩子的引用

    public TreeNode(char val) { // 构造方法
        this.val = val;
    }
}

public class BinaryTree {
//    public TreeNode root;// 这个表示的是二叉树的根节点

    /*这一部分是 实现二叉树的操作！*/

    /**
     * 获取二叉树结点的个数 遍历思想实现
     */
    int count = 0;// 计数器
    int size(TreeNode root) {
        preOrderForSize(root);
        return count;
    }

    void preOrderForSize(TreeNode root) {
        if(root == null) {
            return;
        }else {
            count++;
        }
        preOrderForSize(root.left);
        preOrderForSize(root.right);
    }

    // 这样子实现也是可以的 当但是我觉的 我写的代码更具有观赏性
    /*int count = 0;
    int size1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        count++;
        size1(root.left);
        size1(root.right);
        return count;
    }*/

    /**
     * 获取二叉树结点的个数 子问题思想实现 我去居然这么的简单 真的时没想到
     * @return
     */
    int otherSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return otherSize(root.left) + otherSize(root.right) + 1;
    }

    /**
     * 获取叶子结点的个数
     *
     * 遍历思想实现
     *
     * @param root
     * @return
     */
    int LeafNodeCount = 0;// 如果下面的方法是void的时候，定义这个变量的时候可以是静态的，便于通过类名直接访问
    int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            LeafNodeCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return LeafNodeCount;
    }

    //子问题
    int otherGetLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return otherGetLeafNodeCount(root.left) + otherGetLeafNodeCount(root.right);
    }

    /**
     * 获取第K层的结点数
     *
     * 前面是先写完遍历的 现在直接写子问题的方法
     *
     * @param root
     * @return
     */
    int getKLevelNodeCount(TreeNode root, int layer) {
        if (root == null || layer <= 0) { // layer <= 0 的意思就是从第0层开始
            return 0;
        }
        if (layer == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, layer-1) + getKLevelNodeCount(root.right, layer-1);
    }

    /**
     * 获取二叉树的高度 子问题思路
     *
     * 注意:这个题在LeetCode上是有问题的，不能直接返回，会超出时间限制，主要是递归的次数太多
     * 解决方法就是先创建变量存储起来！
     *
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
     *
     * 时间复杂度：O(n)
     * 空间复杂度：log以 2 为底的 n
     *
     * @param root
     * @return
     */
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
//        return getHeight(root.left) > getHeight(root.right) ? getHeight(root.left)+1 : getHeight(root.right)+1;
    }

    /**
     * 检测值为value的元素是否存在
     * @param root
     * @param value
     * @return
     */
    TreeNode nodeFind(TreeNode root, char value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode ret = nodeFind(root.left, value);
        if (ret != null) {
            return ret;
        }

        ret = nodeFind(root.right, value);
        if (ret != null) {
            return ret;
        }
        return null;// 没有找到返回null
    }

    /**
     * 判断一个树是不是完全二叉树
     *
     * 这个方法使用非递归比较的好写：
     * 创建一个队列，判断结点不为空就把结点放进队列,之后弹出队列的元素，把这个元素的左右结点放进队队列，
     * 最后队列的元素都是空的时候就是完全二叉树，反之相反
     *
     * @param root
     * @return
     */
    boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 把第一个结点放进去
        while (queue.peek() != null) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }

//    public TreeNode createTree() { // 二叉树就是这样打印出来的
//        TreeNode A = new TreeNode('A');
//        TreeNode B = new TreeNode('B');
//        TreeNode C = new TreeNode('C');
//        TreeNode D = new TreeNode('D');
//        TreeNode E = new TreeNode('E');
//        TreeNode F = new TreeNode('F');
//        TreeNode G = new TreeNode('G');
//        TreeNode H = new TreeNode('H');
//        A.left = B;
//        A.right = C;
//        B.left = D;
//        B.right = E;
//        C.left = F;
//        C.right = G;
//        E.right = H;
//        return A;
//    }


    /**
     * 创建二叉树(非穷举方法)
     * @param str
     * @return
     */
    public int i = 0;

    public  TreeNode createTree(String str) {
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

    /**
     KY11 二叉树遍历
     https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&&tqId=29483&rp=1&ru=/activity/oj&qru=/ta/tsing-kaoyan/question-ranking

     注意:
     真正的创建一课二叉树, 之前创建的方法是 穷举法, 太low了
     因为题目给的是前序遍历, 我们都知道"前序遍历"没法直接画图, 但是这个题给出了空格(就是一个空树), 这就可以画出一个唯一的树了
     */
/*    import java.util.*;

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
    }*/

    /*注意：遍历的时候用的就是 递归的方法！*/
    // 前序遍历
    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }


    /*注意：使用非递归！*/
    // 前序遍历 非递归
    void preOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    // 中序遍历 非递归
    void inOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 后序遍历 非递归
    void postOrderNor(TreeNode root) {
        TreeNode cur = root;
        TreeNode printed = null;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            // 如果当前结点的右子树为 null 或者 遍历(打印) 过
            if (top.right == null || top.right == printed) {
                stack.pop();
                System.out.print(top.val + " ");
                printed = top;// 记录一下最近打印的结点
            } else {
                cur = top.right;
            }
        }
    }


    /**
     * 层序遍历
     * @param root
     */
    void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 把第一个结点放进去

        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 层序遍历(以数组形式展示)
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/submissions/
     * @param root
     * @return
     */
    public List<List<Character>> levelOrderOfArray(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 把第一个结点放进去

        TreeNode cur = null;
        int size = 0;
        while (!queue.isEmpty()) {
            List<Character> list = new ArrayList<>();

            size = queue.size();// 当前层有size个节点
            while (size != 0) {
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }


    /*但是，LeetCode上面是有返回值的：
     * 前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
     * 中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
     * 后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
     *
     * 然后说一下：博哥说的有返回值接收一下，我觉得没有必要，我不知道，哈哈哈哈哈，我菜！
     *
     * 代码看下面：List<Character> 是改过的，因为上面的代码时大写字母！*/

    public List<Character> preorderTraversal(TreeNode root) { // 前 这个是子问题思路
        List<Character> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        retlist.add(root.val);
        // 因为方法是有返回值的 还是接收一下
        List<Character> leftList = preorderTraversal(root.left);
        retlist.addAll(leftList);
        List<Character> rightList = preorderTraversal(root.right);
        retlist.addAll(rightList);
        return retlist;
    }

    List<Character> retlist = new ArrayList<>();// 中 这个是遍历思路
    public List<Character> inorderTraversal(TreeNode root) {
        if(root == null) {
            return retlist;
        }
        inorderTraversal(root.left);
        retlist.add(root.val);
        inorderTraversal(root.right);
        return retlist;
    }

    List<Character> retlist2 = new ArrayList<>();// 后 这个是遍历思路
    public List<Character> postorderTraversal(TreeNode root) {
        if(root == null) {
            return retlist2;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        retlist2.add(root.val);
        return retlist2;
    }
}
