package edu.fiuba.algo3.Modelo.mocks;

import edu.fiuba.algo3.Modelo.Gameplay;
import edu.fiuba.algo3.Modelo.MapaBuilder;
import edu.fiuba.algo3.Modelo.Partida;
import edu.fiuba.algo3.Modelo.Vehiculo.Mapa;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;


public class GameplayMock extends Gameplay {
    private static GameplayMock instancia;
    private GameplayMock() {

    }
    public static GameplayMock getInstance(MapaBuilder mapaBuilder) {
        if (instancia == null) {
            instancia = new GameplayMock();
        }
        instancia.setBuilder(mapaBuilder);
        return instancia;
    }

    private void setBuilder(MapaBuilder mapaBuilder) {

        this.mapa = mapaBuilder.getMapa();
    }
    public void iniciarJuego(Vehiculo vehiculo) {
        this.vehiculoEnJuego = vehiculo;
    }

    public String posicionJugador() {
        return this.vehiculoEnJuego.posicionComoString();
    }


}
