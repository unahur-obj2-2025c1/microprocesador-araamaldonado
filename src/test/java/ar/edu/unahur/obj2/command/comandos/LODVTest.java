package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class LODVTest {
    Programable microProce = new Microprocesador();

    @BeforeEach
    void setUp(){
        microProce.reset();
    }

    @Test
    void alEjecutarLaInstucionLodv_seCargaElAcumuladorAYSeIncrementaElProgramaCounter() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(20));

        microProce.run(operaciones);

        assertEquals(20, microProce.getAcumuladorA());
        assertEquals(1, microProce.getProgramCounter());
    }
}
