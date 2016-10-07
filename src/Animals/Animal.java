package Animals;

import javafx.scene.image.ImageView;
import slogo_team16.Graphics;
public abstract class Animal {
    private int x;
    private int y;
    private ImageView image;
    private Graphics graphic = new Graphics();
    
    public Animal(int x, int y){
            this.x = x;
            this.y = y;
    }
    
    public ImageView getImage(){
            return image;
    }
    
    public int getX() {
            return x;
    }

    public int getY() {
            return y;
    }
    
    public void setX(int x) {
            this.x = x;
    }

    public void setY(int y) {
            this.y = y;
    }
    
    public abstract void update();

    

}