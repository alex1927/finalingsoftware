package jugadores;

import escenario.colisiones;
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
    private colisiones monitorBala;
    private int id;
    private boolean vivo;

    public bala(){
        vivo = false;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

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

    public bala(colisiones monitorBala, int id) {
        this.bala(monitorBala, id);
    }

    public void bala(colisiones monitorBala, int id) {
        this.monitorBala = monitorBala;
        this.id=id;
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

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
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

     public void moverse(){
        if (getDireccion().equals("norte")) {
            setPosY(getPosY() - getVelocidad());
        }
        if (getDireccion().equals("sur")) {
            setPosY(getPosY() + getVelocidad());
        }
        if (getDireccion().equals("oeste")) {
            setPosX(getPosX() + getVelocidad());
        }
        if (getDireccion().equals("este")) {
            setPosX(getPosX() - getVelocidad());
        }
    }

    public boolean moverBala( int id){
        return monitorBala.moverBala(id);
    }

    @Override
    public void run() {
                while (true) {
            if (moverBala(id) && !choqueLimiteEste() && !choqueLimiteOeste() && !choqueLimiteNorte()
                    && !choqueLimiteSur()) {
                this.moverse();
            } else {
                this.setVivo(false);
                stop();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
}
