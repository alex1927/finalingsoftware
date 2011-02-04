package jugadores;
import escenario.colisiones;
import javax.swing.ImageIcon;

public class Players extends Thread {

    tanque Tanque;
    private boolean noTocoAguila = true;
    private boolean DISPARO = false;
    protected ImageIcon img;
    protected colisiones monitor;
    private boolean vivo;

    public Players() {
        Tanque = new tanque();
    }

    public void Players(colisiones monitor) {
        this.monitor = monitor;
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
        if (getDisparo()) {
            if (monitor.hayColisionConLadrillo(
                    getTanque().getBala().getPosX(),
                    getTanque().getBala().getPosY(),
                    getTanque().getBala().getAlto(),
                    getTanque().getBala().getAncho()
                    )) {
                monitor.borrarLadrillo(getTanque().getBala().getPosX(),
                        getTanque().getBala().getPosY(),
                        getTanque().getBala().getAlto(),
                        getTanque().getBala().getAncho());
                endBala();
                setDisparo(false);
            }

            if (monitor.hayColisionConAcero(getTanque().getBala().getPosX(),
                    getTanque().getBala().getPosY(),
                    getTanque().getBala().getAlto(),
                    getTanque().getBala().getAncho())) {
                monitor.borrarAcero(getTanque().getBala().getPosX(),
                        getTanque().getBala().getPosY(),
                        getTanque().getBala().getAlto(),
                        getTanque().getBala().getAncho());
                endBala();
                setDisparo(false);

            }

            if (monitor.hayColisionBalaTanque(getTanque().getBala().getPosX(),
                    getTanque().getBala().getPosY(),
                    getTanque().getBala().getAlto(),
                    getTanque().getBala().getAncho())) {
                endBala();
                setDisparo(false);

            }

            if (monitor.hayColisionConAguila(getTanque().getBala().getPosX(),
                    getTanque().getBala().getPosY(),
                    getTanque().getBala().getAlto(),
                    getTanque().getBala().getAncho())) {
                noTocoAguila = false;
                endBala();
                setDisparo(false);
            }
        }
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
}
