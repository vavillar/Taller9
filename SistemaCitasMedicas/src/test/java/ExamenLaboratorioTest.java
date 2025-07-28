import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExamenLaboratorioTest {

    // EL1: registrarResultado actualiza el resultado correctamente
    @Test
    public void testRegistrarResultado() {
        Paciente paciente = new Paciente("001", "Carlos", "carlos@mail.com");
        ExamenLaboratorio examen = new ExamenLaboratorio(paciente, "Sangre");

        examen.registrarResultado("Normal");
        String resultadoEsperado = "Normal";

        assertTrue(examen.toString().contains(resultadoEsperado), 
            "El resultado registrado debería aparecer en la salida de toString()");
    }

    // EL2: toString contiene 'Pendiente' inicialmente
    @Test
    public void testToStringInicialPendiente() {
        Paciente paciente = new Paciente("002", "Lucía", "lucia@mail.com");
        ExamenLaboratorio examen = new ExamenLaboratorio(paciente, "Orina");

        assertTrue(examen.toString().contains("Pendiente"),
            "El resultado inicial del examen debe ser 'Pendiente'");
    }
}
