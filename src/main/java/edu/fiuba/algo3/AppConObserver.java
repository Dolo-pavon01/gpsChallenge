package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.visuales.VistaMapa;
import edu.fiuba.algo3.visuales.VistaVehiculo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AppConObserver extends Application {
    @Override
    public void start(Stage theStage) throws Exception {

        theStage.setTitle("Juego con observer");
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
