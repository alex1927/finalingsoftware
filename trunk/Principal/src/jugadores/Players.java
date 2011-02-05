package jugadores;
import escenario.Semaforo;
import escenario.colisiones;
import javax.swing.ImageIcon;

public class Players extends Thread {

    int id;
    protected tanque Tanque;
    private boolean noTocoAguila = true;
    private boolean DISPARO = false;
    protected ImageIcon img;
    protected colisiones monitor;
    private boolean vivo;
    private Semaforo excMutua;
    public Players(){
    }

    public Players(int id) {
        this.Players(id);
        
    }

    public void Players(int id){
        this.id=id;
    }


    public void Players(colisiones monitor) {
        excMutua = new Semaforo(1);
        this.monitor = monitor;
    }

    public int getsId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNoTocoAguila() {
        return noTocoAguila;
    }

    public void setNoTocoAguila(boolean noTocoAguila) {
        this.noTocoAguila = noTocoAguila;
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

    public void controlBala() {
        excMutua.Wait();
        if (getDisparo()) {
            if (monitor.hayColisionBalaConLadrillo(getsId())) {
                monitor.borrarLadrillo(getsId());
                endBala();
                setDisparo(false);
            }
            if (monitor.hayColisionBalaConAcero(getsId())) {
                monitor.borrarAcero(getsId());
                endBala();
                setDisparo(false);
            }
            if (monitor.hayColisionBalaConTanque(getsId())) {
                endBala();
                setDisparo(false);
            }
         
 
            if (monitor.hayColisionBalaConAguila(getsId())) {
                noTocoAguila = false;
                endBala();
                setDisparo(false);
            }
             if (monitor.hayColisionBalaConBala(getsId())) {
                endBala();
                setDisparo(false);
            }
    }
        excMutua.Signal();
    }

    public void endBala() {
        getTanque().getBala().stop();
    }

    public void limiteBala() {
        if (getDisparo()) {
            if (getTanque().getBala().getFlag()) {
                setDisparo(false);
                getTanque().getBala().setFlag(false);
            }
        }
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public void run() {
    }

    public void moverse(){
        if (getTanque().getDireccion().equals("norte")) {
            getTanque().setPosY(getTanque().getPosY() - getTanque().getVelocidad());
        }
        if (getTanque().getDireccion().equals("sur")) {
            getTanque().setPosY(getTanque().getPosY() + getTanque().getVelocidad());
        }
        if (getTanque().getDireccion().equals("oeste")) {
            getTanque().setPosX(getTanque().getPosX() + getTanque().getVelocidad());
        }
        if (getTanque().getDireccion().equals("este")) {
            getTanque().setPosX(getTanque().getPosX() - getTanque().getVelocidad());
        }
    }

    public void antiColisiones(){
        if (getTanque().getDireccion().equals("norte")) {
                    getTanque().setPosY(getTanque().getPosY() + 3);
                }
                if (getTanque().getDireccion().equals("sur")) {
                    getTanque().setPosY(getTanque().getPosY() - 3);
                }
                if (getTanque().getDireccion().equals("oeste")) {
                    getTanque().setPosX(getTanque().getPosX() - 3);
                }
                if (getTanque().getDireccion().equals("este")) {
                    getTanque().setPosX(getTanque().getPosX() + 3);
                }
    }

    public boolean mover(){
        return monitor.mover(getsId());
    }
}
