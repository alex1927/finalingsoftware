
package jugadores;

import java.awt.event.KeyEvent;

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

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
            case KeyEvent.VK_DOWN:
                break;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if(!Tanque.choqueLimiteNorte()){
                    Tanque.setDireccion("norte");
                    Tanque.setPosY(Tanque.getPosY() - Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_LEFT:
                if(!Tanque.choqueLimiteEste()){
                    Tanque.setDireccion("este");
                    Tanque.setPosX(Tanque.getPosX() - Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(!Tanque.choqueLimiteOeste()){
                    Tanque.setDireccion("oeste");
                    Tanque.setPosX(Tanque.getPosX() + Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_DOWN:
                if(!Tanque.choqueLimiteSur()){
                    Tanque.setDireccion("sur");
                    Tanque.setPosY(Tanque.getPosY() + Tanque.getVelocidad());
                }
                break;
            case KeyEvent.VK_SPACE:
                setDisparo(true);
                Tanque.disparar();
                break;
        }
    }
}
