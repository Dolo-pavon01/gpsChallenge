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
    private String nombrearchivoVehiculo;
    public void start(Stage primaryStage) throws Exception {

        vehiculo = new Vehiculo();

        TextField nombreInput = new TextField();
        nombreInput.setPromptText("Ingresar nombre del jugador");
       // String nombreUsuario = nombreInput.getText();

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
        VBox contenedorPrincipal =
                new VBox(
                        nombreInput, etiquetaVehiculos, contenedorVehiculos, espacioVacio, contenedorDatos,comenzar);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));


        Scene inicio = new Scene(contenedorPrincipal, 300, 250);
        primaryStage.setTitle("");
        primaryStage.setScene(inicio);
        primaryStage.show();
        Group group = new Group();


        autoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                    vehiculo = new Vehiculo(new Auto());
                    nombrearchivoVehiculo = "docs/Vehiculo_Auto.png";

            }
        });
        motoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Moto());
                nombrearchivoVehiculo = "docs/Vehiculo_Moto";

            }
        });
        auto4x4Btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Auto4x4());
                nombrearchivoVehiculo = "docs/Vehiculo_Auto4x4";
            }
        }
        );

        FileInputStream input=new FileInputStream(nombrearchivoVehiculo);
        Image image = new Image(input);
        ImageView dibujoVehiculo=new ImageView(image);
        dibujoVehiculo.setPreserveRatio(true);
        dibujoVehiculo.setFitHeight(50);
        dibujoVehiculo.setY(100);
        group.getChildren().addAll(dibujoVehiculo);

        FileInputStream input2=new FileInputStream("docs/fondo.jpg");
        Image image1 = new Image(input2);
        ImageView fondo=new ImageView(image1);

         //creating Group

        group.getChildren().addAll(fondo);

        Label displayPuntaje = new Label();
        displayPuntaje.setText("0");
        displayPuntaje.setLayoutX(200);
        displayPuntaje.setLayoutY(300);
        displayPuntaje.setTextFill(Color.BLACK);
        group.getChildren().addAll(displayPuntaje);

        Label displayPosicion = new Label();
        displayPosicion.setText("10,10");
        displayPosicion.setLayoutX(200);
        displayPosicion.setLayoutY(400);
        displayPosicion.setTextFill(Color.BLACK);
        group.getChildren().addAll(displayPosicion);


        Scene juego = new Scene(group,500,500, Color.BLACK);
        Gameplay gameplay = new Gameplay(new BuilderPruebas(20));
        comenzar.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent arg0) {
                gameplay.iniciarJuego(vehiculo);
                primaryStage.setScene(juego);
            }
        });

       gameplay.iniciarJuego(vehiculo);
        juego.setOnKeyPressed(KeyEvent-> {
            dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
            switch (KeyEvent.getCode()){
                case D:
                    if(gameplay.jugar('d'))
                    {
                        dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                        dibujoVehiculo.setX(dibujoVehiculo.getX()+10);
                        dibujoVehiculo.setRotate(0);
                    }
                    break;
                case A:
                    if(gameplay.jugar('a'))
                    {
                        dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                        dibujoVehiculo.setX(dibujoVehiculo.getX()-10);
                        dibujoVehiculo.setRotate(180);
                    }
                    break;
                case W:
                    if(gameplay.jugar('w'))
                    {
                        dibujoVehiculo.setY(dibujoVehiculo.getY()-10);
                        dibujoVehiculo.setRotate(270);
                    }
                    break;
                case S:
                    if(gameplay.jugar('s'))
                    {
                        dibujoVehiculo.setY(dibujoVehiculo.getY()+10);
                        dibujoVehiculo.setRotate(90);
                    }
                    break;
                default:
                    break;
            }
            displayPuntaje.setText(Integer.toString(gameplay.puntaje()));
            displayPosicion.setText(gameplay.posicionJugador());
        });


    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
