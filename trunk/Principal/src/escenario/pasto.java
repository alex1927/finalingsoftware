
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class pasto {
    private int id;
    private ImageIcon img;
    private int posX, posY;

    public pasto(){
        id = 2;
        img = new ImageIcon("pasto.gif");
    }

    public int getId(){
        return id;
    }

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }

}
