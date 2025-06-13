package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.IFNZ;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;
import ar.edu.unahur.obj2.command.comandos.WHNZ;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class ProgramBuilder {
    private List<Operable> operaciones = new ArrayList<>();

    public List<Operable> build(){
        if (operaciones.isEmpty())
            throw new MicroException("No se puede buildear un programa sin operaciones.");
        return operaciones;
    }

    public ProgramBuilder nop(){
        operaciones.add(new NOP());
        return this;
    }

    public ProgramBuilder add(){
        operaciones.add(new ADD());
        return this;
    }  
    
    public ProgramBuilder swap(){
        operaciones.add(new SWAP());
        return this;
    }

    public ProgramBuilder lod(Integer add){
        operaciones.add(new LOD(add));
        return this;
    }
    
    public ProgramBuilder str(Integer add){
        operaciones.add(new STR(add));
        return this;
    }
    
    public ProgramBuilder lodv(Integer nro){
        operaciones.add(new LODV(nro));
        return this;
    }

    public ProgramBuilder whnz(List<Operable> operaciones){
        operaciones.add(new WHNZ(operaciones));
        return this;
    }

    public ProgramBuilder ifnz(List<Operable> operaciones){
        operaciones.add(new IFNZ(operaciones));
        return this;
    }
}
