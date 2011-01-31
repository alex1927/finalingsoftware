package jugadores;

public class Players extends Thread {

    int tipo;
    tanque Tanque;
    estado status;
    private boolean DISPARO = false;

    public Players() {
        Tanque = new tanque();
        status = new estado();
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
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
