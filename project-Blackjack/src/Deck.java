import java.util.Arrays;

public class Deck {

    public static int LENGTH = 52;
    public static int TYPE_LENGTH = 13;
    private Card []cardArray;

    public Deck() {
    }

    ////////getter and setter//////////////////////////////
    public Card[] getCardArray() {
        return cardArray;
    }

    public void setCardArray(Card[] cardArray) {
        this.cardArray = cardArray;
    }



    ////////////functions//////////////////////////////////
    @Override
    public String toString() {
        return "Deck{" +
                "cardArray=" + Arrays.toString(cardArray) +
                '}';
    }
}
