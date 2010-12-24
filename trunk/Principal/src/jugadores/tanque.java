
package jugadores;
import java.awt.event.KeyEvent;

public class tanque implements limites{
    private final int ANCHO = 40;
    private final int ALTO = 40;
    private int vX,  vY,  velocidad;
    int posX;
    int posY;
    private String direccion;

    public tanque(){
        direccion = "norte";
        velocidad = 2;
        posX = 0;
        posY = 0;
    }

    public String getDireccion(){
        return direccion;
    }

    public int getAncho(){return ANCHO;}

    public int getAlto(){return ALTO;}
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setVelY(int vY){
        this.vY = vY;
    }

    public void setVelX(int vX){
        this.vX = vX;
    }

    public int getVelocidad(){
        return velocidad;
    }

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY( int posY){
        this.posY = posY;
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                setVelY(0);
                break;
            case KeyEvent.VK_LEFT:
                setVelX(0);
                break;
            case KeyEvent.VK_RIGHT:
                setVelX(0);
                break;
            case KeyEvent.VK_DOWN:
                setVelY(0);
                break;
        }

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if(!choqueLimiteNorte()){
                    setDireccion("norte");
                    setVelY(-getVelocidad());
                    setPosY(getPosY() - getVelocidad());
                }
                break;
            case KeyEvent.VK_LEFT:
                if(!choqueLimiteEste()){
                    setDireccion("este");
                    setVelX(-getVelocidad());
                    setPosX(getPosX() - getVelocidad());
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(!choqueLimiteOeste()){
                    setDireccion("oeste");
                    setVelX(getVelocidad());
                    setPosX(getPosX() + getVelocidad());
                }
                break;
            case KeyEvent.VK_DOWN:
                if(!choqueLimiteSur()){
                    setDireccion("sur");
                    setVelY(getVelocidad());
                    setPosY(getPosY() + getVelocidad());
                }
                break;        }
    }

    public boolean choqueLimiteNorte() {
        return this.getPosY() < NORTE;
    }

    public boolean choqueLimiteSur() {
        return this.getPosY() > SUR;
    }

    public boolean choqueLimiteEste() {
        return this.getPosX()< ESTE;
    }

    public boolean choqueLimiteOeste() {
        return this.getPosX() > OESTE;
    }
}
