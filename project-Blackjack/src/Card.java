public class Card {

    private int value;
    private String type;

    public Card(String type, int value) {
        this.type = type;
        this.value = value;
    }

    //////////getter and setter///////
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
            this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
