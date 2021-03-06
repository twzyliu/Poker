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
    private int keyPoint[] = {0, 0, 0, 0, 0};

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
        for (int index = 0; index < NUMBER; index++) {
            points[index] = cardList.get(index).getPoint();
        }
        Arrays.sort(points);
    }

    public int hasStraight() {
        boolean isSpecal = points[0] == 1 & points[NUMBER - 1] == 13;
        boolean isStraight = true;
        int index = 0;
        int noNeedCompair = 0;
        if (isSpecal) {
            index += 1;
            noNeedCompair += 1;
        }
        for (; index < NUMBER - 1 - noNeedCompair; index++) {
            isStraight &= points[index] + 1 == points[index + 1];
        }
        if (isStraight) {
            if (isSpecal) {
                this.keyPoint[0] = points[1];
            } else {
                this.keyPoint[0] = points[0];
            }
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
            this.keyPoint[0] = keyPoint;
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
            this.keyPoint[0] = keyPoint;
            return Rank.THREEOfAKIND.getRank();
        } else {
            return Rank.NONERANK.getRank();
        }
    }

    public int hasPair() {
        int pairNum = 0;
        int rank = Rank.NONERANK.getRank();
        int count;
        int keyPoints[] = {points[3], points[1]};
        for (int keyPoint : keyPoints) {
            count = 0;
            for (int index = 0; index < NUMBER; index++) {
                if (points[index] == keyPoint) {
                    count += 1;
                }
            }
            if (count == 2) {
                this.keyPoint[pairNum] = keyPoint;
                pairNum += 1;
                rank += Rank.PAIR.getRank();
            }
        }
        for (int index = 0; index < NUMBER; index++) {
            if (points[index] != keyPoints[0] & points[index] != keyPoints[1]) {
                this.keyPoint[pairNum] = points[index];
            }
        }
        return rank;
    }

    public int getSameTypeRank() {
        int rank = 0;

        if (hasFlush() > 0) {
            rank += hasFlush();
            keyPoint = getReverseSort();
        }
        if (hasStraight() > 0) {
            rank += hasStraight();
            return rank;
        }
        if (hasFourOfAKind() > 0) {
            rank += hasFourOfAKind();
        }
        if (hasPair() > 0) {
            rank += hasPair();
        }
        if (hasThreeOfAKind() > 0) {
            rank += hasThreeOfAKind();
            if (keyPoint[0] == points[0]) {
                keyPoint[1] = points[NUMBER - 1];
            } else {
                keyPoint[1] = points[0];
            }
        }
        if (rank == 0) {
            keyPoint = getReverseSort();
        }
        return rank;
    }

    private int[] getReverseSort() {
        int[] reverse = new int[NUMBER];
        for (int index = 0; index < NUMBER; index++) {
            reverse[index] = points[NUMBER - 1 - index];
        }
        return reverse;
    }

    public Deck fight(Deck otherDesk) {
        int myRank = getSameTypeRank() + getDifferentTypeRang();
        int otherRank = otherDesk.getSameTypeRank() + otherDesk.getDifferentTypeRang();
        if (myRank > otherRank) {
            return this;
        }
        return otherDesk;
    }

    public int getDifferentTypeRang() {
        int rank = 0;
        for (int index = 0; index < NUMBER; index++) {
            rank += keyPoint[index] * (Math.pow(0x10, NUMBER - 1 - index));
        }
        return rank;
    }
}
