
package escenario;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;


public class panel extends JPanel implements Runnable{
    private final int ANCHO = 720;
    private final int ALTO = 560;
    escenario esc;
    public panel(){
        this.setBackground(Color.black);
        this.setSize(ANCHO, ALTO);
        this.setLocation(20, 20);
        esc = new escenario();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        esc.dibujarInicio(g);        
    }

    public void run() {
        while(true){
        esc.actualizoEscenario();
        esc.controlBala();
        esc.limiteBala();
        esc.On();
        repaint();        
        try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        esc.keyTyped(e);
    }

    public void keyPressed(KeyEvent e) {
        esc.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        esc.keyReleased(e);
    }
}
