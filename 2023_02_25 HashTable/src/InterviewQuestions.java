/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-02-25
 * Time: 18:43
 */
public class InterviewQuestions {
    /**
     * 387. 字符串中的第一个唯一字符
     * https://leetcode.cn/problems/first-unique-character-in-a-string/
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }

        int[] array = new int[26];
        // for和foreach都可以用
        for (char ch : s.toCharArray()) {
            array[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
}
