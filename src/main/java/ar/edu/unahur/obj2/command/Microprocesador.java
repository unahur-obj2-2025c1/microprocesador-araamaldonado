package ar.edu.unahur.obj2.command;

import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable{
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer PC;
    List<Integer> memoriaDatos = Arrays.asList(new Integer[1024]);

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(operacion -> operacion.execute(this));
    }

    @Override
    public void incProgramCounter() {
        this.PC++;
    }

    @Override
    public Integer getProgramCounter() {
        return this.PC;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return this.acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return this.acumuladorB;
    }

    @Override
    public void copyFrom(Programable programable) {
        this.PC = programable.getProgramCounter();
        this.acumuladorA = programable.getAcumuladorA();
        this.acumuladorB = programable.getAcumuladorB();
    }

    @Override
    public Programable copy() {
        Microprocesador copia = new Microprocesador();
        copia.acumuladorA = this.acumuladorA;
        copia.acumuladorB = this.acumuladorB;
        copia.PC = this.PC;
        return copia;
    }

    @Override
    public void reset() {
        this.acumuladorA = 0;
        this.acumuladorB = 0;
        this.PC = 0;
        this.memoriaDatos = Arrays.asList(new Integer[1024]);
    }

    @Override
    public void setAddr(Integer addr) {
        if (!this.esDireccionValida(addr)){
            throw new IllegalArgumentException("La dirección de memoria no es valida");
        }
        this.memoriaDatos.set(addr, this.getAcumuladorA());
    }

    private Boolean esDireccionValida(Integer addr){
        return 0 <= addr && addr < 1024; 
    }

    @Override
    public Integer getAddr(Integer addr) {
        if (!this.esDireccionValida(addr)) {
            throw new MicroException("La dirección de memoria no es válida.");
        }
        return this.memoriaDatos.get(addr);
    }
}