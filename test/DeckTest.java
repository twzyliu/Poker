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
        List<Card> commonCardList = new ArrayList<Card>() {{
            add(new Card(1, Color.C));
            add(new Card(4, Color.D));
            add(new Card(8, Color.C));
            add(new Card(2, Color.H));
            add(new Card(7, Color.S));
        }};
        deck = new Deck(commonCardList);
    }

    @Test
    public void should_return_rank_when_deck_has_straight() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(1, Color.C));
            add(new Card(2, Color.D));
            add(new Card(3, Color.C));
            add(new Card(4, Color.H));
            add(new Card(5, Color.S));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasStraight(), is(Rank.STRAIGHT.getRank()));
    }

    @Test
    public void should_return_0_when_deck_hasnot_straight() throws Exception {
        assertThat(deck.hasStraight(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_10JQKA() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(10, Color.C));
            add(new Card(11, Color.D));
            add(new Card(12, Color.C));
            add(new Card(13, Color.H));
            add(new Card(1, Color.S));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasStraight(), is(Rank.STRAIGHT.getRank()));
    }

    @Test
    public void should_return_rank_when_deck_has_flush() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(2, Color.C));
            add(new Card(6, Color.C));
            add(new Card(4, Color.C));
            add(new Card(5, Color.C));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasFlush(), is(Rank.FLUSH.getRank()));
    }

    @Test
    public void should_return_0_when_desk_hasnot_flush() throws Exception {
        assertThat(deck.hasFlush(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_FourOfAKind() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(5, Color.H));
            add(new Card(4, Color.C));
            add(new Card(5, Color.D));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasFourOfAKind(), is(Rank.FOUROfAKIND.getRank()));
    }

    @Test
    public void should_return_0_when_desk_hasnot_FourOfAKind() throws Exception {
        assertThat(deck.hasFourOfAKind(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_ThreeOfAKind() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(9, Color.H));
            add(new Card(4, Color.C));
            add(new Card(5, Color.D));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasThreeOfAKind(), is(Rank.THREEOfAKIND.getRank()));
    }

    @Test
    public void should_return_0_when_desk_hasnot_ThreeOfAKind() throws Exception {
        assertThat(deck.hasThreeOfAKind(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_return_rank_when_desk_has_pair() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(9, Color.H));
            add(new Card(4, Color.C));
            add(new Card(8, Color.D));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasPair(), is(Rank.PAIR.getRank()));
    }

    @Test
    public void should_return_double_rank_when_desk_has_two_pairs() throws Exception {
        List<Card> cardList = new ArrayList<Card>() {{
            add(new Card(8, Color.C));
            add(new Card(8, Color.S));
            add(new Card(4, Color.H));
            add(new Card(4, Color.C));
            add(new Card(2, Color.D));
        }};
        Deck deck = new Deck(cardList);
        assertThat(deck.hasPair(), is(Rank.PAIR.getRank() * 2));
    }

    @Test
    public void should_return_0_when_desk_hasnot_pair() throws Exception {
        assertThat(deck.hasPair(), is(Rank.NONERANK.getRank()));
    }

    @Test
    public void should_get_same_typerank_when_two_desks_are_has_same_type() throws Exception {
        List<Card> cardList1 = new ArrayList<Card>() {{
            add(new Card(2, Color.C));
            add(new Card(2, Color.S));
            add(new Card(3, Color.H));
            add(new Card(3, Color.C));
            add(new Card(3, Color.D));
        }};
        List<Card> cardList2 = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(8, Color.H));
            add(new Card(8, Color.C));
            add(new Card(8, Color.D));
        }};
        Deck deck1 = new Deck(cardList1);
        Deck deck2 = new Deck(cardList2);
        assertThat(deck1.getSameTypeRank(), is(deck2.getSameTypeRank()));
    }

    @Test
    public void should_return_win_when_two_desks_are_has_different_type() throws Exception {
        List<Card> cardList1 = new ArrayList<Card>() {{
            add(new Card(1, Color.C));
            add(new Card(2, Color.S));
            add(new Card(3, Color.H));
            add(new Card(4, Color.C));
            add(new Card(5, Color.D));
        }};
        List<Card> cardList2 = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(2, Color.S));
            add(new Card(8, Color.H));
            add(new Card(2, Color.C));
            add(new Card(8, Color.D));
        }};
        Deck deck1 = new Deck(cardList1);
        Deck deck2 = new Deck(cardList2);
        assertThat(deck1.fight(deck2), is(deck1));
    }

    @Test
    public void should_return_win_when_two_desks_are_has_same_type() throws Exception {
        List<Card> cardList1 = new ArrayList<Card>() {{
            add(new Card(2, Color.C));
            add(new Card(2, Color.S));
            add(new Card(6, Color.H));
            add(new Card(6, Color.C));
            add(new Card(6, Color.D));
        }};
        List<Card> cardList2 = new ArrayList<Card>() {{
            add(new Card(5, Color.C));
            add(new Card(5, Color.S));
            add(new Card(4, Color.H));
            add(new Card(4, Color.C));
            add(new Card(4, Color.D));
        }};
        Deck deck1 = new Deck(cardList1);
        Deck deck2 = new Deck(cardList2);
        assertThat(deck1.fight(deck2), is(deck1));
    }

}
