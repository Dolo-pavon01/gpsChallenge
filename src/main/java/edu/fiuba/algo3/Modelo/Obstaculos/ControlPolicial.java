package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;

import java.util.Random;

public class ControlPolicial implements Obstaculo {
  private static final int PROBABILIDAD_MOTO = 8;
  private static final int PROBABILIDAD_AUTO = 5;
  private static final int PROBABILIDAD_AUTO4x4 = 3;
  private static final int LIMITE = 10;
  private static final int MULTA = 3;
  private Random randomizador;
  private final String NOMBRE = "controlPolicial";

  public ControlPolicial() {
    this.randomizador = new Random();
  }

  public ControlPolicial(Random randomizador) {
    this.randomizador = randomizador;
  }

  private int multar(int probabilidad) {
    if (this.randomizador.nextInt(LIMITE) > probabilidad) return 0;
    return MULTA;
  }

  @Override
  public String nombreObstaculo() {
    return "controlPolicial";
  }

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + ";" + NOMBRE;
  }

  @Override
  public int visit(Moto moto) {
    return this.multar(PROBABILIDAD_MOTO);
  }

  @Override
  public int visit(Auto4x4 auto4x4) {
    return this.multar(PROBABILIDAD_AUTO4x4);
  }

  @Override
  public int visit(Auto auto) {
    return this.multar(PROBABILIDAD_AUTO);
  }
}
