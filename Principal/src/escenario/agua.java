
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class agua {
    private final int ANCHO = 20;
    private final int ALTO = 20;
    private int id;
    private ImageIcon img;
    private int posX, posY;

    public agua(){
        id = 3;
        img = new ImageIcon("agua.gif");
    }

    public int getId(){
        return id;
    }

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }

    public int getAncho(){return ANCHO;}

    public int getAlto(){return ALTO;}

    public void setPosX(int posX){
        this.posX = posX;
    }
    public int getPosX(){
        return posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }
    public int getPosY(){
        return posY;
    }

}
