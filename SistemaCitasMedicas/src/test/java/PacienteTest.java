import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PacienteTest {

    // P1 - Cedula válida, nombre y correo válidos
    @Test
    public void testConstructorConDatosValidos() {
        Paciente paciente = new Paciente("0953446796", "Juan Patricio", "juanpac@gmail.com");

        assertEquals("0953446796", paciente.getCedula());
        assertEquals("Juan Patricio", paciente.getNombre());
        assertEquals("juanpac@gmail.com", paciente.getCorreo());
    }

    // P2 - Cedula vacía, nombre y correo válidos
    @Test
    public void testConstructorConCedulaVacia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Paciente("", "Juan Patricio", "juanpac@gmail.com");
        });

        assertEquals("La cédula no puede ser nula ni vacía", exception.getMessage());
    }
}
