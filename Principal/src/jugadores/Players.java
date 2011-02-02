package jugadores;

import escenario.colisiones;
import javax.swing.ImageIcon;

public class Players extends Thread {

    tanque Tanque;
    private boolean On = true;
    private boolean DISPARO = false;
    protected ImageIcon img;
    protected colisiones monitor;

    public Players() {
        Tanque = new tanque();
    }

    public void Players(colisiones monitor) {
        this.monitor = monitor;
    }

    public boolean getOn() {
        return On;
    }

    public void setOn(boolean On) {
        this.On = On;
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
            if (monitor.hayColisionConLadrillo(getTanque().getBala().getPosX(),
                    getTanque().getBala().getPosY(),
                    getTanque().getBala().getAlto(),
                    getTanque().getBala().getAncho())) {
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

            if (monitor.hayColisionConAguila(getTanque().getBala().getPosX(),
                    getTanque().getBala().getPosY(),
                    getTanque().getBala().getAlto(),
                    getTanque().getBala().getAncho())) {
                //romperAguila();
                On = false;
                endBala();
                setDisparo(false);
            }
        }
    }

    public void endBala() {
        System.out.println("murio bala" + getTanque().getBala().getDireccion());
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

    @Override
    public void run() {
    }
}
