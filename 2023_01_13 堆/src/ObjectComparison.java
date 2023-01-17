import java.util.Comparator;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description: 对象比较
 * User: cbiltps
 * Date: 2023-01-17
 * Time: 16:09
 */

class Card implements Comparable<Card> {
    public int rank;// 数值
    public String suit;// 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    /**
     * 这个方法我们目前先不关心
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

/**
 * Rank比较器
 */
class RankComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.rank - o2.rank;
    }
}

public class ObjectComparison {

//    public static void main(String[] args) {
//        Card card1 = new Card(2, "♥");
//        Card card2 = new Card(1, "♥");
//
//        PriorityQueue<Card> priorityQueue = new PriorityQueue<>();
//        priorityQueue.offer(card1);//直接放到底层的queue数组的0下标
//        priorityQueue.offer(card2);
//        System.out.println(priorityQueue);
//
//        System.out.println(card1.compareTo(card2));
//
//        RankComparator rankComparator = new RankComparator();
//        int ret = rankComparator.compare(card1, card2);
//        System.out.println(ret);
//
//    }


//     public static void main(String[] args) {
//        Card card1 = new Card(2, "♥");
//        Card card2 = new Card(1, "♥");
//        RankComparator rankComparator = new RankComparator();
//        PriorityQueue<Card> priorityQueue = new PriorityQueue<>(rankComparator);// 传一个比较器
//        priorityQueue.offer(card1);//直接放到底层的queue数组的0下标
//        priorityQueue.offer(card2);
//        System.out.println(priorityQueue);
//    }


//    public static void main(String[] args) {
//        Card card1 = new Card(2, "♥");
//        Card card2 = new Card(1, "♥");
//
//        // 匿名内部类的方式
////        PriorityQueue<Card> priorityQueue = new PriorityQueue<>(new Comparator<Card>() {
////            @Override
////            public int compare(Card o1, Card o2) {
////                return o1.rank - o2.rank;
////            }
////        });
//
//        // Lambda表达式的方式
//        PriorityQueue<Card> priorityQueue = new PriorityQueue<>((x, y)->{return x.rank - y.rank;});
//
//        priorityQueue.offer(card1);//直接放到底层的queue数组的0下标
//        priorityQueue.offer(card2);
//        System.out.println(priorityQueue);
//    }


    public static void main(String[] args) {
        Card card1 = new Card(1, "♥");
        Card card2 = new Card(1, "♥");
        System.out.println(card1.equals(card2));
    }
}
