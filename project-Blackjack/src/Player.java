public class Player {

    private String name;
    private int coins;
    private Card []cardArray;

    public Player(String name, int coins, Card[] cardArray) {
        this.name = name;
        this.coins = coins;
        this.cardArray = cardArray;

    }

    public Card[] getCardArray() {
        return cardArray;
    }

    public void setCardArray(Card[] cardArray) {
        this.cardArray = cardArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", coins=" + coins +
                '}';
    }
}
