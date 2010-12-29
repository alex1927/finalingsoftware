
package jugadores;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Player2 extends Player{
    String color;
    private ImageIcon img;

    public Player2(){
        color = "green";
        img = new ImageIcon("tanque"+Tanque.getDireccion()+".gif");
    }
    
    public String getColor(){
        return color;
    }

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }
}
