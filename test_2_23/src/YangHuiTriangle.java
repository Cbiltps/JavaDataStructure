import java.util.ArrayList;
import java.util.List;

// 题目在LeetCode上面
// https://leetcode-cn.com/problems/pascals-triangle/

public class YangHuiTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        // 第一行
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        list.add(firstList);

        // 中间及后面
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);// 每一行的第一个是1
            List<Integer> preRows = list.get(i-1);// 上一行
            for (int j = 1; j < i; j++) { // 中间的情况
                int midNum = preRows.get(j-1) + preRows.get(j);
                tmp.add(midNum);
            }
            tmp.add(1);// 每一行的结尾都是1
            list.add(tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}



