package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Vista.VistaMapa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppConObserver extends Application {
    @Override
    public void start(Stage theStage) throws Exception {

        theStage.setTitle("Juego con observer");
        Mapa mapa = new Mapa();
        VistaMapa vistaMapa = new VistaMapa();
        Scene ciudad = new Scene(vistaMapa,1200,600, Color.BLACK);
        theStage.setScene(ciudad);
        theStage.show();
    }

    public static void main (String[] args)
    {
        launch(args);
    }
}
