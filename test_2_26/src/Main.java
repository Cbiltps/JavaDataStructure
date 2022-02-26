
/*技巧：看源码的时候首先看继承关系！*/


import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //这里有两个练习题：
        //1：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
        //2：https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=265&tqId=39233&rp=1&ru=/ta/coding-interviews-all&qru=/ta/coding-interviews-all&difficulty=&judgeStatus=&tags=/question-ranking
    }

    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());//弹出栈顶元素，并且删除 4
        System.out.println(stack.peek());//获取栈顶元素，但是不删除 3
        System.out.println(stack.peek());//获取栈顶元素，但是不删除 3
        System.out.println(stack.empty());
        System.out.println("============");
        System.out.println(stack.isEmpty());// 此方法在继承关系中体现
    }
}
