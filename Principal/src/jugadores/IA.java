package jugadores;

import java.util.Random;

public class IA {

    private Random random;

    public void IA() {
        random = new Random();
    }

    public String direccion(String direccion) {
        String dir = direccion;
        int aux = (int) (Math.random() * 10 + 1);

        do {
            if (aux <= 4) {
                dir = "sur";
            }
            if (aux >= 5 && aux <= 6) {
                dir = "este";
            }
            if (aux >= 7 && aux <= 8) {
                dir = "oeste";
            }
            if (aux >= 9 && aux <= 10) {
                dir = "norte";
            }
        } while (dir.equals(direccion));
        return dir;
    }
}
