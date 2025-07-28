/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CltControl
 */
public class MedicoTest {
    
    public MedicoTest() {
    }

    @Test
    public void testConstructor() {
        Medico medico = new Medico("Dra. Gomez", "Cardiología");
        assertEquals("Dra. Gomez", medico.getNombre());
        assertEquals("Cardiología", medico.getEspecialidad());
    }

    // M2: Validar nombre vacío
    @Test
    public void testConstructor_nombreVacio() {
        Medico medico = new Medico("", "Cardiología");
        assertEquals("", medico.getNombre());
        assertEquals("Cardiología", medico.getEspecialidad());
    }
}