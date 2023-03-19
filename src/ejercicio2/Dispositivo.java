package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo {

	private Tarjeta      tarjeta;
	private List<Bebida> listaBebidas;
	private List<Plato>  listaPlatos;
	private float        montoBebida, montoPlatos;

	public Dispositivo(Tarjeta t) {
		this.tarjeta = t;
		montoBebida  = 0;
		montoPlatos  = 0;

		listaBebidas = new ArrayList<>();
		listaPlatos  = new ArrayList<>();

	}

	public void seleccionarTarjeta(Tarjeta t) {
		this.tarjeta = t;
	}

	public void agregarBebida(Bebida b, int cantidad) {

		listaBebidas.add(b);
		montoBebida += b.costoTotal(cantidad); // --> montoBebida += cantidad * b.costo() ?? es como un get?

	}

	public void agregarPlato(Plato p, int cantidad) {

		listaPlatos.add(p);
		montoPlatos = montoPlatos + p.costoTotal(cantidad);

	}

	public float calculo() {

		return tarjeta.calculo(montoBebida, montoPlatos);

	}

}
