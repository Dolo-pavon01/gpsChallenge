package edu.fiuba.algo3.Modelo;

import java.util.HashMap;

public class CreadorParedes implements Creador {

  public HashMap crear(int largo,int ancho) {
    HashMap paredes = new HashMap<>(10, 70);

    //this.generador(largo,-1,paredes);

    //this.generador(ancho,largo);
    for (int i = 0; i < ancho; i++) {
      Posicion p = Posicion.getPosicion(i, -1);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < largo; i++) {
      Posicion p = Posicion.getPosicion(ancho, i);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < ancho; i++) {
      Posicion p = Posicion.getPosicion(i, largo);
      paredes.put(p, new Pared());
    }
    return paredes;
  }
  /*
  public void prueba(int alto)
  {
    for (int i = 0; i <= alto; i++)
    {
      pared en (0,i) vertical de la izquierda
    }

    for (int i = 0; i <= alto*2 (ancho); i++)
    {
      pared en (i,0) horizontal  de abajo
    }

    inicia en (0,alto/2)

    for (int i = 0; i <= alto*2 (ancho); i++)
    {
      pared en (i,alto)  horizontal de arriba
    }

    for (int i = 0; i <= alto; i++)
    {
      pared en (alto*2,i)  vertical de izquierda
    }
  }


  private void generador(int largo, int ancho, HashMap<>paredes){

    for(int i=0; i < largo ; i++){
      Posicion p = Posicion.getPosicion(-1, i);
      paredes.put(p, new Pared());
    }


  }

   */

}
