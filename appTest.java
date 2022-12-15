import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import libro.libro;

class appTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	void testCrearLibro() {
		String[] test = {"name","autor","fechaEdicion","numPaginas","editorial","genero","isbn","ubicacion","estado","descripcion"};
		libro real = app.crearLibro(test);
		libro esperado = new libro("name","autor","fechaEdicion","numPaginas","editorial","genero","isbn","ubicacion","estado","descripcion");
		assertEquals(real.toString(),esperado.toString());
	}
	@Test
	void testCrearLibroFallida() {
		String[] test = {"name","autor","fechaEdicion","numPaginas","editorial","genero","isbn","ubicacion","estado","descripcion"};
		libro real = app.crearLibro(test);
		exception.expect(ArrayIndexOutOfBoundsException.class);
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

}
