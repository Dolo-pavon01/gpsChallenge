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

        Translate arriba = new Translate();
        arriba.setX(20);

        Translate abajo = new Translate();
        abajo.setX(-20);

        Translate derecha = new Translate();
        derecha.setX(20);

        Translate izquierda = new Translate();
        izquierda.setX(20);

        Rotate haciaArriba = new Rotate();
        haciaArriba.setAngle(90);

        Rotate haciaAbajo = new Rotate();
        haciaAbajo.setAngle(90);
        haciaAbajo.setPivotX(20);
        haciaAbajo.setPivotY(20);

        juego.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.D) {
                int p = gameplay.puntaje();
                gameplay.jugar('d');
                if (p != gameplay.puntaje())
                    dibujoVehiculo.getTransforms().addAll(derecha,haciaArriba);
            }
            });

        juego.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.A) {
                int p = gameplay.puntaje();
                gameplay.jugar('a');
                if(p != gameplay.puntaje())
                    dibujoVehiculo.getTransforms().addAll(izquierda,haciaAbajo);
            }
        });

        juego.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.W) {
                int p = gameplay.puntaje();
                gameplay.jugar('w');
                if(p != gameplay.puntaje())
                    dibujoVehiculo.getTransforms().addAll(arriba);
            }
        });

        juego.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.S) {
                int p = gameplay.puntaje();
                gameplay.jugar('s');
                if(p != gameplay.puntaje())
                    dibujoVehiculo.getTransforms().addAll(abajo);

            }
        });

    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
