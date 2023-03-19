package ejercicio1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

	private List<Participante> listParticipantes;
	private LocalDate          fechaInicio, fechaFin;

	public Concurso(LocalDate fechaIni, LocalDate fechaFin) {
		this.fechaInicio  = fechaIni;
		this.fechaFin     = fechaFin;
		listParticipantes = new ArrayList<Participante>();
	}

	public boolean inscribirParticipante(Participante p) {

		if (puedeInscribirse()) {
			verificarFechaYsumarPuntos(p);
			listParticipantes.add(p);
			return true;
		}
		return false;

	}

	private void verificarFechaYsumarPuntos(Participante p) {

		LocalDate fechaDeHoy = LocalDate.now();

		if (fechaInicio.equals(fechaDeHoy)) {
			p.sumarPuntos();
			// System.out.println(p.mostrarDatos());
		}
	}

	private boolean puedeInscribirse() {// si la fecha es valida, entonces True;

		LocalDate fechaHoy = LocalDate.now();

		if (fechaHoy.equals(fechaInicio))
			return true;
		if (fechaHoy.isAfter(fechaInicio) && fechaHoy.isBefore(fechaFin))
			return true;

		return false;
	}

	public void mostrarParticipantes() {

		int i = 1;
		if (listParticipantes.size() > 0)
			for (Participante p : listParticipantes) {
				System.out.println(i + " - " + p.mostrarDatos());
				i++;
			}
		else
			System.out.println("Aun no hay participantes registrados.");
	}

}
