package edu.fiuba.algo3.modelo;

public interface Movible {
    public void trasladar(int x, int y);

    void pasarPor(Penalizador obstaculo);
}
