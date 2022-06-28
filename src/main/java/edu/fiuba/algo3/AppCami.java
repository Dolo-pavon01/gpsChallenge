package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.*;

public class AppCami extends Application {
    private Vehiculo vehiculo;
    public void start(Stage primaryStage) throws Exception {

        vehiculo = new Vehiculo();

        TextField nombreInput = new TextField();
        nombreInput.setPromptText("Ingresar nombre del jugador");
        Label nombreJugador = new Label();

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
        Button comenzar =new Button("COMIENZA A JUGAR");
        VBox contenedorPrincipal = new VBox(nombreInput, etiquetaVehiculos, contenedorVehiculos, espacioVacio, contenedorDatos,comenzar);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));


        Scene inicio = new Scene(contenedorPrincipal, 300, 250);
        primaryStage.setTitle("");
        primaryStage.setScene(inicio);
        primaryStage.show();
        ImageView dibujoVehiculo=new ImageView();


        autoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Auto());
                try {
                    dibujoVehiculo.setImage(new Image(new FileInputStream("docs/Vehiculo_Auto.png")));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        motoBtn.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Moto());
                try {
                    dibujoVehiculo.setImage(new Image(new FileInputStream("docs/Vehiculo_Moto.png")));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });
          auto4x4Btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Auto4x4());
                try {
                    dibujoVehiculo.setImage(new Image(new FileInputStream("docs/Vehiculo_Auto4x4.png")));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        );
        ImageView fondo=new ImageView(new Image(new FileInputStream("docs/fondo.jpg")));

        dibujoVehiculo.setPreserveRatio(true);
        dibujoVehiculo.setFitHeight(50);
        dibujoVehiculo.setY(150);
        dibujoVehiculo.setX(100);

        ImageView piquete =new ImageView(new Image(new FileInputStream("docs/piquete.png")));
        piquete.setPreserveRatio(true);
        piquete.setFitHeight(50);
        piquete.setY(100);
        piquete.setX(100);

        Group group = new Group();
        group.getChildren().addAll(fondo);
        group.getChildren().addAll(dibujoVehiculo,piquete);

        nombreJugador.setLayoutX(200);
        nombreJugador.setLayoutY(200);
        nombreJugador.setTextFill(Color.BLACK);
        nombreJugador.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Label displayPuntaje = new Label();
        displayPuntaje.setText("Puntaje : 0");
        displayPuntaje.setLayoutX(200);
        displayPuntaje.setLayoutY(300);
        displayPuntaje.setTextFill(Color.BLACK);
        displayPuntaje.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Label displayPosicion = new Label();
        displayPosicion.setLayoutX(200);
        displayPosicion.setLayoutY(400);
        displayPosicion.setText("Posicion Actual: 10,10");
        displayPosicion.setTextFill(Color.BLACK);
        displayPosicion.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        group.getChildren().addAll(nombreJugador,displayPuntaje,displayPosicion);

        Scene juego = new Scene(group,500,500, Color.BLACK);
        Gameplay gameplay = new Gameplay(new BuilderPruebas(20));
        Label finDeJuego = new Label();
        finDeJuego.setTextFill(Color.WHITESMOKE);
        Group fin = new Group(finDeJuego);
        Scene pantallaFinal = new Scene(fin,500,500, Color.BLACK);
        comenzar.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent arg0) {
                nombreJugador.setText("Jugador: " + nombreInput.getText());
                gameplay.iniciarJuego(vehiculo);
                primaryStage.setScene(juego);
            }
        });

        juego.setOnKeyPressed(KeyEvent-> {
            dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
            if(gameplay.jugar(KeyEvent.getCode().toString()))
            {
            switch (KeyEvent.getCode()){
                case D:

                        dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                        dibujoVehiculo.setX(dibujoVehiculo.getX()+10);
                        dibujoVehiculo.setRotate(0);
                        break;
                case A:

                        dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                        dibujoVehiculo.setX(dibujoVehiculo.getX()-10);
                        dibujoVehiculo.setRotate(180);
                        break;
                case W:

                        dibujoVehiculo.setY(dibujoVehiculo.getY()-10);
                        dibujoVehiculo.setRotate(270);
                        break;
                case S:

                        dibujoVehiculo.setY(dibujoVehiculo.getY()+10);
                        dibujoVehiculo.setRotate(90);
                        break;
                default:
                    break;

            }
            displayPuntaje.setText("Puntaje: " + gameplay.puntaje());
            displayPosicion.setText("Posicion Actual: " + gameplay.posicionJugador());
        }

            if(gameplay.llegoAMeta())
            {
                finDeJuego.setText("TERMINASTE EL JUEGO " + nombreJugador.getText() + " CON UN PUNTAJE DE  " + displayPuntaje.getText());
                primaryStage.setScene(pantallaFinal);
            }
        });



    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
