
package jugadores;

public class bala extends tanque{
    int velocidad;
    String direccion;
    public bala(){
        velocidad = 1;
        direccion = super.getDireccion();
    }

    public void setVelocidad (int velocidad){
        this.velocidad = velocidad;
    }

    public int getVelocidad (){
        return velocidad;
    }
}
