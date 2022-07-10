package edu.fiuba.algo3.Modelo.Obstaculos;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;

public interface Obstaculo {

  String nombreObstaculo();
  int visit(Moto moto);

  int visit(Auto4x4 auto4x4);

  int visit(Auto auto);
}
