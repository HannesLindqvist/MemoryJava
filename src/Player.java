import javax.swing.*;

public class Player {
    String name;
    int points;
    boolean active;

    public Player (String name) {
        // check if icons match
         this.name = name;
         this.points = 0;
         active = false;
    }

    public int getPoints(){
        return this.points;
    }

    public void addPoints(){
        this.points++;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}