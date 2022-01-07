import javax.swing.*;

public class Player {
    String name;
    int points;
    boolean active;

    public Player (Boolean startAsActive) {
        this.name = name; 
        this.points = 0;
        active = startAsActive;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
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