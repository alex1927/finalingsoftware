package escenario;

import java.awt.Rectangle;
import java.util.List;
import java.util.ListIterator;
import jugadores.Player1;
import jugadores.Player2;
import jugadores.enemigos;
import jugadores.tanque;

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
        rAguila = new Rectangle(360, 520, 40, 40);
        // Iteradores
        iterLad = lad.listIterator();
        iterAce = ac.listIterator();
        iterAgua = ag.listIterator();
        this.p1 = P1;
        this.p2 = P2;
        enemies = enemy;
        rTanque1 = new Rectangle();
        rTanque2 = new Rectangle();
        if (p1.isVivo()) {
            rTanque1 = new Rectangle(P1.getTanque().getPosX(), P1.getTanque().getPosY(), P1.getTanque().getAncho(), P1.getTanque().getAlto());
        }
        if (p2.isVivo()) {
            rTanque2 = new Rectangle(P2.getTanque().getPosX(), P2.getTanque().getPosY(), P2.getTanque().getAncho(), P2.getTanque().getAlto());
        }

        for (int j = 0; j < enemy.length; j++) {
            if (enemy[j].isVivo()) {
                rEnemy[j] = new Rectangle(enemy[j].getTanque().getPosX(), enemy[j].getTanque().getPosY(), enemy[j].getTanque().getAncho(), enemy[j].getTanque().getAlto());
            } else {
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

    public synchronized boolean mover(int id) {
        boolean flag = false;
        excMutua.Wait();
        if (!hayColisionTanqueConLadrillo(id)
                && !hayColisionTanqueConAgua(id)
                && !hayColisionTanqueConAcero(id)
                && !hayColisionTanqueConAguila(id)
                && !hayColisionTanqueConTanque(id)
                ) {
            flag = true;
        }
        excMutua.Signal();
        return flag;
    }
    


    public boolean hayColisionTanqueConAguila(int id) {
        boolean flag = false;
        auxGral = obtenerTanque(id);
        if (auxGral.intersects(rAguila)) {
            flag = true;
        }
        return flag;
    }

    public boolean hayColisionTanqueConLadrillo(int id) {


        auxGral = obtenerTanque(id);

        boolean flag = false;

        for (int i = 0; i < rLadrillos.length; i++) {
            if (auxGral.intersects(rLadrillos[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionTanqueConAcero(int id) {

        boolean flag = false;
        auxGral = obtenerTanque(id);
        for (int i = 0; i < rAceros.length; i++) {
            if (auxGral.intersects(rAceros[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionTanqueConAgua(int id) {
        boolean flag = false;
        auxGral = obtenerTanque(id);
        for (int i = 0; i < rAguas.length; i++) {
            if (auxGral.intersects(rAguas[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionBalaConAguila(int id) {
        boolean flag = false;
        auxGral = obtenerBala(id);
        if (auxGral.intersects(rAguila)) {
            flag = true;
        }
        return flag;
    }

    public boolean hayColisionBalaConAcero(int id) {
        boolean flag = false;
        auxGral = obtenerBala(id);
        for (int i = 0; i < rAceros.length; i++) {
            if (auxGral.intersects(rAceros[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionBalaConLadrillo(int id) {


        auxGral = obtenerBala(id);

        boolean flag = false;

        for (int i = 0; i < rLadrillos.length; i++) {
            if (auxGral.intersects(rLadrillos[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public void borrarLadrillo(int id) {
        Rectangle aux1, aux2;
        ListIterator aux;
        ladrillo brick;
        aux = lad.listIterator();
        aux1 = obtenerBala(id);
        while (aux.hasNext()) {
            brick = (ladrillo) aux.next();
            aux2 = new Rectangle(brick.getPosX(), brick.getPosY(), brick.getAlto(), brick.getAncho());
            if (aux1.intersects(aux2)) {
                aux.remove();
            }
        }
    }

    public void borrarAcero(int id) {
        Rectangle aux1, aux2;
        ListIterator aux;
        acero steel;
        aux = ac.listIterator();
        aux1 = obtenerBala(id);
        while (aux.hasNext()) {
            steel = (acero) aux.next();
            aux2 = new Rectangle(steel.getPosX(), steel.getPosY(), steel.getAlto(), steel.getAncho());
            if (aux1.intersects(aux2)) {
                aux.remove();
            }
        }
    }

    public boolean hayColisionBalaConTanque(int id) {
        boolean flag = false;
        rBala = obtenerBala(id);
        if (rBala.intersects(rTanque1)) {
            flag = true;
            if ((int) rTanque1.getX() == p1.getTanque().getPosX() && (int) rTanque1.getY() == p1.getTanque().getPosY() && id < 100) {
                System.out.println("murio p1");
                p1.setHiloVivo(false);
                p1.setVivo(false);
                p1.setEsperandoNacer(true);
                p1.restarVidas();

            }
            // borrarTanque((int) rTanque1.getX(), (int) rTanque1.getY(), id);
        }
        if (rBala.intersects(rTanque2)) {
            flag = true;
            if ((int) rTanque2.getX() == p2.getTanque().getPosX() && (int) rTanque2.getY() == p2.getTanque().getPosY() && id < 100) {
                System.out.println("murio p1");
                p1.setHiloVivo(false);
                p1.setVivo(false);
                p1.setEsperandoNacer(true);
                p1.restarVidas();

            }
            //borrarTanque((int) rTanque2.getX(), (int) rTanque2.getY(), id );
        }
        for (int j = 0; j < rEnemy.length; j++) {
            if (rBala.intersects(rEnemy[j])) {
                flag = true;
                if ((int) rEnemy[j].getX() == enemies[j].getTanque().getPosX() && (int) rEnemy[j].getY() == enemies[j].getTanque().getPosY() && id > 100) {
                    System.out.println(" murio " + j);
                    enemies[j].stop();
                    enemies[j].setVivo(false);
                    //borrarTanque( rEnemy[j].getX(), (int) rEnemy[j].getY(),id);
                }
            }
        }
        return flag;
    }

    public boolean hayColisionTanqueConTanque(int id) {
        boolean flag = false;
        auxGral = obtenerTanque(id);
        if (auxGral.intersects(rTanque1) && id != p1.getsId()) {
            flag = true;
        }
        if (auxGral.intersects(rTanque2) && id != p2.getsId()) {
            flag = true;
        }

        for (int j = 0; j < enemies.length; j++) {
            if (auxGral.intersects(rEnemy[j]) && id != enemies[j].getsId()) {
                flag = true;
            }
        }
        /*if (flag == true) {
        flag = sePuedeColisionar(id);
        }*/

        return flag;
    }

    /* public boolean sePuedeColisionar(int id) {
    boolean flag = true;
    String direccion;
    if (p1.getTanque().getId() == id) {
    auxGral = rTanque1;
    direccion=p1.getTanque().getDireccion();
    }
    if (p2.getTanque().getId() == id) {
    auxGral = rTanque2;
    direccion=p2.getTanque().getDireccion();
    }
    for (int j = 0; j < enemies.length; j++) {
    if (enemies[j].getTanque().getId() == id) {
    auxGral = rEnemy[j];
    direccion=enemies[j].getTanque().getDireccion();
    }
    }
    if (direccion.equals("norte") && (hayColisionConLadrillo(posX, posY, Alto + 4, Ancho)
    || hayColisionConAgua(posX, posY, Alto + 4, Ancho)
    || hayColisionConAcero(posX, posY, Alto + 4, Ancho))) {
    return false;

    }
    if (direccion.equals("sur") && (hayColisionConLadrillo(posX, posY - 4, Alto + 4, Ancho)
    || hayColisionConAgua(posX, posY - 4, Alto, Ancho)
    || hayColisionConAcero(posX, posY - 4, Alto, Ancho))) {
    return false;

    }
    if (direccion.equals("este") && (hayColisionConLadrillo(posX, posY, Alto, Ancho + 4)
    || hayColisionConAgua(posX, posY, Alto, Ancho + 4)
    || hayColisionConAcero(posX, posY, Alto, Ancho + 4))) {
    return false;

    }
    if (direccion.equals("oeste") && (hayColisionConLadrillo(posX - 4, posY, Alto, Ancho + 4)
    || hayColisionConAgua(posX - 4, posY, Alto, Ancho + 4)
    || hayColisionConAcero(posX - 4, posY, Alto, Ancho + 4))) {
    return false;

    }
    return flag;
    }*/
    public boolean hayColisionBalaConBala(int id) {
        boolean flag = false;

        rBala = obtenerBala(id);

        if (p1.getDisparo() && p1.isVivo()) {
            auxGral.setRect(p1.getTanque().getBala().getPosX(), p1.getTanque().getBala().getPosY(), p1.getTanque().getBala().getAncho(), p1.getTanque().getBala().getAlto());
            if (rBala.intersects(auxGral) && rBala.getX() != auxGral.getX() && rBala.getY() != auxGral.getY()) {
                System.out.println("entre p1");
                p1.endBala();
                p1.setDisparo(false);
                return true;
            }
        }

        if (p2.getDisparo() && p2.isVivo()) {
            auxGral.setRect(p2.getTanque().getBala().getPosX(), p2.getTanque().getBala().getPosY(), p2.getTanque().getBala().getAncho(), p2.getTanque().getBala().getAlto());
            if (rBala.intersects(auxGral) && rBala.getX() != auxGral.getX() && rBala.getY() != auxGral.getY()) {
                System.out.println("entre p2");
                p2.endBala();
                p2.setDisparo(false);
                return true;
            }
        }

        for (int j = 0; j < enemies.length; j++) {
            if (enemies[j].getDisparo() && enemies[j].isVivo()) {
                auxGral.setRect(enemies[j].getTanque().getBala().getPosX(), enemies[j].getTanque().getBala().getPosY(), enemies[j].getTanque().getBala().getAncho(), enemies[j].getTanque().getBala().getAlto());
                if (rBala.intersects(auxGral) && rBala.getX() != auxGral.getX() && rBala.getY() != auxGral.getY()) {
                    System.out.println("entre enemy" + j);
                    enemies[j].endBala();
                    enemies[j].setDisparo(false);
                    return true;
                }
            }
        }

        return flag;
    }

    private Rectangle obtenerTanque(int id) {
        Rectangle auxiliar;
        auxiliar = new Rectangle();

        if (p1.getsId() == id) {
            auxiliar = rTanque1;
        }
        if (p2.getsId() == id) {
            auxiliar = rTanque2;
        }
        for (int j = 0; j < enemies.length; j++) {
            if (enemies[j].getsId() == id) {
                auxiliar = rEnemy[j];
            }
        }
        return auxiliar;
    }

    private Rectangle obtenerBala(int id) {
        Rectangle auxiliar;
        auxiliar = new Rectangle();
        if (p1.getsId() == id) {
            auxiliar.setRect(p1.getTanque().getBala().getPosX(), p1.getTanque().getBala().getPosY(), p1.getTanque().getBala().getAncho(), p1.getTanque().getBala().getAlto());
        }
        if (p2.getsId() == id) {
            auxiliar.setRect(p2.getTanque().getBala().getPosX(), p2.getTanque().getBala().getPosY(), p2.getTanque().getBala().getAncho(), p2.getTanque().getBala().getAlto());
        }
        for (int j = 0; j < enemies.length; j++) {
            if (enemies[j].getsId() == id) {
                auxiliar.setRect(enemies[j].getTanque().getBala().getPosX(), enemies[j].getTanque().getBala().getPosY(), enemies[j].getTanque().getBala().getAncho(), enemies[j].getTanque().getBala().getAlto());
            }
        }

        return auxiliar;
    }
}
