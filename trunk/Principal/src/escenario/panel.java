
package escenario;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class panel extends JPanel implements KeyListener{
    escenario esc;

    public panel(){
        this.setBackground(Color.black);
        this.setSize(720, 560);
        this.setLocation(20, 20);
        esc = new escenario();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        esc.dibujar(g);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

}
