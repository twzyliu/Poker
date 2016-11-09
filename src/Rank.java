/**
 * Created by zyongliu on 09/11/16.
 */
public class Rank {

    private int rank;
    public static final int STEP = 0x100000;

    public Rank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static Rank NONERANK = new Rank(0);
    public static Rank FLUSH = new Rank(0x8 * STEP);
}
