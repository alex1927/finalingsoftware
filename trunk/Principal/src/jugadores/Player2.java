package jugadores;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Player2 extends Player {

    private final int posIniX = 445;
    private final int posIniY = 525;

    public Player2() {
        img = new ImageIcon("tanque2" + Tanque.getDireccion() + ".gif");
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
        img = new ImageIcon("tanque2" + Tanque.getDireccion() + ".gif");
        img.paintIcon(null, g, posX, posY);
        if (getDisparo()) {
            Tanque.dibujar(g);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                getTanque().setVelocidad(0);
                break;
            case KeyEvent.VK_A:
                getTanque().setVelocidad(0);
                break;
            case KeyEvent.VK_D:
                getTanque().setVelocidad(0);
                break;
            case KeyEvent.VK_S:
                getTanque().setVelocidad(0);
                break;
        }

    }

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                Tanque.setDireccion("norte");
                getTanque().setVelocidad(2);
                break;
            case KeyEvent.VK_A:
                Tanque.setDireccion("este");
                getTanque().setVelocidad(2);
                break;
            case KeyEvent.VK_D:
                Tanque.setDireccion("oeste");
                getTanque().setVelocidad(2);
                break;
            case KeyEvent.VK_S:
                Tanque.setDireccion("sur");
                getTanque().setVelocidad(2);
                break;
            case KeyEvent.VK_H:
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
