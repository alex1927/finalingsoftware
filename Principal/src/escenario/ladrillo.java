
package escenario;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ladrillo {
    private int id, tipo;
    private ImageIcon img;
    private int posX, posY;

    public ladrillo(int id){
        this.id = id;
        tipo = 1;
        img = new ImageIcon("ladrillo.gif");
    }

    public int getId(){return id;}

    public int getTipo(){return tipo;}

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }

}
