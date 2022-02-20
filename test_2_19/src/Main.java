import java.util.*;

public class Main {


    /*今天学的是 集合框架 及其 背后的数据结构，这句话非常有意思！
    * 集合框架就是Java已经写好的一些数据结构，
    * 我们学习数据结构就是探究是如何实现的！
    *
    *写博客或者是复习的时候多看看博哥的上课笔记！
    * */

    /**
     * TreeMap和HashMap的差异比较
     * TreeMap多了个排序，建议按住CTRL点进去看看是如何实现的
     * @param args
     */
    public static void main(String[] args) {
        TreeMap<String,String> map2 = new TreeMap<>();
        map2.put("及时雨","宋江");
        map2.put("国民女神","高圆圆");
        System.out.println(map2);

        HashMap<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("国民女神","高圆圆");
        System.out.println(map);
    }

    public static void main5(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("国民女神","高圆圆");
        System.out.println(map);
        System.out.println("====================");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();// Map.Entry<String, String>是一个类型 比较奇怪
        for( Map.Entry<String, String> entry : entrySet) {
            System.out.println("key: "+entry.getKey()+" value:"+entry.getValue());
        }
    }

    public static void main4(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("国民女神","高圆圆");
        map.put("及时雨","宋江");

        String ret = map.getOrDefault("及时雨","博哥");// 根据指定的 k 查找对应的 v，没有找到用默认值代替
        System.out.println(ret);

        boolean flg = map.containsKey("国民女神2");// 判断是否包含key
        System.out.println(flg);
    }


    public static void main3(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("hello2");
        Object[] objects = collection.toArray();// 把集合中的元素变成数组。返回的是Object[]所以就用它接收，可以按住CTRL点进去看
//        String[] string = (String[])collection.toArray();// 这里不能这样写，编译的时候是通过的，但是会报异
//        而且这个涉及到JVM对数组的处理，如果要深究的话就要考古JVM了，关于这部分知识写博客的时候去看博哥当时的笔记和我的博客素材
        System.out.println(Arrays.toString(objects)); // 用字符串的方式打印数组
    }


    public static void main2(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("hello2");
        System.out.println(collection);// 打印集合中的元素
        collection.clear();// 清除集合中的元素
        System.out.println("===================");
        System.out.println(collection);
        System.out.println(collection.isEmpty());// 判断是否是空集合
    }

    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();// 这里的 <>（尖括号） 涵盖泛型的知识，看下面的补充
        collection.add("hello");
        collection.add("hello2");
        //collection.add(1);// 如果没有<>(尖括号),add方法什么都可以添加

        //尖括号当中 放的类型 一定要是 类类型 不能是简单的基本类型
        Collection<Integer> collection2 = new ArrayList<>();
        collection2.add(1);
        collection2.add(2);
        collection2.add(13);

        /*补充：
        * 1：在这里的<>中写String的意思就是：后面add方法添加的时候，只能添加字符串！
        * 2：但是要添加数字的时候，<> 里面不能写int，要写Integer：尖括号当中 放的类型 一定要是 类类型 不能是简单的基本类型*/

    }
}
