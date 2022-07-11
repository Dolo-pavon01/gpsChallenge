package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.VistaFinal;
import edu.fiuba.algo3.Vista.VistaInicial;
import edu.fiuba.algo3.Vista.VistaMapa;
import edu.fiuba.algo3.Controlador.ControladorSonido;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

import java.io.File;

public class AppGpsChallenge extends Application {

  private Stage primaryStage;
  private ControladorSonido sound;

  public void start(Stage primaryStage) throws Exception {

    this.primaryStage = primaryStage;
    this.sound = new ControladorSonido();
    sound.playHitSound("docs/sonido.mp3");


    VistaInicial vistaInicial = new VistaInicial(primaryStage);
    vistaInicial.mostrarVistaInicial();


  }

  public static void main(String[] args) {
    launch(args);
  }
}
