package edu.fiuba.algo3.modelo;

public interface Vehiculo {

     int pasarPor(Piquete piquete);
     int pasarPor(Pozo pozo);
    Posicion getPosicionSiguiente(char unaDireccion);
}
