package jugadores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class bala extends Thread implements limites {

    private final int ALTO = 8;
    private final int ANCHO = 8;
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

    @Override
    public void run() {
        if (getDireccion().equals("norte")) {
            while (!choqueLimiteNorte()) {
                this.setPosY(this.getPosY() - this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        if (getDireccion().equals("sur")) {
            while (!choqueLimiteSur()) {
                this.setPosY(this.getPosY() + this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        if (getDireccion().equals("este")) {
            while (!choqueLimiteEste()) {
                this.setPosX(this.getPosX() - this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        if (getDireccion().equals("oeste")) {
            while (!choqueLimiteOeste()) {
                this.setPosX(this.getPosX() + this.getVelBala());
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setFlag(true);
        }
        Thread.currentThread().stop();

    }
}
