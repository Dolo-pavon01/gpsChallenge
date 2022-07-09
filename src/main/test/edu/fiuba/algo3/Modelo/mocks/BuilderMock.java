package edu.fiuba.algo3.Modelo.mocks;

import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.MapaBuilder;
import edu.fiuba.algo3.Modelo.Posicion;

public class BuilderMock extends MapaBuilder {


    public BuilderMock(int alto, int ancho) {
        super(alto,ancho);
        this.meta = Posicion.getPosicion(9,5);
        this.mapa = new Mapa(this.obstaculos, this.sorpresas, this.meta,this.alto,this.ancho);
    }

    public Mapa getMapa()
    {
        return this.mapa;
    }


}
