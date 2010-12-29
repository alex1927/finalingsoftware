
package escenario;
import java.awt.Rectangle;

public class colisiones {
    Rectangle rTanque;
    Rectangle rLadrillos[];
    Rectangle rAguas[];
    Rectangle rAceros[];

    /*CONSTRUCTOR*/
    public colisiones(ladrillo lad[],acero ac[],agua ag[]){
        rTanque = new Rectangle();
        rLadrillos = new Rectangle[lad.length];
        rAguas = new Rectangle[ag.length];
        rAceros = new Rectangle[ac.length];

        for(int i = 0; i < lad.length ; i++ ){
            rLadrillos[i] = new Rectangle(lad[i].getPosX(),lad[i].getPosY(),20,20);
        }

        for(int i = 0; i < ag.length ; i++ ){
            rAguas[i] = new Rectangle(ag[i].getPosX(),ag[i].getPosY(),20,20);
        }

        for(int i = 0; i < ac.length ; i++ ){
            rAceros[i] = new Rectangle(ac[i].getPosX(),ac[i].getPosY(),20,20);
        }
    }
    /*FIN DEL CONSTRUCTOR*/

    public boolean hayColisionConLadrillo(int posX, int posY,int Ancho, int Alto){
        boolean flag = false;
        rTanque = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rLadrillos.length; i++){
            if(rTanque.intersects(rLadrillos[i])){
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionConAcero(int posX, int posY,int Ancho, int Alto){
        boolean flag = false;
        rTanque = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rAceros.length; i++){
            if(rTanque.intersects(rAceros[i])){
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionConAgua(int posX, int posY,int Ancho, int Alto){
        boolean flag = false;
        rTanque = new Rectangle(posX, posY,Ancho ,Alto);
        for (int i = 0; i < rAguas.length; i++){
            if(rTanque.intersects(rAguas[i])){
                flag = true;
            }
        }
        return flag;
    }
}
