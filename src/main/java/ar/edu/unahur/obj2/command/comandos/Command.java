package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class Command implements Operable{

    Programable estadoMicro;

    @Override
    public void execute(Programable micro) {
        estadoMicro = micro.copy();
        this.doExecute(micro);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(estadoMicro);
    }

    public abstract void doExecute(Programable micro);
}
