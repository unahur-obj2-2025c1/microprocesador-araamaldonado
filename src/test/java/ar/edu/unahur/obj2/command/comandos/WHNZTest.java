package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class WHNZTest {
    Programable microProce = new Microprocesador();

    @BeforeEach
    void setUp(){
        microProce.reset();
    }

    @Test
    void testDoExecute() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new SWAP());
        operaciones.add(new LODV(17));
        operaciones.add(new ADD());
        operaciones.add(new SWAP());
        Operable load20 = new LODV(20);
        load20.execute(microProce);
        Operable whnz = new WHNZ(operaciones);

        whnz.execute(microProce);

        assertEquals(0, microProce.getAcumuladorA());
        assertEquals(37, microProce.getAcumuladorB());
        assertEquals(6, microProce.getProgramCounter());
    }
}
