import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class DeckTest {

    @Test
    public void should_return_rank_when_deck_is_flush() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(1, Color.C));
            add(new Card(2, Color.D));
            add(new Card(3, Color.C));
            add(new Card(4, Color.H));
            add(new Card(5, Color.S));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isFlush(), is(Rank.FLUSH.getRank()));
    }

    @Test
    public void should_return_0_when_deck_isnot_flush() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(1, Color.C));
            add(new Card(4, Color.D));
            add(new Card(8, Color.C));
            add(new Card(2, Color.H));
            add(new Card(7, Color.S));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isFlush(), is(Rank.NONERANK.getRank()));
    }
}
