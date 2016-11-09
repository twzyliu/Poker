/**
 * Created by zyongliu on 09/11/16.
 */
public class Color {
    private String color;

    public Color(String color) {
        this.color = color;
    }

    public static Color S = new Color("Spades");
    public static Color H = new Color("Hearts");
    public static Color C = new Color("Clubs");
    public static Color D = new Color("Diamonds");
}
