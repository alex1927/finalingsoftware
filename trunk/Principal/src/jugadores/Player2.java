
package jugadores;
import escenario.colisiones;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player2 extends Player{
    private final int posIniX = 445;
    private final int posIniY = 525;

    public Player2(){
        img = new ImageIcon("tanque2"+Tanque.getDireccion()+".gif");
        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
    }

    public void Player2(colisiones monitor){
        super.Player(monitor);
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
                break;
            case KeyEvent.VK_A:
                break;
            case KeyEvent.VK_D:
                break;
            case KeyEvent.VK_S:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (!Tanque.choqueLimiteNorte()) {
                    Tanque.setDireccion("norte");
                    Tanque.setPosY(Tanque.getPosY() - Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_A:
                if (!Tanque.choqueLimiteEste()) {
                    Tanque.setDireccion("este");
                    Tanque.setPosX(Tanque.getPosX() - Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_D:
                if (!Tanque.choqueLimiteOeste()) {
                    Tanque.setDireccion("oeste");
                    Tanque.setPosX(Tanque.getPosX() + Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_S:
                if (!Tanque.choqueLimiteSur()) {
                    Tanque.setDireccion("sur");
                    Tanque.setPosY(Tanque.getPosY() + Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_H:
                if (!getDisparo()) {
                    setDisparo(true);
                    Tanque.disparar();
                }
                break;
        }
    }
}
