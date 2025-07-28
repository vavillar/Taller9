/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SistemaCitasTest {

    private SistemaCitas sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaCitas();
    }

    // SC1 - registrarPaciente
    @Test
    public void testRegistrarPaciente() {
        sistema.registrarPaciente("123", "Juan", "juan@mail.com");
        // Verificamos que se pueda agendar cita (solo posible si existe el paciente)
        sistema.registrarMedico("Dra. Ana", "Cardiología");
        sistema.agendarCita("123", "Cardiología", LocalDateTime.now());
        sistema.verHistorial("123"); 
    }

    // SC2 - agendarCita con paciente inexistente
    @Test
    public void testAgendarCitaPacienteInexistente() {
        sistema.registrarMedico("Dr. Luis", "Pediatría");
        sistema.agendarCita("999", "Pediatría", LocalDateTime.now());
        // No se agrega cita si paciente no existe
        sistema.verHistorial("999"); 
    }

    // SC3 - solicitarExamen con paciente válido
    @Test
    public void testSolicitarExamenPacienteValido() {
        sistema.registrarPaciente("456", "Ana", "ana@mail.com");
        sistema.solicitarExamen("456", "Sangre");
        sistema.verHistorial("456"); // Debería imprimir el examen
    }

    // SC4 - registrarResultado con paciente no registrado
    @Test
    public void testRegistrarResultadoPacienteNoRegistrado() {
        sistema.solicitarExamen("888", "Orina"); 
        sistema.registrarResultado("888", "Orina", "Normal"); 
        sistema.verHistorial("888"); //
    }

    // SC5 - verHistorial con y sin historial
    @Test
    public void testVerHistorial() {
        sistema.registrarPaciente("111", "Carlos", "carlos@mail.com");
        sistema.registrarMedico("Dra. Luz", "Dermatología");
        sistema.agendarCita("111", "Dermatología", LocalDateTime.now());
        sistema.solicitarExamen("111", "Piel");
        sistema.registrarResultado("111", "Piel", "Sin anomalías");

        System.out.println("Historial con datos:");
        sistema.verHistorial("111"); // Debería imprimir cita y examen con resultado

        sistema.registrarPaciente("222", "Lucía", "lucia@mail.com");
        System.out.println("Historial sin datos:");
        sistema.verHistorial("222"); // No debería imprimir nada
    }
}
