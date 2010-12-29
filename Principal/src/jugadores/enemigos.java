
package jugadores;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class enemigos extends Players{
    String color;
    private ImageIcon img;
    public enemigos(){
        color = "blue";
        Tanque.setDireccion("sur");
        img = new ImageIcon("tanque"+Tanque.getDireccion()+".gif");
    }

    public String getColor(){
        return color;
    }

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }
}
