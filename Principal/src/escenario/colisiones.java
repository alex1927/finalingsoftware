package escenario;

import java.awt.Rectangle;
import java.util.List;
import java.util.ListIterator;

public class colisiones {

    private Rectangle rTanque;
    private Rectangle rLadrillos[];
    private Rectangle rAguas[];
    private Rectangle rAceros[];
    private ladrillo auxLad;
    private ListIterator iterLad;
    private acero auxAcero;
    private ListIterator iterAce;
    private agua auxAgua;
    private ListIterator iterAgua;

    /*CONSTRUCTOR*/
    public colisiones(List lad, List ac, List ag) {

        int i = 0;
        // Rectangulos
        rTanque = new Rectangle();
        rLadrillos = new Rectangle[lad.size()];
        rAguas = new Rectangle[ag.size()];
        rAceros = new Rectangle[ac.size()];
        // Iteradores
        iterLad = lad.listIterator();
        iterAce = ac.listIterator();
        iterAgua = ag.listIterator();

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

    public boolean hayColisionConLadrillo(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        rTanque = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rLadrillos.length; i++) {
            if (rTanque.intersects(rLadrillos[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionConAcero(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        rTanque = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rAceros.length; i++) {
            if (rTanque.intersects(rAceros[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hayColisionConAgua(int posX, int posY, int Ancho, int Alto) {
        boolean flag = false;
        rTanque = new Rectangle(posX, posY, Ancho, Alto);
        for (int i = 0; i < rAguas.length; i++) {
            if (rTanque.intersects(rAguas[i])) {
                flag = true;
            }
        }
        return flag;
    }
}
