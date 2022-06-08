package edu.fiuba.algo3.modelo;

public interface Penalizador {
    public int penalizarA(Auto auto);
    public int penalizarA(Moto moto);
    public int penalizarA(Auto4x4 auto4x4);
    public boolean esMismaPosicion(Posicion unaPosicion);

    }
}
