package jugadores;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class enemigos extends Players {

    private int posX[];
    private static final int posY = 5;
    private int posIniX;
    private int posIniY;
    private IA ia;

    public enemigos(int ubicacion) {
        ia= new IA();
        posX = new int[3];
        posX[0] = 5;
        posX[1] = 365;
        posX[2] = 685;


        posIniX = posX[ubicacion];
        posIniY = posY;

        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
        Tanque.setDireccion("sur");

    }

    public void dibujar(Graphics g, int posX, int posY) {
        img = new ImageIcon("tanqueE" + Tanque.getDireccion() + ".gif");
        img.paintIcon(null, g, posX, posY);
        if (getDisparo()) {
            Tanque.dibujar(g);
        }

    }

    @Override
    public void run() {
        while (true) {

            if (monitor.mover(getTanque().getPosX(), getTanque().getPosY(), getTanque().getAlto(), getTanque().getAncho())
                    || !getTanque().choqueLimiteEste()|| !getTanque().choqueLimiteOeste()|| !getTanque().choqueLimiteNorte()
                    || !getTanque().choqueLimiteSur()) {
                //System.out.println("posX: "+ getTanque().getPosX());
                //System.out.println("posY: "+ getTanque().getPosY());
                if (getTanque().getDireccion().equals("norte")) {
                    getTanque().setPosY(getTanque().getPosY() - getTanque().getVelocidad());
                }
                if (getTanque().getDireccion().equals("sur")) {
                    getTanque().setPosY(getTanque().getPosY() + getTanque().getVelocidad());
                }
                if (getTanque().getDireccion().equals("este")) {
                    getTanque().setPosX(getTanque().getPosX() - getTanque().getVelocidad());
                }
                if (getTanque().getDireccion().equals("oeste")) {
                    getTanque().setPosX(getTanque().getPosX() + getTanque().getVelocidad());
                }
            } else {
                ia.direccion(getTanque().getDireccion());

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
