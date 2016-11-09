/**
 * Created by zyongliu on 09/11/16.
 */
public class Rank {
    private int rank;

    public Rank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static final int STEP = 0x100000;
    public static final Rank NONERANK = new Rank(0);
    public static final Rank PAIR = new Rank(0x3 * STEP);
    public static final Rank THREEOfAKIND = new Rank(0x7 * STEP);
    public static final Rank STRAIGHT = new Rank(0x8 * STEP);
    public static final Rank FLUSH = new Rank(0x9 * STEP);
    public static final Rank FOUROfAKIND = new Rank(0xb * STEP);
}
