import java.util.Arrays;
import java.util.IllegalFormatFlagsException;
import java.util.Random;

import javax.swing.ImageIcon;

public class Cards {

    private ImageIcon cherry = new ImageIcon("cherry.jpg"); 
    private ImageIcon donuts = new ImageIcon("donuts.png"); 
    private ImageIcon heart = new ImageIcon("heart.png"); 
    private ImageIcon knight = new ImageIcon("knight.png"); 
    private ImageIcon pikachu = new ImageIcon("pikachu.png"); 
    private ImageIcon pizza = new ImageIcon("pizza.png"); 
    private ImageIcon skull = new ImageIcon("skull.jpg"); 
    private ImageIcon yinyang = new ImageIcon("yinyang.png"); 
    private ImageIcon yoshi = new ImageIcon("yoshi.png"); 
    private ImageIcon svamp = new ImageIcon("Svamp.jpg");
    
    private ImageIcon[] deck = {cherry, cherry, donuts, donuts, knight, knight, pikachu, pikachu, pizza, pizza, skull, skull, yoshi, yoshi, svamp, svamp};
    
    public ImageIcon[] mixDeck() {
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
