package ejercicio1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class ConcursoTest {

	private Participante p1 = new Participante("Juan Fuentes", 40635211);      // Puede inscrirbirse
	private Participante p2 = new Participante("Alberto Garcia", 36849859);    // Puede inscrirbirse y suma puntos
	private Participante p3 = new Participante("Cristina Entraigas", 17647852);// No puede

	@Test
	public void testInscripcion() { // concurso abierto hace 3 dias y finaliza en 10

		Concurso c1 = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().plusDays(10));

		assertTrue(c1.inscribirParticipante(p1));
	}

	@Test
	public void testInscripcionHoy() {// Concurso abrió hoy

		Concurso c = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7));
		assertTrue(c.inscribirParticipante(p2));
	}

	@Test
	public void testInscripcionFueraTermino() { // No puede inscribirse

		Concurso c = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(12));
		assertTrue(!c.inscribirParticipante(p3));
	}

	@Test
	public void testPuntos() { // verifica si suma puntos o no.

		Participante p4 = new Participante("Sumable", 40635211);
		Participante p5 = new Participante("Iumable", 40635211);

		Concurso     c4 = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7));              // abrio hoy
		Concurso     c5 = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(12)); // todavia no

		c4.inscribirParticipante(p4);
		c5.inscribirParticipante(p5);

		assertEquals(10, p4.puntos()); // SUMA

		assertEquals(0, p5.puntos()); // NO SUMA

	}

}
