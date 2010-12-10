
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class aguila {
    private final int posX = 360;
    private final int posY = 520;
    private int tipo,id;
    private ImageIcon img;

    public aguila(){
        tipo = 4;
        img = new ImageIcon("aguila.gif");
    }

    public int getTipo(){return tipo;}

    public void dibujar(Graphics g){
        img.paintIcon(null, g, posX, posY);
    }
}
