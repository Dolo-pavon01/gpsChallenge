package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrillaTest {
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
}
