package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {
    @Test
    public void seCreaUnaGrillaValida()
    {
        //arrange
        Gameplay gameplay = new Gameplay(new BuilderPruebas(20));
        gameplay.iniciarJuego(new Vehiculo(new Auto()));

        //act
        gameplay.jugar('d');

        //assert
        assertEquals(4,gameplay.puntaje()); // hay un pozo y es un auto
    }
    @Test
    public void noPuedeAvanzarSiHayPared()
    {
        //arrange
        Gameplay gameplay = new Gameplay(new BuilderPruebas(20));
        gameplay.iniciarJuego(new Vehiculo(new Auto()));

        //act
        gameplay.jugar('s'); //no se mueve //en 1,1 no hay nada
        gameplay.jugar('d'); // se choca con pozo en 2,1


        //assert
        assertEquals(4,gameplay.puntaje()); // hay un pozo y es un auto
    }
  
    // act
    gameplay.jugar('d');

    // assert
    assertEquals(4, gameplay.puntaje()); // hay un pozo y es un auto
  }
}
