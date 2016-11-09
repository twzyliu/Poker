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
    private Rank rank;

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
        for (int index = 0; index < NUMBER; index++) {
            points[index] = cardList.get(index).getPoint();
        }
        Arrays.sort(points);
    }

    public int hasStraight() {
        boolean isStraight = true;
        int index = 0;
        int noNeedCompair = 0;
        if (points[0] == 1 & points[NUMBER - 1] == 13) {
            index += 1;
            noNeedCompair += 1;
        }
        for (; index < NUMBER - 1 - noNeedCompair; index++) {
            isStraight &= points[index] + 1 == points[index + 1];
        }
        if (isStraight) {
            return Rank.STRAIGHT.getRank();
        } else
            return Rank.NONERANK.getRank();
    }

    public int hasFlush() {
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

    public int hasFourOfAKind() {
        int count = 0;
        int keyPoint = points[(NUMBER - 1) / 2];
        for (int index = 0; index < NUMBER; index++) {
            if (points[index] == keyPoint) {
                count += 1;
            }
        }
        if (count == 4) {
            return Rank.FOUROfAKIND.getRank();
        } else {
            return Rank.NONERANK.getRank();
        }
    }

    public int hasThreeOfAKind() {
        int count = 0;
        int keyPoint = points[(NUMBER - 1) / 2];
        for (int index = 0; index < NUMBER; index++) {
            if (points[index] == keyPoint) {
                count += 1;
            }
        }
        if (count == 3) {
            return Rank.THREEOfAKIND.getRank();
        } else {
            return Rank.NONERANK.getRank();
        }
    }

    public int hasPair() {
        int rank = Rank.NONERANK.getRank();
        int count;
        int keyPoints[] = {points[1], points[3]};
        for (int keyPoint : keyPoints) {
            count = 0;
            for (int index = 0; index < NUMBER; index++) {
                if (points[index] == keyPoint) {
                    count += 1;
                }
            }
            if (count == 2) {
                rank += Rank.PAIR.getRank();
            }
        }
        return rank;
    }

    public int calculateTypeRank() {
        int rank = 0;
        int hasFourOfAKind = hasFourOfAKind();
        int hasFlush = hasFlush();
        int hasStraight = hasStraight();
        int hasThreeOfAKind = hasThreeOfAKind();
        int hasPair = hasPair();

        if (hasStraight > 0) {
            rank += hasStraight;
        }
        if (hasFlush > 0) {
            rank += hasFlush;
            return rank;
        }
        if (hasFourOfAKind > 0) {
            rank += hasFourOfAKind;
        }
        if (hasThreeOfAKind > 0) {
            rank += hasThreeOfAKind;
        }
        if (hasPair > 0) {
            rank += hasPair;
        }
        return rank;
    }
}
