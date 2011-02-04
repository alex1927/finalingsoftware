package jugadores;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Player1 extends Player {

    private final static int posIniX = 285;
    private final static int posIniY = 525;
    private boolean esperandoNacer;
    private int vidas;
    private long tiempoDeMuerte;
    private boolean hiloVivo;

    public Player1() {
        Tanque =new tanque(true);
        img = new ImageIcon("tanque" + Tanque.getDireccion() + ".gif");
        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
        esperandoNacer = false;
        hiloVivo = true;
        setVivo(true);
        vidas = 3;
    }

    public void PonerPosicionInicial(){
        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
        Tanque.setDireccion("Norte");
    }

    public void setHiloVivo(boolean hiloVivo) {
        this.hiloVivo = hiloVivo;
    }


    public long getTiempoDeMuerte() {
        return tiempoDeMuerte;
    }

    public int getVidas() {
        return vidas;
    }

    public void restarVidas(){
        vidas--;
    }

    public boolean isEsperandoNacer() {
        return esperandoNacer;
    }

    public void setEsperandoNacer(boolean esperandoNacer) {
        this.esperandoNacer = esperandoNacer;
        tiempoDeMuerte = System.currentTimeMillis();
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
        if(!esperandoNacer){
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
    }

    @Override
    public void run() {
        while (true) {
            while (esperandoNacer){
                System.out.println("No hace nada");
            }
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
