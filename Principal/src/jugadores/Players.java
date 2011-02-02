package jugadores;
import escenario.colisiones;
import javax.swing.ImageIcon;

public class Players extends Thread {

    tanque Tanque;
    private boolean DISPARO = false;
    protected ImageIcon img;
    private colisiones monitor;
    public Players() {
        Tanque = new tanque();
    }

    public void Players(colisiones monitor){
        this.monitor = monitor;
    }

    public tanque getTanque() {
        return Tanque;
    }
    
    public void setDisparo(boolean disparo) {
        this.DISPARO = disparo;
    }

    public boolean getDisparo() {
        return DISPARO;
    }

    @Override
    public void run() {
    
    }
}
