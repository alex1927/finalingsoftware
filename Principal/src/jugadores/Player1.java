package jugadores;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Player1 extends Player {

    private final static int posIniX = 285;
    private final static int posIniY = 525;

    public Player1() {
        img = new ImageIcon("tanque" + Tanque.getDireccion() + ".gif");
        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
    }

    public int getPosIniX() {
        return posIniX;
    }

    public int getPosIniY() {
        return posIniY;
    }

    public void dibujar(Graphics g, int posX, int posY) {
        img = new ImageIcon("tanque"+ Tanque.getDireccion()+".gif");
        img.paintIcon(null, g, posX, posY);
        if (getDisparo()) {
            Tanque.dibujar(g);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    getTanque().setVelocidad(0);
                    break;
                case KeyEvent.VK_LEFT:
                    getTanque().setVelocidad(0);
                    break;
                case KeyEvent.VK_RIGHT:
                    getTanque().setVelocidad(0);
                    break;
                case KeyEvent.VK_DOWN:
                    getTanque().setVelocidad(0);
            }
    }

    public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    Tanque.setDireccion("norte");
                    getTanque().setVelocidad(2);
                    break;
                case KeyEvent.VK_LEFT:
                    Tanque.setDireccion("este");
                    getTanque().setVelocidad(2);
                    break;
                case KeyEvent.VK_RIGHT:
                    Tanque.setDireccion("oeste");
                    getTanque().setVelocidad(2);
                    break;
                case KeyEvent.VK_DOWN:
                    Tanque.setDireccion("sur");
                    getTanque().setVelocidad(2);
                    break;
                case KeyEvent.VK_SPACE:
                    if (!getDisparo()) {
                        setDisparo(true);
                        Tanque.disparar();
                    }
                    break;
            }
    }

    @Override
    public void run() {
        while (true) {
            if (monitor.mover(getTanque().getPosX(), getTanque().getPosY(), getTanque().getAlto(), getTanque().getAncho())
                    && !Tanque.choqueLimiteNorte() && !Tanque.choqueLimiteEste()
                    && !Tanque.choqueLimiteSur() && !Tanque.choqueLimiteOeste()) {                
                this.moverse();
            } else {                
                this.antiColisiones();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
