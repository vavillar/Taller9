/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CltControl
 */
public class CitaMedicaTest {
    
    public CitaMedicaTest() {
    }
    @Test
    public void testToString() {
        Paciente paciente = new Paciente("123", "Juan Perez", "juan@mail.com");
        Medico medico = new Medico("Dra. Gomez", "Cardiología");
        LocalDateTime fechaHora = LocalDateTime.of(2025, 7, 28, 10, 0);
        CitaMedica cita = new CitaMedica(paciente, medico, fechaHora);

        String result = cita.toString();
        assertNotNull(result);
        assertTrue(result.contains("Juan Perez"));
        assertTrue(result.contains("Dra. Gomez"));
        assertTrue(result.contains("Cardiología"));
        assertTrue(result.contains("2025"));
        assertTrue(result.contains("Agendada"));
    }

    @Test
    public void testSetEstado() {
        Paciente paciente = new Paciente("123", "Juan Perez", "juan@mail.com");
        Medico medico = new Medico("Dra. Gomez", "Cardiología");
        LocalDateTime fechaHora = LocalDateTime.of(2025, 7, 28, 10, 0);
        CitaMedica cita = new CitaMedica(paciente, medico, fechaHora);

        cita.setEstado(null);
        assertNull(cita.getEstado());
    }
}
