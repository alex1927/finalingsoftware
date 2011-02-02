
package escenario;

public class Semaforo {

	private int contador = 0;

	public Semaforo(int valorInicial) {

		contador = valorInicial;
	}

	public synchronized void Wait() {

		while (contador == 0)
			try {
				wait();
			} catch (Exception e) {
			}
			contador = contador - 1;
	}

	public synchronized void Signal() {

		contador++;
		notify();
	}
}
