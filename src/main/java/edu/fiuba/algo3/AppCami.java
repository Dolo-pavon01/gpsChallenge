package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class AppCami extends Application {
    private Vehiculo vehiculo;

    public void start(Stage primaryStage) throws Exception {


        FileInputStream input=new FileInputStream("docs/auto.png");
        Image image = new Image(input);
        ImageView dibujoVehiculo=new ImageView(image);
        dibujoVehiculo.setPreserveRatio(true);
        dibujoVehiculo.setFitHeight(50);
        dibujoVehiculo.setY(100);


        FileInputStream input2=new FileInputStream("docs/imagenFondo.png");
        Image image1 = new Image(input2);
        ImageView fondo=new ImageView(image1);

        Group group = new Group(); //creating Group

        group.getChildren().addAll(fondo);
        group.getChildren().addAll(dibujoVehiculo);




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

        autoBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                 vehiculo = new Vehiculo(new Auto());
            }
        });
        motoBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Moto());
            }
        });
        auto4x4Btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                vehiculo = new Vehiculo(new Auto4x4());
            }
        });
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

        juego.setOnKeyPressed(event -> {
            dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
            switch (event.getCode()){
                case D:
                    dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                    dibujoVehiculo.setX(dibujoVehiculo.getX()+10);
                    dibujoVehiculo.setRotate(0);
                    gameplay.jugar('D');
                case A:
                    dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
                    dibujoVehiculo.setX(dibujoVehiculo.getX()-10);
                    dibujoVehiculo.setRotate(180);
                    gameplay.jugar('A');
                case W:
                    dibujoVehiculo.setY(dibujoVehiculo.getY()-10);
                    dibujoVehiculo.setRotate(270);
                    gameplay.jugar('W');
                case S:
                    dibujoVehiculo.setY(dibujoVehiculo.getY()+10);
                    dibujoVehiculo.setRotate(90);
                    gameplay.jugar('S');
                default:
                    break;
            }
        });

    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
