package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public abstract class CompositeCommand extends Command{
    
    protected List<Operable> operaciones;

    protected CompositeCommand(List<Operable> operaciones){
        this.operaciones = operaciones;
    }

    protected Boolean notZero(Programable micro){
        return !micro.getAcumuladorA().equals(0);
    }

    @Override
    public void doExecute(Programable micro) {
        if (Boolean.TRUE.equals(this.notZero(micro))){ // la parte de 'Boolean.TRUE.equals(...)' se usa para evitar el error NullPointerException,
            micro.run(operaciones);                    // ya que si el acumulador A esta vacio retornaria "null".
        }
    }

}
