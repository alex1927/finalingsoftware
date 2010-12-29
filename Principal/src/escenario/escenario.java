
package escenario;

import java.awt.event.KeyEvent;
import jugadores.*;
import java.awt.Graphics;
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
    private int matriz [][];
    private acero steel[];
    private ladrillo brick[];
    private agua water[];
    private pasto grass[];
    private aguila eagle;
    private Random random;
    private Player1 jugador1;
    private colisiones monitor;
    
    public escenario(){
        eagle = new aguila();
        random = new Random();
        jugador1 = new Player1();
        escribirMatrizInicial();
        generarEscenarioAleatorio();
        cuentoElementos();
        creoElementos();
        setPosiciones();
        monitor = new colisiones(this.brick,this.steel,this.water);

    }

    public final void escribirMatrizInicial(){
        matriz = new int[][]
        {{INTOCABLES,INTOCABLES,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,INTOCABLES,INTOCABLES,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,INTOCABLES,INTOCABLES},
         {INTOCABLES,INTOCABLES,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,INTOCABLES,INTOCABLES,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,INTOCABLES,INTOCABLES},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,INTOCABLES,INTOCABLES,2,2,4,4,2,2,INTOCABLES,INTOCABLES,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,INTOCABLES,INTOCABLES,2,2,4,4,2,2,INTOCABLES,INTOCABLES,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    }

    public final void generarEscenarioAleatorio(){
        int j, aux;
        for( int i=0 ; i<28 ; i=i+2 ){
            for( j=0 ; j<36 ; j=j+2 ){
                aux = (int) (Math.random()*6+1);
                if(matriz[i][j]== 0){
                    matriz[i][j]= aux;
                    matriz[i+1][j]= aux;
                    matriz[i][j+1]=aux;
                    matriz[i+1][j+1]=aux;
                }
            }
        j = 0;
        }
    }

    public final void cuentoElementos(){
        int j;
        for( int i=0 ; i<28 ; i=i+1 ){
            for( j=0 ; j<36 ; j=j+1 ){
                if( matriz[i][j] == ACERO ){
                    aceros = aceros+1;
                }
                if( matriz[i][j]==LADRILLO ){
                    ladrillos = ladrillos+1;
                }
                if( matriz[i][j]==PASTO){
                    pastos = pastos+1;
                }
                if( matriz[i][j]==AGUA ){
                    aguas = aguas+1;
                }
            }
            j = 0;
        }
    }

    public final void creoElementos(){
        
        steel = new acero[aceros];
        brick = new ladrillo[ladrillos];
        grass = new pasto[pastos];
        water = new agua[aguas];
        
        for(int i = 0; i<aceros ; i=i+1){
            steel[i]=new acero(i);
            steel[i].setId(i);
        }
        for(int i=0; i<ladrillos; i=i+1){
            brick[i]= new ladrillo(i);
            brick[i].setId(i);
        }
        for(int i=0; i<pastos; i++){
            grass[i] = new pasto();
        }
        for(int i=0; i<aguas; i++){
            water[i] = new agua();
        }
    }

    public final void setPosiciones(){
        int j, ace = 0, l = 0, p = 0, a = 0;

        for( int i=0 ; i<28 ; i=i+1 ){
            for( j=0 ; j<36 ; j=j+1 ){
                if( matriz[i][j] == ACERO ){
                    steel[ace].setPosX(j*20);
                    steel[ace].setPosY(i*20);
                    ace = ace + 1;
                }
                if( matriz[i][j]==LADRILLO ){
                    brick[l].setPosX(j*20);
                    brick[l].setPosY(i*20);
                    l = l+1;
                }
                if( matriz[i][j]==AGUA ){
                    aguas = aguas+1;
                    water[a].setPosX(j*20);
                    water[a].setPosY(i*20);
                    a = a+1;
                }
            }
            j = 0;
        }
    }

    public void dibujarInicio(Graphics g){

    int j, ac = 0, l = 0, p = 0, a = 0;

    jugador1.dibujar(g, jugador1.getTanque().getPosX(), jugador1.getTanque().getPosY());
    
    for( int i=0 ; i<28 ; i=i+1 ){
        for( j=0 ; j<36 ; j=j+1 ){
            if( matriz[i][j]==ACERO ){
                steel[ac].dibujar(g, j*20, i*20);
                ac = ac+1;
            }
            if( matriz[i][j]==LADRILLO ){
                brick[l].dibujar(g, j*20, i*20);
                l = l+1;
            }
            if( matriz[i][j]==PASTO ){
                grass[p].dibujar(g, j*20, i*20);
                p = p+1;
            }
            if( matriz[i][j]==AGUA ){
                water[a].dibujar(g, j*20, i*20);
                a = a+1;
            }
        }
        j=0;
    }    
    eagle.dibujar(g);
    
    }

    public void keyPressed(KeyEvent e){
        if(!monitor.hayColisionConLadrillo(jugador1.getTanque().getPosX(),jugador1.getTanque().getPosY(),jugador1.getTanque().getAncho(),jugador1.getTanque().getAlto())&&
                !monitor.hayColisionConAgua(jugador1.getTanque().getPosX(),jugador1.getTanque().getPosY(),jugador1.getTanque().getAncho(),jugador1.getTanque().getAlto())&&
                    !monitor.hayColisionConAcero(jugador1.getTanque().getPosX(),jugador1.getTanque().getPosY(),jugador1.getTanque().getAncho(),jugador1.getTanque().getAlto())){
            jugador1.keyPressed(e);
        }else{
            if(jugador1.getTanque().getDireccion() == "este"){
                jugador1.getTanque().setPosX(jugador1.getTanque().getPosX()+1);
            }
            if(jugador1.getTanque().getDireccion() == "oeste"){
                jugador1.getTanque().setPosX(jugador1.getTanque().getPosX()-1);
            }
            if(jugador1.getTanque().getDireccion() == "norte"){
                jugador1.getTanque().setPosY(jugador1.getTanque().getPosY()+1);
            }
            if(jugador1.getTanque().getDireccion() == "sur"){
                jugador1.getTanque().setPosY(jugador1.getTanque().getPosY()-1);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
            jugador1.keyReleased(e);
    }
    
    public void keyTyped(KeyEvent e) {
    }
}
