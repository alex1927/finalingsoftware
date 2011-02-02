package jugadores;

import escenario.colisiones;

public class Player extends Players {

    public Player() {}
    public void Player(colisiones monitor){
        super.Players(monitor);
    }
    @Override
    public void run(){}   
}
