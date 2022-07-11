package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Modelo.Gameplay;
import edu.fiuba.algo3.Modelo.MapaBuilder;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;

public class ControladorOpciones implements EventHandler<ActionEvent> {


  private String nickname;
  private String tipoVehiculo;

  public ControladorOpciones(String nickName, String tipoVehiculo) {
    this.nickname = nickName;
    this.tipoVehiculo = tipoVehiculo;
    handle(new ActionEvent());
  }

  @Override
  public void handle(ActionEvent event) {

    Gameplay.getInstance().registrarUsuario(this.nickname, this.tipoVehiculo);
  }
}
