
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class aguila extends Elementos{
    private final int POSX = 360;
    private final int POSY = 520;
    private final static int ancho = 40;
    private final static int alto = 40;

    public aguila(){
        img = new ImageIcon("aguila.gif");
    }

    @Override
    public int getAncho(){
        return ancho;
    }

    @Override
    public int getAlto(){
        return alto;
    }
    public void dibujar(Graphics g){
        img.paintIcon(null, g, POSX, POSY);
    }

     public void cambiarDibujo(){
            img = new ImageIcon("aguila2.gif");
    }
}
