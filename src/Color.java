/**
 * Created by zyongliu on 09/11/16.
 */
public class Color {
    private String color;

    public Color(String color) {
        this.color = color;
    }

    public static final Color S = new Color("Spades");
    public static final Color H = new Color("Hearts");
    public static final Color C = new Color("Clubs");
    public static final Color D = new Color("Diamonds");
}
