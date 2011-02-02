package jugadores;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Player1 extends Player {

    private final static int posIniX = 285;
    private final static int posIniY = 525;
    private boolean mover = false;

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

    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }

    public void dibujar(Graphics g, int posX, int posY) {
        img = new ImageIcon("tanque" + Tanque.getDireccion() + ".gif");
        img.paintIcon(null, g, posX, posY);
        if (getDisparo()) {
            Tanque.dibujar(g);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (isMover()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    break;
                case KeyEvent.VK_LEFT:
                    break;
                case KeyEvent.VK_RIGHT:
                    break;
                case KeyEvent.VK_DOWN:
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (isMover()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (!Tanque.choqueLimiteNorte()) {
                        Tanque.setDireccion("norte");
                        Tanque.setPosY(Tanque.getPosY() - Tanque.getVelocidad());
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (!Tanque.choqueLimiteEste()) {
                        Tanque.setDireccion("este");
                        Tanque.setPosX(Tanque.getPosX() - Tanque.getVelocidad());
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!Tanque.choqueLimiteOeste()) {
                        Tanque.setDireccion("oeste");
                        Tanque.setPosX(Tanque.getPosX() + Tanque.getVelocidad());
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (!Tanque.choqueLimiteSur()) {
                        Tanque.setDireccion("sur");
                        Tanque.setPosY(Tanque.getPosY() + Tanque.getVelocidad());
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (!getDisparo()) {
                        setDisparo(true);
                        Tanque.disparar();
                    }
                    break;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (monitor.mover(getTanque().getPosX(), getTanque().getPosY(), getTanque().getAlto(), getTanque().getAncho())) {
                this.setMover(true);
            } else {
                this.setMover(false);
                if (getTanque().getDireccion() == "norte") {
                    getTanque().setPosY(getTanque().getPosY() + 2);
                }
                if (getTanque().getDireccion() == "sur") {
                    getTanque().setPosY(getTanque().getPosY() - 2);
                }
                if (getTanque().getDireccion() == "oeste") {
                    getTanque().setPosX(getTanque().getPosX() - 2);
                }
                if (getTanque().getDireccion() == "este") {
                    getTanque().setPosX(getTanque().getPosX() + 2);
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
