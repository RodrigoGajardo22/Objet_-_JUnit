package ejercicio2;

import org.junit.Assert;
import org.junit.Test;

public class RestaurantTest {

	Bebida coca      = new Bebida("Coca", 200);
	Bebida fanta     = new Bebida("Fanta", 150);
	Bebida sprite    = new Bebida("Sprite", 150);

	Plato  milanesas = new Plato("Milanesas con papas", 500);
	Plato  pollo     = new Plato("Pollo a la parrilla", 600);
	Plato  empanadas = new Plato("Empanadas", 500);

	@Test
	public void testVisa() {
		// SetUp
		Tarjeta     visa        = new Visa(5);
		Dispositivo dispositivo = new Dispositivo(visa);

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado     = dispositivo.calculo();
		float valorEsperado = 1562.4f;

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);
	}

	@Test
	public void testMaster() {

		// SetUp
		Tarjeta     master      = new MasterCard(5);
		Dispositivo dispositivo = new Dispositivo(master);

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarBebida(fanta, 1);
		dispositivo.agregarBebida(sprite, 1);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);
		dispositivo.agregarPlato(empanadas, 2);

		// Testeo
		float resultado     = dispositivo.calculo();
		float valorEsperado = 2895.9f;
		System.out.println("Resultado: " + resultado);

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);

	}

	@Test
	public void testComarca() {

		// SetUp
		Tarjeta     comarca     = new ComarcaPlus(5);
		Dispositivo dispositivo = new Dispositivo(comarca);

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado     = dispositivo.calculo();
		float valorEsperado = 1543.5f;

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);

	}

	@Test
	public void testViedma() {

		// SetUp
		Tarjeta     viedma      = new Viedma(5);
		Dispositivo dispositivo = new Dispositivo(viedma);

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		// Testeo
		float resultado     = dispositivo.calculo();
		float valorEsperado = 1575f;

		// Veriticacion
		Assert.assertTrue(valorEsperado == resultado);

	}

}
