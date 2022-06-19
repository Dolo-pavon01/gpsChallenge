package edu.fiuba.algo3.modelo;

public class BuilderPruebas {
    private int tamanio;
    public BuilderPruebas(int tamanio)
    {
        this.tamanio = tamanio;
    }
    public Grilla crearGameplay()
    {
        Grilla grilla = new Grilla();
        for(int i = 1;i< tamanio/3;i++)
        {
            Posicion p =Posicion.getPosicion(i,0);
            grilla.obstaculos.put(p,new Pozo());
        }
        for(int i = 1;i< tamanio/3;i++)
        {
            Posicion p =Posicion.getPosicion(0,i);
            grilla.obstaculos.put(p,new Piquete());
        }
        for(int i = 2;i< tamanio/3;i++)
        {
            Posicion p =Posicion.getPosicion(i,i);
            grilla.obstaculos.put(p,new ControlPolicial());
        }

        for(int i = 2;i< tamanio/5;i++)
        {
            Posicion p =Posicion.getPosicion(i,i+1);
            grilla.sorpresas.put(p,new SorpresaCambioVehiculo());
        }
        for(int i = 3;i< tamanio/5;i++)
        {
            Posicion p =Posicion.getPosicion(i,i-1);
            grilla.sorpresas.put(p,new SorpresaFavorable());
        }
        for(int i = 4;i< tamanio/5;i++)
    {
        Posicion p =Posicion.getPosicion(i,i+2);
        grilla.sorpresas.put(p,new SorpresaDesfavorable());
    }
        return grilla;
    }
}
