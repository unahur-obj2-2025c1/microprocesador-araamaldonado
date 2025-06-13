package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD extends Command{
    
    private Integer sumaDeAcumuladores(Programable micro){
        return micro.getAcumuladorA() + micro.getAcumuladorB();
    }

    private void sumaYUbicarResultados(Programable micro){
        micro.setAcumuladorA(this.sumaDeAcumuladores(micro));
        micro.setAcumuladorB(0);
    }

    @Override
    public void doExecute(Programable micro) {
        this.sumaYUbicarResultados(micro);
    }

}
