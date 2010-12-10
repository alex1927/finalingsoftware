package escenario;




import java.awt.Graphics;
import javax.swing.ImageIcon;

public class acero {
    
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

    public int getTipo(){return tipo;}

    public void dibujar(Graphics g, int posX, int posY){
        img.paintIcon(null, g, posX, posY);
    }
}
