
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ladrillo {
    private final int ANCHO = 20;
    private final int ALTO = 20;
    private int id, tipo;
    private ImageIcon img;
    private int posX, posY;

    public ladrillo(int id){
        this.id = id;
        tipo = 1;
        img = new ImageIcon("ladrillo.gif");
    }

    public void setId (int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getTipo(){return tipo;}

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

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }

}
