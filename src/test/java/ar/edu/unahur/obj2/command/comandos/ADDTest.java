package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class ADDTest {

    Programable microProce = new Microprocesador();

    @BeforeEach
    void setUp(){
        microProce.reset();
    }

    @Test
    void alSumarAcumuladorAMasAcumuladorB_elResultadoQuedaEnElAcumuladorA() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(20));
        operaciones.add(new SWAP());
        operaciones.add(new LODV(17));
        operaciones.add(new ADD());

        microProce.run(operaciones);

        assertEquals(37, microProce.getAcumuladorA());
        assertEquals(0, microProce.getAcumuladorB());
        assertEquals(4, microProce.getProgramCounter());
    }

    @Test
    void alSumar3ValoresPasandoPorElAreaDeDatos_elResultadoQuedaEnElAcumuladorA() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(2));
        operaciones.add(new STR(0));
        operaciones.add(new LODV(8));
        operaciones.add(new SWAP());
        operaciones.add(new LODV(5));
        operaciones.add(new ADD());
        operaciones.add(new SWAP());
        operaciones.add(new LOD(0));
        operaciones.add(new ADD());
        microProce.run(operaciones);

        assertEquals(15, microProce.getAcumuladorA());
        assertEquals(0, microProce.getAcumuladorB());
        assertEquals(9, microProce.getProgramCounter());
    }
    
    
}
