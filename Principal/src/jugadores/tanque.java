
package jugadores;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class tanque implements limites{
    private final int ANCHO = 30;
    private final int ALTO = 30;
    private int velocidad;
    private int posX;
    private int posY;
    private String direccion;
    private bala bullet;
    private ImageIcon img;

    public tanque(){
        direccion = "norte";
        velocidad = 2;
        posX = 0;
        posY = 0;
        img = new ImageIcon("bala.gif");
       
    }

    public String getDireccion(){
        return direccion;
    }

    public int getAncho(){return ANCHO;}

    public int getAlto(){return ALTO;}
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void dibujar(Graphics g){
        //bullet.dibujar(g);
        img = new ImageIcon("bala.gif");
        img.paintIcon(null, g, bullet.getPosX()+bullet.getVelBala(), bullet.getPosY()+bullet.getVelBala());
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

    public boolean choqueLimiteNorte() {
        return this.getPosY() < NORTE;
    }

    public boolean choqueLimiteSur() {
        return this.getPosY()+this.getAncho() > SUR;
    }

    public boolean choqueLimiteEste() {
        return this.getPosX() < ESTE;
    }

    public boolean choqueLimiteOeste() {
        return this.getPosX()+this.getAlto() > OESTE;
    }

    public void disparar(){
        bullet = new bala(this.getDireccion(),this.getPosX()+8,this.getPosY()+8);
        bullet.start();
    }

}
