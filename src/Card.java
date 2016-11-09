/**
 * Created by zyongliu on 09/11/16.
 */
public class Card {
    public int getPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }

    private int point;
    private Color color;

    public Card(int point, Color color) {
        this.point = point;
        this.color = color;
    }
}
