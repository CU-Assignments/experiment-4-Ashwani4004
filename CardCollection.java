import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class CardCollection {
    private static Map<String, List<Card>> cardCollection = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add a Card");
            System.out.println("2. Display All Cards");
            System.out.println("3. Find Cards by Symbol");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    displayAllCards();
                    break;
                case 3:
                    findCardsBySymbol();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    
    private static void addCard() {
        System.out.print("Enter Card Symbol (e.g., Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine().trim();

        System.out.print("Enter Card Value (e.g., Ace, King, Queen, 10, 9): ");
        String value = scanner.nextLine().trim();

        Card newCard = new Card(symbol, value);

        
        cardCollection.computeIfAbsent(symbol, k -> new ArrayList<>()).add(newCard);
        System.out.println("Card added successfully!");
    }

    
    private static void displayAllCards() {
        if (cardCollection.isEmpty()) {
            System.out.println("No cards in the collection.");
            return;
        }

        System.out.println("\nAll Cards in Collection:");
        for (Map.Entry<String, List<Card>> entry : cardCollection.entrySet()) {
            System.out.println("Symbol: " + entry.getKey());
            for (Card card : entry.getValue()) {
                System.out.println("  - " + card);
            }
        }
    }

    
    private static void findCardsBySymbol() {
        System.out.print("Enter Symbol to search (e.g., Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine().trim();

        List<Card> cards = cardCollection.get(symbol);
        if (cards == null || cards.isEmpty()) {
            System.out.println("No cards found for symbol: " + symbol);
        } else {
            System.out.println("Cards in " + symbol + ":");
            for (Card card : cards) {
                System.out.println("  - " + card);
            }
        }
    }
}
