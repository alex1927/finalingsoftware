
package jugadores;

public interface limites {
    public final int NORTE = 0;
    public final int SUR = 520;
    public final int ESTE = 0;
    public final int OESTE = 680;
    public boolean choqueLimiteNorte();
    public boolean choqueLimiteSur();
    public boolean choqueLimiteEste();
    public boolean choqueLimiteOeste();
}
