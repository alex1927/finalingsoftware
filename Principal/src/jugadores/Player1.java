package jugadores;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Player1 extends Player {

    private final int posIniX = 285;
    private final int posIniY = 525;
    private String color;
    private ImageIcon img;

    public Player1() {
        color = "yellow";
        img = new ImageIcon("tanque" + Tanque.getDireccion() + ".gif");
        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
    }

    public String getColor() {
        return color;
    }

    public int getPosIniX() {
        return posIniX;
    }

    public int getPosIniY() {
        return posIniY;
    }

    public tanque getTanque() {
        return Tanque;
    }

    public void dibujar(Graphics g, int posX, int posY) {
        img = new ImageIcon("tanque" + Tanque.getDireccion() + ".gif");
        img.paintIcon(null, g, posX, posY);
        if (getDisparo()) {
            Tanque.dibujar(g);
        }
    }
}
