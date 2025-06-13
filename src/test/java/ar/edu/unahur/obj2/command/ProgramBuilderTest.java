package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class ProgramBuilderTest {
    Programable microProce = new Microprocesador();

    @BeforeEach
    void setUp(){
        microProce.reset();
    }

    @Test
    void alBuildearUnProgramaConInstruccionesSimples_CuandoSeLoPasamosAUnMicrocontrolador_FuncionaCorrectamente() {
        ProgramBuilder programBuilder = new ProgramBuilder();

        microProce.run(
                programBuilder
                        .lodv(2)
                        .str(0)
                        .lodv(8)
                        .swap()
                        .lodv(5)
                        .add()
                        .swap()
                        .lod(0)
                        .add().build());

        assertEquals(15, microProce.getAcumuladorA());
        assertEquals(0, microProce.getAcumuladorB());
        assertEquals(9, microProce.getProgramCounter());
    }

    @Test
    void alBuildearUnProgramaConInstrucciones_CuandoSeLoPasamosAUnMicrocontrolador_FuncionaCorrectamente() {
        ProgramBuilder rutina = new ProgramBuilder();
        ProgramBuilder programBuilderPpal = new ProgramBuilder();

        microProce.run(programBuilderPpal.lodv(5).ifnz(rutina.swap().nop().nop().build()).build());

        assertEquals(0, microProce.getAcumuladorA());
        assertEquals(5, microProce.getAcumuladorB());
        assertEquals(5, microProce.getProgramCounter());
    }

    @Test
    void alBuildearUnProgramaSinInstrucciones_SeLanzaUnError() {
        ProgramBuilder programBuilder = new ProgramBuilder();
        assertThrows(MicroException.class, programBuilder::build);

    }
}
