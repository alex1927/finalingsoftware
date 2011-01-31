package escenario;

import java.awt.event.KeyEvent;
import jugadores.*;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class escenario {

    private final int ACERO = 1;
    private final int LADRILLO = 2;
    private final int PASTO = 3;
    private final int AGUA = 4;
    private final int AGUILA = 5;
    private final int NADA = 6;
    private final int INTOCABLES = 7;
    private int aceros;
    private int ladrillos;
    private int pastos;
    private int aguas;
    private int matriz[][];
    private acero steel[];
    private List steelList;
    private ListIterator iterSteel;
    private acero auxSteel;
    private ladrillo brick[];
    private List brickList;
    private ListIterator iterBrick;
    private ladrillo auxBrick;
    private agua water[];
    private List waterList;
    private ListIterator iterWater;
    private agua auxWater;
    private pasto grass[];
    private List grassList;
    private ListIterator iterGrass;
    private pasto auxGrass;
    private aguila eagle;
    private Random random;
    private Player1 jugador1;
    private colisiones monitor;

    public escenario() {
        random = new Random();
        eagle = new aguila();
        jugador1 = new Player1();
        steelList = new LinkedList();
        brickList = new LinkedList();
        waterList = new LinkedList();
        grassList = new LinkedList();
        escribirMatrizInicial();
        generarEscenarioAleatorio();
        cuentoElementos();
        creoElementos();
        setPosiciones();
        monitor = new colisiones(this.brickList, this.steelList, this.waterList);
    }

    public final void escribirMatrizInicial() {
        matriz = new int[][]{{INTOCABLES, INTOCABLES, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, INTOCABLES, INTOCABLES, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, INTOCABLES, INTOCABLES},
                    {INTOCABLES, INTOCABLES, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, INTOCABLES, INTOCABLES, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, INTOCABLES, INTOCABLES},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, INTOCABLES, INTOCABLES, 2, 2, 4, 4, 2, 2, INTOCABLES, INTOCABLES, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, INTOCABLES, INTOCABLES, 2, 2, 4, 4, 2, 2, INTOCABLES, INTOCABLES, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    }

    public final void generarEscenarioAleatorio() {
        int j, aux;
        for (int i = 0; i < 28; i = i + 2) {
            for (j = 0; j < 36; j = j + 2) {
                aux = (int) (Math.random() * 6 + 1);
                if (matriz[i][j] == 0) {
                    matriz[i][j] = aux;
                    matriz[i + 1][j] = aux;
                    matriz[i][j + 1] = aux;
                    matriz[i + 1][j + 1] = aux;
                }
            }
            j = 0;
        }
    }

    public final void cuentoElementos() {
        int j;
        for (int i = 0; i < 28; i = i + 1) {
            for (j = 0; j < 36; j = j + 1) {
                if (matriz[i][j] == ACERO) {
                    aceros = aceros + 1;
                }
                if (matriz[i][j] == LADRILLO) {
                    ladrillos = ladrillos + 1;
                }
                if (matriz[i][j] == PASTO) {
                    pastos = pastos + 1;
                }
                if (matriz[i][j] == AGUA) {
                    aguas = aguas + 1;
                }
            }
            j = 0;
        }
    }

    public final void creoElementos() {

        steel = new acero[aceros];
        brick = new ladrillo[ladrillos];
        grass = new pasto[pastos];
        water = new agua[aguas];

        for (int i = 0; i < aceros; i = i + 1) {
            steel[i] = new acero(i);
            steel[i].setId(i);
        }
        for (int i = 0; i < ladrillos; i = i + 1) {
            brick[i] = new ladrillo(i);
            brick[i].setId(i);
        }
        for (int i = 0; i < pastos; i++) {
            grass[i] = new pasto();
        }
        for (int i = 0; i < aguas; i++) {
            water[i] = new agua();
        }
    }

    public final void setPosiciones() {
        int j, ace = 0, l = 0, p = 0, a = 0;

        for (int i = 0; i < 28; i = i + 1) {
            for (j = 0; j < 36; j = j + 1) {
                if (matriz[i][j] == ACERO) {
                    steel[ace].setPosX(j * 20);
                    steel[ace].setPosY(i * 20);
                    steelList.add(steel[ace]);
                    ace = ace + 1;
                }
                if (matriz[i][j] == LADRILLO) {
                    brick[l].setPosX(j * 20);
                    brick[l].setPosY(i * 20);
                    brickList.add(brick[l]);
                    l = l + 1;
                }
                if (matriz[i][j] == AGUA) {
                    aguas = aguas + 1;
                    water[a].setPosX(j * 20);
                    water[a].setPosY(i * 20);
                    waterList.add(water[a]);
                    a = a + 1;
                }

                if (matriz[i][j] == PASTO) {
                    pastos = pastos + 1;
                    grass[p].setPosX(j * 20);
                    grass[p].setPosY(i * 20);
                    grassList.add(grass[p]);
                    p = p + 1;
                }
            }
            j = 0;
        }

    }

    public void dibujarInicio(Graphics g) {

        iterSteel = steelList.listIterator();
        iterBrick = brickList.listIterator();
        iterWater = waterList.listIterator();
        iterGrass = grassList.listIterator();

        while (iterWater.hasNext()) {
            auxWater = (agua) iterWater.next();
            auxWater.dibujar(g, auxWater.getPosX(), auxWater.getPosY());
        }

        jugador1.dibujar(g, jugador1.getTanque().getPosX(), jugador1.getTanque().getPosY());

        while (iterGrass.hasNext()) {
            auxGrass = (pasto) iterGrass.next();
            auxGrass.dibujar(g, auxGrass.getPosX(), auxGrass.getPosY());
        }

        while (iterSteel.hasNext()) {
            auxSteel = (acero) iterSteel.next();
            auxSteel.dibujar(g, auxSteel.getPosX(), auxSteel.getPosY());
        }

        while (iterBrick.hasNext()) {
            auxBrick = (ladrillo) iterBrick.next();
            auxBrick.dibujar(g, auxBrick.getPosX(), auxBrick.getPosY());
        }
        eagle.dibujar(g);

    }

    public void keyPressed(KeyEvent e) {
        if (!monitor.hayColisionConLadrillo(jugador1.getTanque().getPosX(), jugador1.getTanque().getPosY(), jugador1.getTanque().getAncho(), jugador1.getTanque().getAlto())
                && !monitor.hayColisionConAgua(jugador1.getTanque().getPosX(), jugador1.getTanque().getPosY(), jugador1.getTanque().getAncho(), jugador1.getTanque().getAlto())
                && !monitor.hayColisionConAcero(jugador1.getTanque().getPosX(), jugador1.getTanque().getPosY(), jugador1.getTanque().getAncho(), jugador1.getTanque().getAlto())) {
            jugador1.keyPressed(e);
        } else {
            if (jugador1.getTanque().getDireccion() == "este") {
                jugador1.getTanque().setPosX(jugador1.getTanque().getPosX() + 1);
            }
            if (jugador1.getTanque().getDireccion() == "oeste") {
                jugador1.getTanque().setPosX(jugador1.getTanque().getPosX() - 1);
            }
            if (jugador1.getTanque().getDireccion() == "norte") {
                jugador1.getTanque().setPosY(jugador1.getTanque().getPosY() + 1);
            }
            if (jugador1.getTanque().getDireccion() == "sur") {
                jugador1.getTanque().setPosY(jugador1.getTanque().getPosY() - 1);
            }
        }        
    }

    public void keyReleased(KeyEvent e) {
        jugador1.keyReleased(e);
    }

    public void keyTyped(KeyEvent e) {
    }
}
