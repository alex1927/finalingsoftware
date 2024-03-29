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
    private int tipo;
    private long controlDisparo;
    private long regularCambioDireccion;

    public enemigos(int id,int ubicacion){
        super.Players(id);
        Tanque =new tanque();
        tipo = ubicacion;
        controlDisparo = System.currentTimeMillis();
        posX = new int[3];
        posX[0] = 5;
        posX[1] = 365;
        posX[2] = 685;
        posIniX = posX[ubicacion];
        posIniY = posY;
        Tanque.setPosX(posIniX);
        Tanque.setPosY(posIniY);
        Tanque.setDireccion("sur");
        Tanque.setVelocidad(2);
        regularCambioDireccion = System.currentTimeMillis();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


    public void dibujar(Graphics g, int posX, int posY) {
        img = new ImageIcon("tanqueE" +getTipo()+ Tanque.getDireccion()+ ".gif");
        img.paintIcon(null, g, posX, posY);
        if (getDisparo()) {
            dibujar(g);
        }

    }

    @Override
    public void run() {
        while (true) {
            if (mover() && !getTanque().choqueLimiteEste() && !getTanque().choqueLimiteOeste() && !getTanque().choqueLimiteNorte()
                    && !getTanque().choqueLimiteSur()) {
                getTanque().setDireccion(cambiarDireccion(getTanque().getDireccion()));//AAAAAAAAAAAAA
                this.moverse();
            } else {
                this.antiColisiones();
                getTanque().setDireccion(IA(getTanque().getDireccion()));
            }

            if (!getDisparo() && controlDisparo + 3000 < System.currentTimeMillis()) {
                setDisparo(true);
                disparar();
                controlDisparo = System.currentTimeMillis();
            }
            setDisparo(bullet.isVivo());
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String IA(String direccion) {
        String dir = direccion;
        int aux;
        while (dir.equals(direccion)) {
            aux = (int) (Math.random() * 10 + 1);
            if (aux <= 4) {
                dir = "sur";
            }
            if (aux >= 5 && aux <= 6) {
                dir = "este";
            }
            if (aux >= 7 && aux <= 8) {
                dir = "oeste";
            }
            if (aux >= 9 && aux <= 10) {
                dir = "norte";
            }
        }
        return dir;
    }


    public String cambiarDireccion(String direccion) {
        int aux;
        String direcAux;
        if (regularCambioDireccion + 2000 < System.currentTimeMillis()) {
            aux = (int) (Math.random() * 100 + 1);
            if (aux < 2) {
                direcAux = this.IA(direccion);
                regularCambioDireccion = System.currentTimeMillis();
                return direcAux;
            }
        }
        return direccion;
    }


}
