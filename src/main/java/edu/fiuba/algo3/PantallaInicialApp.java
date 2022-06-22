package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaInicialApp extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Pantalla Inicio");

    TextField nombreInput = new TextField();
    nombreInput.setPromptText("Ingresar nombre del jugador");

    Label etiquetaVehiculos = new Label();
    etiquetaVehiculos.setText("Elija su vehículo");

    Button motoBtn = new Button();
    motoBtn.setText("Moto");

    Button autoBtn = new Button();
    autoBtn.setText("Auto");

    Button auto4x4Btn = new Button();
    auto4x4Btn.setText("Auto 4x4");

    HBox contenedorVehiculos = new HBox(motoBtn, autoBtn, auto4x4Btn);
    contenedorVehiculos.setSpacing(10);

    Label espacioVacio = new Label();

    Button enviarBtn = new Button();
    enviarBtn.setText("Enviar");

    Button limpiarBtn = new Button();
    limpiarBtn.setText("Limpiar");

    HBox contenedorDatos = new HBox(enviarBtn, limpiarBtn);
    contenedorDatos.setSpacing(10);

    VBox contenedorPrincipal =
        new VBox(
            nombreInput, etiquetaVehiculos, contenedorVehiculos, espacioVacio, contenedorDatos);
    contenedorPrincipal.setSpacing(10);
    contenedorPrincipal.setPadding(new Insets(20));

    Scene scene = new Scene(contenedorPrincipal, 300, 250);
    stage.setScene(scene);
    stage.show();
  }
}
