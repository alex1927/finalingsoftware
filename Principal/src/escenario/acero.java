package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class acero {
    private final int ANCHO = 40;
    private final int ALTO = 40;
    private ImageIcon img;
    private int tipo, id;
    private int posX, posY;

    public acero(int id){
        tipo = 0;
        img = new ImageIcon("acero.gif");
        this.id = id;
    }

    public void acero( int id, int posX, int posY){
        this.id = id;
        this.posX = posX;
        this.posY = posY;
    }

    public void setId (int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getTipo(){return tipo;}

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
