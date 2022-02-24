import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    private String suit;
    private int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "[" + suit + " " + rank + "]" ;
    }
}

public class PlayingCard {

    public static final String[] suits = {"红桃", "黑桃", "方片","梅花"};

    public static List<Card> buyCard() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                /*String suit = suits[i];
                int rank = j;
                Card card = new Card(suit, rank);
                cards.add(card);*/
                cards.add(new Card(suits[i], j));// 或者直接这样写
            }
        }
        return cards;
    }

    private static void swap(List<Card> cards, int i, int j) {
        /*注意：面向对象的时候，使用里面的方法！*/
        //Card tmp = cards[i];
        Card tmp = cards.get(i);
        //cards[i] = cards[j];
        cards.set(i, cards.get(j));
        //cards[j] = tmp;
        cards.set(j, tmp);
    }

    public static void shuffle(List<Card> cards) {
        int size = cards.size();
        for (int i = size - 1; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);// 生成后面的随机下标
            swap(cards, i, rand);
        }
    }

    public static void main(String[] args) {
        List<Card> cards = buyCard();
        System.out.println("买牌：" + cards);
        shuffle(cards);
        System.out.println("洗牌：" + cards);

        System.out.println("揭牌：每个人轮流，5张！");
        ArrayList<ArrayList<Card>> hand = new ArrayList<>();
        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand3 = new ArrayList<>();

        // 这里变成了一个二维数组
        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        // 每个人轮流揭牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                hand.get(j).add(card);
            }
        }

        System.out.println("hand1:" + hand1);
        System.out.println("hand2:" + hand2);
        System.out.println("hand3:" + hand3);
        System.out.println("剩下的牌:" + cards);
    }

    public static void main1(String[] args) {
        Card card = new Card("黑桃", 3);
        System.out.println(card);
    }

}
