import java.util.Arrays;
import java.util.IllegalFormatFlagsException;
import java.util.Random;

import javax.swing.ImageIcon;

public class Cards {

    static ImageIcon cherry = new ImageIcon("cherry.jpg"); 
    static ImageIcon donuts = new ImageIcon("donuts.png"); 
    static ImageIcon heart = new ImageIcon("heart.png"); 
    static ImageIcon knight = new ImageIcon("knight.png"); 
    static ImageIcon pikachu = new ImageIcon("pikachu.png"); 
    static ImageIcon pizza = new ImageIcon("pizza.png"); 
    static ImageIcon skull = new ImageIcon("skull.jpg"); 
    static ImageIcon yinyang = new ImageIcon("yinyang.png"); 
    static ImageIcon yoshi = new ImageIcon("yoshi.png"); 
    static ImageIcon svamp = new ImageIcon("Svamp.jpg");
    
    static ImageIcon[] deck = {cherry, cherry, donuts, donuts, knight, knight, pikachu, pikachu, pizza, pizza, skull, skull, yoshi, yoshi, svamp, svamp};
    
    public static ImageIcon[] mixDeck() {
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            ImageIcon temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
        return deck;


    }
}
