package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class SWAPTest {
    Programable microProce = new Microprocesador();

    @BeforeEach
    void setUp(){
        microProce.reset();
    }

    @Test
    void alEjecutarLaInstruccionSwap_seIntercambiaLosValoresEnLosAcumuladoresYSeIncrementaElProgamaCounter() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(20));
        operaciones.add(new SWAP());

        microProce.run(operaciones);

        assertEquals(0, microProce.getAcumuladorA());
        assertEquals(20, microProce.getAcumuladorB());
        assertEquals(2, microProce.getProgramCounter());
    }
}
