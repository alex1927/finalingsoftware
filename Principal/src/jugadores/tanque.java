
package jugadores;

import java.io.Serializable;

public class tanque implements Serializable{
    private int ancho,  alto;
    private int posX,  posY,  posIniX,  posIniY,  vida;
    private int vX,  vY,  velocidad;
    private String direccion;

    public tanque(){

    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}
