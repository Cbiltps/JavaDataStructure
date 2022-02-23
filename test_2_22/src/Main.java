public class Main {

    /**
     * 这里有一道面试题（阿里）
     * @param args
     */
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);

        Integer a2 = 123;
        Integer b2 = 123;
        System.out.println(a2 == b2);

        /*为什么会有上面的情况，看博哥的笔记和源码，写博客的时候写进去！*/
    }

    public static void main3(String[] args) {
        Integer a = 123;//装箱  装包【隐式的】
        int b = a;//拆箱  拆包【隐式的】
        System.out.println(a+" " + b);//这里写博客的时候去看博哥的笔记
        //https://gitee.com/gaobo1/java-102/blob/master/102-%E6%9D%BF%E4%B9%A6/11-26.png

        System.out.println("=============");

        Integer a2 = Integer.valueOf(123);//显示的装包
        Integer a3 = new Integer(123);//显示的装包

        int b2 = a2.intValue();//显示的拆包
        double d = a2.doubleValue();//显示的拆包

        int i = 10;//显示的初始化
    }

    public static void main2(String[] args) {
        String str = "123";
        int ret = Integer.valueOf(str);
        System.out.println(ret+1);
    }

    //这里是Object[]转换 上节课的补充
    public static void main1(String[] args) {
        String[] strings = new String[10];
        Object o1 = new String[10];
        Object[] o2 = new String[10];
        /*这里是有一个简书的博客，写的很好记得去回顾！*/
    }
}