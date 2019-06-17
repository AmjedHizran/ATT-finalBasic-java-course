import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int DEFAULT_COINS = 1000;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.setCardArray(new Card[Deck.LENGTH]);
        Card[] cardsToShuffle = InitializeTypes();
        Card[] cardsReady = shuffleCards(cardsToShuffle);
        initGame(cardsReady);
        System.out.println("result" + Arrays.toString(cardsReady) + "length = " + cardsReady.length);
    }

    public static void initGame(Card[] cardsReady){
        System.out.println("*************************Welcome To Blackjack Game*************************** ");
        System.out.println("At any moment – typing ‘q’ will quit the game. ");
        Card[] playerCards = new Card[30];
        Card[] computerCards = new Card[30];
        Player player = new Player("player",DEFAULT_COINS,playerCards);
        Player computer = new Player("computer",DEFAULT_COINS,computerCards);
        do {
            System.out.println("please enter name consisting of letters and characters : ");
            String playerName = scanner.nextLine();
            if (!playerName.equals("Q") && !playerName.equals("q")){
                if(playerName.isEmpty()){
                    continue;
                }
                player.setName(playerName);
                setBet(cardsReady,playerName,player,computer);
            }
            break;
        }while (player.getCoins() > 0 && computer.getCoins() > 0);

    }

    public static void setBet(Card[] cardsReady, String playerName,Player player,Player computer){
        int round = 0;
        boolean validBetInput;
        do {
            System.out.println("Please Enter A Bit Between 1 , 5, 10 , 50 , 100 Coins. ");
            String bet = scanner.nextLine();
            validBetInput = bet.equals("1") || bet.equals("5") || bet.equals("10") || bet.equals("50") || bet.equals("100") ? true : false;
            if (bet.equals("Q") || bet.equals("q")) {
                break;
            }
            if (!validBetInput) {
                continue;
            }
            startGame(player,cardsReady,computer);
        }while(playerName.equals("Q")  || playerName.equals("q") || player.getCoins() <= 0 || validBetInput == false);
    }


    public static void startGame(Player player,Card[] cardsReady,Player computer){
        Card[] user = dealsCardsToUser(player,cardsReady,2);
        //Card[]  = dealsCardsToUser(player,cardsReady,2);
        System.out.println("user cards :" + user[0]);
        Card[] dealer = dealsCardsToUser(computer,cardsReady);
        String drawOrStand;
        do{
            System.out.println("Please press 'd' to Draw – get another card from the dealer. ");
            System.out.println("or press 's' Stand – do not get any more cards. At this point the dealer will play. ");
            drawOrStand = scanner.nextLine();
            switch (drawOrStand){
                case "D":
                    user = dealsCardsToUser(player, cardsReady,1);
                case "d":
                    user = dealsCardsToUser(player, cardsReady,1);
                case "S":
                    dealer = dealsCardsToUser(player, cardsReady,1);
                case "s":
                    dealer = dealsCardsToUser(player, cardsReady,1);
                case "q":
                    break;
                default:
                    System.out.println("Please press 'd' or 's' to continue game. ");
            }
        }while(drawOrStand != "D" || drawOrStand != "d"|| drawOrStand != "S" || drawOrStand != "s" || drawOrStand != "Q" || drawOrStand != "q");
    }


    public static Card[] dealsCardsToUser(Player player, Card[] cardsReady) {
        return dealsCardsToUser(player,cardsReady,2);
    }

    public static Card[] dealsCardsToUser(Player player,Card[] cardsReady,int numOfCards) {
        Card[] card = new Card[0] ;
        if(numOfCards == 2){
            card = new Card[numOfCards + 1];
        }
        for (int i = 0 ; i < numOfCards ; i++) {
            Card value = cardsReady[getRandomDoubleBetweenRange(0,cardsReady.length - 1)];
            card[i] = new Card(value.getType(),value.getValue());

        }
        player.setCardArray(card);
        return card;
    }

    public static int getRandomDoubleBetweenRange(int min, int max){
        int index = (int) ((Math.random()*((max-min)+1))+min);
        return index;
    }

    public static Card[] InitializeTypes() {
        Card[] heartType = InitializeCards("Hearts");
        Card[] Spade = InitializeCards("Spades");
        Card[] Diamond = InitializeCards("Diamonds");
        Card[] Club = InitializeCards("Clubs");

        Card[] heartType_Spade = merge(heartType,Spade);
        Card[] Diamond_Club = merge(Diamond,Club);

        Card[] result = merge(heartType_Spade,Diamond_Club);
        return result;
//        System.out.println("result" + Arrays.toString(result) + "length = " + result.length);
    }

    public static Card[]merge(Card[]a, Card[]b){
        Card[]c = new Card[a.length+b.length];
        int i;
        for(i=0; i<a.length; i++)
            c[i] = a[i];

        for(int j=0; j<b.length; j++)
            c[i++]=b[j];
        return c;
    }

    private static Card[] InitializeCards(String type){
        Card[] cardTypes = new Card[Deck.TYPE_LENGTH];
        for (int i = 0,value = 2; i < Deck.TYPE_LENGTH ; i++,value++) {
            if (value > 10){
                value = 10;
                if(i == Deck.TYPE_LENGTH - 1){
                    value = 11;
                }
            }
            cardTypes[i] = new Card(type,value);
        }
        return cardTypes;
    }

    static Card[] shuffleCards(Card[] arrCard){
        Random rnd = new Random();
        for (int i = arrCard.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            Card card = arrCard[index];
            arrCard[index] = arrCard[i];
            arrCard[i] = card;
        }
        return arrCard;
    }


}
