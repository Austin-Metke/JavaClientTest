import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Connect to localhost on port 5000
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server");

        // Set up input stream to receive the object
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        // Deserialize the object
        // In this case we know what kind of object we're receiving so we cast it
        Card receivedObject = (Card) inputStream.readObject();
        System.out.println("Received object: " + receivedObject);


        // Close the socket and streams
        inputStream.close();
        socket.close();
    }
}


class Card implements Serializable {

    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }


    public int getRank() {
        return rank;
    }


    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public String toString() {
        return "SUIT: " + this.suit + "\nRANK: " + this.rank;
    }
}

