package jugadores;

public class estado {
    private final int MUERTO = 0;
    private final int VIVO = 1;
    private int ESTADO;
    public estado(){
        ESTADO = VIVO;
    }
    public int getEstado(){
        return ESTADO;
    }
    public void setEstadoMuerto (){
        ESTADO = MUERTO;
    }
    public void setEstadoVivo (){
        ESTADO = VIVO;
    }
}
