import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class DeckTest {
    private Deck deck;

    @Before
    public void setUp() throws Exception {
        List<Card> commonCardList = new ArrayList<Card>(){{
            add(new Card(1, Color.C));
            add(new Card(4, Color.D));
            add(new Card(8, Color.C));
            add(new Card(2, Color.H));
            add(new Card(7, Color.S));
        }};
        deck = new Deck(commonCardList);
    }

    @Test
    public void should_return_rank_when_deck_is_straight() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(1, Color.C));
            add(new Card(2, Color.D));
            add(new Card(3, Color.C));
            add(new Card(4, Color.H));
            add(new Card(5, Color.S));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isStraight(), is(Rank.STRAIGHT.getRank()));
    }

    @Test
    public void should_return_0_when_deck_hasnot_straight() throws Exception {
        assertThat(deck.isStraight(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_10JQKA() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(10, Color.C));
            add(new Card(11, Color.D));
            add(new Card(12, Color.C));
            add(new Card(13, Color.H));
            add(new Card(1, Color.S));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isStraight(), is(Rank.STRAIGHT.getRank()));
    }

    @Test
    public void should_return_rank_when_deck_has_flush() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(5, Color.C));
            add(new Card(2, Color.C));
            add(new Card(6, Color.C));
            add(new Card(4, Color.C));
            add(new Card(5, Color.C));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isFlush(), is(Rank.FLUSH.getRank()));
    }

    @Test
    public void should_return_0_when_desk_hasnot_flush() throws Exception {
        assertThat(deck.isFlush(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_FourOfAKind() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(5, Color.H));
            add(new Card(4, Color.C));
            add(new Card(5, Color.D));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isFourOfAKind(), is(Rank.FOUROfAKIND.getRank()));
    }

    @Test
    public void should_return_0_when_desk_hasnot_FourOfAKind() throws Exception {
        assertThat(deck.isFourOfAKind(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_ThreeOfAKind() throws Exception {
        List<Card> cardList = new ArrayList<Card>(){{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(9, Color.H));
            add(new Card(4, Color.C));
            add(new Card(5, Color.D));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.isThreeOfAKind(), is(Rank.THREEOfAKIND.getRank()));
    }

    @Test
    public void should_return_0_when_desk_hasnot_ThreeOfAKind() throws Exception {
        assertThat(deck.isThreeOfAKind(), is(Rank.NONERANK.getRank()));
    }
}
