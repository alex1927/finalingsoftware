
package jugadores;

public class Player extends Players{
    String nombre;
    int vida;

    public Player(){
        nombre = "Nombre Jugador";
        vida = 3;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    public void setVida( int vida ){
        this.vida = vida;
    }
    public int getVida(){
        return vida;
    }
}
