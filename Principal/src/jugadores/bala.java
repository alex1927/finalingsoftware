package jugadores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class bala extends Thread implements limites {

    private final int ALTO = 6;
    private final int ANCHO = 6;
    private int posX;
    private int posY;
    private int velocidad;
    private String direccion;
    private boolean flag;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public bala(String direccion, int posX, int posY) {
        velocidad = 5;
        flag = false;
        this.direccion = direccion;
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getAncho() {
        return ANCHO;
    }

    public int getAlto() {
        return ALTO;
    }

    public void setVelBala(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelBala() {
        return velocidad;
    }

    public boolean choqueLimiteNorte() {
        return this.getPosY() < NORTE;
    }

    public boolean choqueLimiteSur() {
        return this.getPosY() + this.getAlto() > SUR;
    }

    public boolean choqueLimiteEste() {
        return this.getPosX() < ESTE;
    }

    public boolean choqueLimiteOeste() {
        return this.getPosX() + this.getAncho() > OESTE;
    }

    public void run() {
        if (getDireccion() == "norte") {
            while (!choqueLimiteNorte()) {
                System.out.println("Sale bala norte");
                this.setPosY(this.getPosY() - this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        if (getDireccion() == "sur") {
            while (!choqueLimiteSur()) {
                System.out.println("Sale bala sur");
                this.setPosY(this.getPosY() + this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        if (getDireccion() == "este") {
            while (!choqueLimiteEste()) {
                System.out.println("Sale bala este");
                this.setPosX(this.getPosX() - this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        if (getDireccion() == "oeste") {
            while (!choqueLimiteOeste()) {
                System.out.println("Sale bala oeste");
                this.setPosX(this.getPosX() + this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        System.out.println("murio bala" + this.getDireccion());
        Thread.currentThread().stop();

    }
}
