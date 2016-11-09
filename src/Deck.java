import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Deck {

    public static final int NUMBER = 5;
    private List<Card> cardList = new ArrayList<>();
    private int[] points = new int[NUMBER];

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
        for (int i = 0; i < NUMBER; i++) {
            points[i] = cardList.get(i).getPoint();
        }
        Arrays.sort(points);
    }

    public int isStraight() {
        boolean isStraight = true;
        int i = 0;
        int flag = 1;
        if (points[0] == 1 & points[NUMBER - 1] == 13) {
            i += 1;
            flag += 1;
        }
        for (; i < NUMBER - flag; i++) {
            isStraight &= points[i] + 1 == points[i + 1];
        }
        if (isStraight) {
            return Rank.STRAIGHT.getRank();
        } else
            return Rank.NONERANK.getRank();
    }

    public int isFlush() {
        boolean isFlush = true;
        for (int i = 0; i < NUMBER - 1; i++) {
            isFlush &= (cardList.get(i).getColor().equals(cardList.get(i + 1).getColor()));
        }
        if (isFlush) {
            return Rank.FLUSH.getRank();
        } else {
            return Rank.NONERANK.getRank();
        }
    }
}
