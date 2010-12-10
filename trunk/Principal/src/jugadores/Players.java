
package jugadores;


public class Players extends Thread{
    int tipo;
    tanque Tanque;
    estado status;

    public Players(){
        Tanque = new tanque();
        status = new estado();
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public int getTipo(){
        return tipo;
    }
    @Override
    public void run(){

    }
}
