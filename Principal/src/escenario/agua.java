
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class agua {
    private int id;
    private ImageIcon img;
    private int posX, posY;

    public agua(){
        id = 3;
        img = new ImageIcon("agua.gif");
    }

    public int getId(){return id;}

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }

}
