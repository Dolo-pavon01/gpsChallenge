package edu.fiuba.algo3.modelo;

public interface Vehiculo {

     int pasarPor(Piquete piquete);
     int pasarPor(Pozo pozo);
     void moverse (Posicion posicion);
    Posicion getPosicion();
}
