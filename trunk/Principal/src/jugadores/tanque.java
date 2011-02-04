package jugadores;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class tanque implements limites {

    private boolean amigo;
    private final static int ANCHO = 30;
    private final static int ALTO = 30;
    private int velocidad;
    private int posX;
    private int posY;
    private String direccion;
    private bala bullet;
    private ImageIcon img;

    public tanque(boolean amigo) {
        this.amigo = amigo;
        direccion = "norte";
        velocidad = 0;
        posX = 0;
        posY = 0;
        img = new ImageIcon("bala.gif");

    }

    public boolean isAmigo() {
        return amigo;
    }

    public void setAmigo(boolean amigo) {
        this.amigo = amigo;
    }



    public String getDireccion() {
        return direccion;
    }

    public int getAncho() {
        return ANCHO;
    }

    public int getAlto() {
        return ALTO;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void dibujar(Graphics g) {
        //bullet.dibujar(g);
        img = new ImageIcon("bala.gif");
        img.paintIcon(null, g, bullet.getPosX(), bullet.getPosY());
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean choqueLimiteNorte() {
        return this.getPosY() < NORTE;
    }

    public boolean choqueLimiteSur() {
        return this.getPosY() + this.getAncho() > SUR;
    }

    public boolean choqueLimiteEste() {
        return this.getPosX() < ESTE;
    }

    public boolean choqueLimiteOeste() {
        return this.getPosX() + this.getAlto() > OESTE;
    }

    public void disparar() {
        if(this.getDireccion().equals("sur")){
            bullet = new bala(getDireccion(),getPosX()+11, getPosY()+31);
        }
        if(this.getDireccion().equals("norte")){
            bullet = new bala(getDireccion(),getPosX()+11, getPosY()-9);
        }
        if(this.getDireccion().equals("este")){
            bullet = new bala(getDireccion(),getPosX()-9, getPosY()+11);
        }
        if(this.getDireccion().equals("oeste")){
            bullet = new bala(getDireccion(),getPosX()+31, getPosY()+11);
        }

        bullet.start();
    }

    public bala getBala(){
        return bullet;
    }
}
