package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class IFNZTest {
    Programable microProce = new Microprocesador();

    @BeforeEach
    void setUp(){
        microProce.reset();
    }

    @Test
    void alEjecutarLaInstucionIfnz_siendoElAcumuladorANo0_seEjecutanLasInstrucciones() {

        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new SWAP());

        Operable lodv20 = new LODV(20);
        lodv20.execute(microProce);

        Operable ifnz = new IFNZ(operaciones);

        ifnz.execute(microProce);

        assertEquals(0, microProce.getAcumuladorA());
        assertEquals(20, microProce.getAcumuladorB());
        assertEquals(3, microProce.getProgramCounter());

    }

    @Test
    void alEjecutarLaInstucionIfnz_siendoElAcumuladorA0_NoseEjecutanLasInstrucciones() {

        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new SWAP());
        operaciones.add(new LODV(17));
        operaciones.add(new ADD());

        Operable lodv20 = new LODV(20);
        Operable swap = new SWAP();
        lodv20.execute(microProce);
        swap.execute(microProce);

        Operable ifnz = new IFNZ(operaciones);

        ifnz.execute(microProce);

        assertEquals(0, microProce.getAcumuladorA());
        assertEquals(20, microProce.getAcumuladorB());
        assertEquals(3, microProce.getProgramCounter());

    }


}
