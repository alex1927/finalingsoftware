package escenario;

import java.awt.Rectangle;
import java.util.List;
import java.util.ListIterator;
import jugadores.Player1;
import jugadores.Player2;
import jugadores.enemigos;

public class colisiones {

    private Rectangle auxGral;
    private Rectangle rTanque1;
    private Rectangle rTanque2;
    private Rectangle rBala;
    private Rectangle rLadrillos[];
    private Rectangle rAguas[];
    private Rectangle rAceros[];
    private Rectangle rAguila;
    private ladrillo auxLad;
    private ListIterator iterLad;
    private List lad;
    private acero auxAcero;
    private ListIterator iterAce;
    private List ac;
    private agua auxAgua;
    private ListIterator iterAgua;
    private Semaforo excMutua;
    private Player1 p1;
    private Player2 p2;
    private enemigos enemies[];
    private Rectangle rEnemy[];


    /*CONSTRUCTOR*/
    public colisiones(List lad, List ac, List ag, Player1 P1, Player2 P2, enemigos enemy[]) {

        int i = 0;
        this.lad = lad;
        this.ac = ac;
        excMutua = new Semaforo(1);
        // Rectangulos
        auxGral = new Rectangle();
        rBala = new Rectangle();
        rEnemy = new Rectangle[enemy.length];
        enemies = new enemigos[enemy.length];
        rLadrillos = new Rectangle[lad.size()];
        rAguas = new Rectangle[ag.size()];
        rAceros = new Rectangle[ac.size()];
        rAguila = new Rectangle (360,520,40,40);
        // Iteradores
        iterLad = lad.listIterator();
        iterAce = ac.listIterator();
        iterAgua = ag.listIterator();
        this.p1 = P1;
        this.p2 = P2;
        enemies = enemy;
        rTanque1 = new Rectangle();
        rTanque2 = new Rectangle();
        if(p1.isVivo()){
            rTanque1 = new Rectangle(P1.getTanque().getPosX(),P1.getTanque().getPosY(),P1.getTanque().getAncho(),P1.getTanque().getAlto());
        }
        if(p1.isVivo()){
            rTanque2 = new Rectangle(P2.getTanque().getPosX(),P2.getTanque().getPosY(),P2.getTanque().getAncho(),P2.getTanque().getAlto());
        }

        for(int j = 0; j < enemy.length ; j++){
            if(enemy[j].isVivo()){
                rEnemy[j] = new Rectangle(enemy[j].getTanque().getPosX(),enemy[j].getTanque().getPosY(),enemy[j].getTanque().getAncho(),enemy[j].getTanque().getAlto());
            }else{
                rEnemy[j] = new Rectangle();
            }
        }

        while (iterLad.hasNext()) {
            auxLad = (ladrillo) iterLad.next();
            rLadrillos[i] = new Rectangle(auxLad.getPosX(), auxLad.getPosY(), auxLad.getAlto(), auxLad.getAncho());
            i++;
        }
        i = 0;
        while (iterAce.hasNext()) {
            auxAcero = (acero) iterAce.next();
            rAceros[i] = new Rectangle(auxAcero.getPosX(), auxAcero.getPosY(), auxAcero.getAlto(), auxAcero.getAncho());
            i++;
        }
        i = 0;
        while (iterAgua.hasNext()) {
            auxAgua = (agua) iterAgua.next();
            rAguas[i] = new Rectangle(auxAgua.getPosX(), auxAgua.getPosY(), auxAgua.getAlto(), auxAgua.getAncho());
            i++;
        }
    }
    /*FIN DEL CONSTRUCTOR*/

    public synchronized boolean mover(int posX, int posY, int Ancho, int Alto){
        boolean flag = false;
        excMutua.Wait();
        if(!hayColisionConLadrillo(posX,posY,Alto,Ancho)&&
            !hayColisionConAgua(posX,posY,Alto,Ancho)&&
                !hayColisionConAcero(posX,posY,Alto,Ancho)){
                flag = true;
        }
        excMutua.Signal();
        return flag;
    }

   public boolean hayColisionConAguila(int posX, int posY, int Ancho, int Alto){
        boolean flag = false;
        auxGral = new Rectangle(posX, posY, Ancho, Alto);
        if(auxGral.intersects(rAguila)){
            flag= true;
        }
        return flag;
    }

    public boolean hayColisionConLadrillo(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        auxGral = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rLadrillos.length; i++) {
            if (auxGral.intersects(rLadrillos[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionConAcero(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        auxGral = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rAceros.length; i++) {
            if (auxGral.intersects(rAceros[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionConAgua(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        auxGral = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rAguas.length; i++) {
            if (auxGral.intersects(rAguas[i])) {
                flag = true;
            }
        }
        return flag;
    }    

    public boolean hayColisionBalaConTanqueEnemigo(int posX, int posY,int Ancho, int Alto ){
        boolean flag = false;
        auxGral = new Rectangle(posX, posY, Ancho, Alto);
        if(auxGral.intersects(rAguila)){
            flag= true;
        }
        return flag;
    }

    public void borrarLadrillo(int posX, int posY, int Ancho, int Alto){
         Rectangle aux1,aux2;
         ListIterator aux;
         ladrillo brick;
         aux = lad.listIterator();
         aux1 = new Rectangle(posX,posY,Ancho,Alto);
          while(aux.hasNext()){
            brick = (ladrillo) aux.next();
            aux2 = new Rectangle (brick.getPosX(),brick.getPosY(),brick.getAlto(),brick.getAncho());
            if(aux1.intersects(aux2)){
                aux.remove();
            }
        }
    }

     public void borrarAcero(int posX, int posY, int Ancho, int Alto){
         Rectangle aux1,aux2;
         ListIterator aux;
         acero steel;
         aux = ac.listIterator();
         aux1 = new Rectangle(posX,posY,Ancho,Alto);
          while(aux.hasNext()){
            steel = (acero) aux.next();
            aux2 = new Rectangle (steel.getPosX(),steel.getPosY(),steel.getAlto(),steel.getAncho());
            if(aux1.intersects(aux2)){
                aux.remove();
            }
        }
    }

     public boolean hayColisionBalaTanque(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        rBala = new Rectangle(posX, posY, Ancho, Alto);
        if (rBala.intersects(rTanque1)) {
            flag = true;
            borrarTanque((int)rTanque1.getX(),(int)rTanque1.getY());
        }
        if (rBala.intersects(rTanque2)) {
            flag = true;
            borrarTanque((int)rTanque2.getX(),(int)rTanque2.getY());
        }
        for (int j = 0; j < rEnemy.length; j++) {
            if (rBala.intersects(rEnemy[j])) {
                flag = true;
                borrarTanque((int)rEnemy[j].getX(),(int)rEnemy[j].getY());
            }
        }
        return flag;
    }


    public void borrarTanque(int posX, int posY){

        if(posX==p1.getTanque().getPosX() && posY == p1.getTanque().getPosY()){
            p1.setHiloVivo(false);
            p1.setVivo(false);
            p1.setEsperandoNacer(true);
            p1.restarVidas();
        }

        if(posX==p2.getTanque().getPosX() && posY == p2.getTanque().getPosY()){
            p2.setHiloVivo(false);
            p2.setVivo(false);
            p2.setEsperandoNacer(true);
            p2.restarVidas();
        }

        for(int j=0;j<enemies.length;j++){
            if(posX==enemies[j].getTanque().getPosX() && posY == enemies[j].getTanque().getPosY()){
                enemies[j].stop();
                enemies[j].setVivo(false);
            }
        }
    }
}
