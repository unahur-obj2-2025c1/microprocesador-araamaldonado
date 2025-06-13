package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class WHNZ extends CompositeCommand{

    public WHNZ(List<Operable> operaciones) {
        super(operaciones);
    }

    @Override
    public void doExecute(Programable micro) {
        while (this.notZero(micro)){
            super.doExecute(micro);
        }
    }

}
