import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class Main {

    /**
     * 这个是一道面试题：CVTE的面试题
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) { // 包含方法
                list.add(ch);
            }
        }
        for (char ch : list) {
            System.out.print(ch);
        }
    }

    public static void main3(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        //Collections.sort(integers);// 集合排序
        Collections.reverse(integers);// 集合逆序
        System.out.println(integers);
    }

    public static void main2(String[] args) {
        /*ArrayList底层其实是一个动态扩容的数组！*/
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("bit", "102-1", 98.9));
        students.add(new Student("gaobo", "102-2", 18.9));
        students.add(new Student("zhiqiang", "102-1", 88.9));
        System.out.println(students);// 遍历ArrayList
    }

    public static void main1(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        /*上面两个构造的区别就是：list1的方法比list2的方法多！*/

        list1.add("abc");
        System.out.println(list1);

        ArrayList<String> list2 = new ArrayList<>(34);
    }
}