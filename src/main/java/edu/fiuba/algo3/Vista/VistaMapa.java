package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorMovimientos;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VistaMapa {
  /*
      Implementa la vista del mapa con:
          -Obstaculos
          -Vehiculo
          -Meta
          -Manzanas
          -Calles
       utiliza el controlador de interacciones entre el usuario
       y el mapa.
  */
  private Stage stage;
  public Random randoNumber = new Random();
  private double startMapX = 0;
  private double startMapY = 50;
  private double widthMap = Toolkit.getDefaultToolkit().getScreenSize().width;
  private double heightMap = this.widthMap / 2;
  private ImageView dibujoVehiculo;
  private double AnchoAltoMatriz;
  private int callesEnY;
  private double altoCalle;
  private double altoAnchoCuadra;
  private int callesEnX;
  private List elements = new ArrayList();
  private Group group = new Group();
  private Rectangle capa;
  private Circle circle;
  private Shape filtro;

  private double metaX;
  private double metaY;
  private Circle meta;

  private ControladorMovimientos controladorMovimientos = new ControladorMovimientos();

  public VistaMapa(Stage stage) throws Exception {
    this.stage = stage;
  }

  public void mostrarVistaMapa() throws Exception {
    Rectangle rect = this.rectangule(this.startMapX, this.startMapY, this.widthMap, this.heightMap);
    rect.setFill(Color.RED);
    int random = this.controladorMovimientos.getDimension();

    int cantidadMatrices = random / 2;
    this.elements.add(rect);
    this.AnchoAltoMatriz = this.heightMap / cantidadMatrices;
    this.altoAnchoCuadra = this.AnchoAltoMatriz / 3; //
    this.altoCalle = this.altoAnchoCuadra / 2;
    this.callesEnY = random;
    this.callesEnX = this.callesEnY * 2;

    for (double i = this.startMapX; i < (this.widthMap + this.startMapX); i += AnchoAltoMatriz) {

      this.dibujarMatriz(
          i, this.startMapY, this.AnchoAltoMatriz, this.altoAnchoCuadra, this.altoCalle);
      for (double y = this.startMapY; y < (this.heightMap); y += this.AnchoAltoMatriz) {
        this.dibujarMatriz(i, y, AnchoAltoMatriz, this.altoAnchoCuadra, this.altoCalle);
      }
    }

    this.dibujarObstaculos();
    this.dibujarSorpresas();

    this.dibujarVehiculo();

    Scene scene =
        new Scene(this.group, this.widthMap, this.heightMap + this.startMapY, Color.LIGHTPINK);
    this.stage.setMaximized(true);

    this.dibujarMeta("asas");
    this.dibujarCapa();
    this.group.getChildren().addAll(this.elements);
    this.stage.setScene(scene);
    this.stage.show();

    scene.setOnKeyPressed(
        KeyEvent -> {
          KeyCode code = KeyEvent.getCode();
          char direccion = (code.toString()).toLowerCase().charAt(0);
          if (this.controladorMovimientos.evento(direccion)) {
            this.dibujarSecuencia(direccion);
          }
          System.out.println(direccion);
          if (this.controladorMovimientos.partidaCerrada()) {
            new VistaFinal(this.stage).mostrarVistaFinal();
          }
          try {
            this.setImage(this.dibujoVehiculo, controladorMovimientos.vehiculo());
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        });
  }

  public void dibujarCapa() {

    this.capa = this.rectangule(this.startMapX, this.startMapY, this.widthMap, this.heightMap);
    this.circle = new Circle();
    this.circle.setCenterY(this.dibujoVehiculo.getY());
    this.circle.setCenterX(this.dibujoVehiculo.getX());
    this.circle.setRadius(this.AnchoAltoMatriz);
    this.filtro = Shape.subtract(this.capa, this.circle);


    Circle  meta = new Circle();
    meta.setCenterX(this.metaX);
    meta.setCenterY(this.metaY);
    meta.setRadius(this.altoAnchoCuadra /2);
    this.meta = meta;
    this.filtro = Shape.subtract(this.filtro, meta);
    this.elements.add(filtro);
  }

  public void setImage(ImageView imagen, String entidad) throws Exception {
    imagen.setImage(new Image(new FileInputStream("docs/" + entidad + ".png")));
  }

  public void dibujarMeta(String meta) throws Exception {
    String posicion = this.controladorMovimientos.meta();
    String[] coordenadas = posicion.split(";");
    int x = Integer.parseInt(coordenadas[0]);
    int y = Integer.parseInt(coordenadas[1]);


    /* int x = 0;
    int y = this.callesEnY / 2;
     */
    double techo = (Math.round((this.callesEnY - y) / 2) * this.AnchoAltoMatriz) + this.startMapY;

    double startY = techo;
    if (y % 2 == 0) {
      startY += 0;
    } else {
      startY += this.altoCalle + this.altoAnchoCuadra;
    }
    this.metaX= (this.widthMap - this.altoCalle)  ;
    this.metaY= startY + 10;
    this.imagen(
        this.widthMap - this.altoCalle,
        startY,
        this.altoCalle,
        this.altoCalle,
        "docs/" + coordenadas[2] + ".png");
  }

  public void dibujarVehiculo() throws Exception {

    String vehiculo = this.controladorMovimientos.vehiculo();

    int x = 0;
    int y = this.callesEnY / 2;
    double techo = (Math.round((this.callesEnY - y) / 2) * this.AnchoAltoMatriz) + this.startMapY;

    double startY = techo;
    if (y % 2 == 0) {
      startY += 0;
    } else {
      startY += this.altoCalle + this.altoAnchoCuadra;
    }

    this.dibujoVehiculo =
        this.imagen(
            this.startMapX, startY, this.altoCalle, this.altoCalle, "docs/" + vehiculo + ".png");
  }

  public void dibujarMatriz(double startX, double startY, double m, double t, double p)
      throws Exception {
    Integer counter = 0;
    Rectangle calle1 = this.rectangule(startX, startY, m, p);
    calle1.setFill(Color.WHITE);

    Rectangle calle2 = this.rectangule(startX, startY + p, p, m - (p));
    calle2.setFill(Color.WHITE);

    Rectangle Manzana1 = this.rectangule(startX + p, startY + p, t, t);
    Manzana1.setFill(Color.LIGHTBLUE);

    Rectangle calle3 = this.rectangule(startX + p + t, startY + p, p, t);
    calle3.setFill(Color.WHITE);

    Rectangle Manzana2 = this.rectangule(startX + p + t + p, startY + p, t, t);
    Manzana2.setFill(Color.LIGHTBLUE);

    Rectangle calle4 = this.rectangule(startX + p + t + p + t, startY + p, p, m - (2 * p));
    calle4.setFill(Color.WHITE);
    Rectangle calle5 = this.rectangule(startX + p, startY + p + t, m - (p), p);
    calle5.setFill(Color.WHITE);

    Rectangle Manzana3 = this.rectangule(startX + p, startY + p + t + p, t, t);
    Manzana3.setFill(Color.LIGHTBLUE);

    Rectangle calle6 = this.rectangule(startX + p + t, startY + p + t + p, p, t);
    calle6.setFill(Color.WHITE);
    Rectangle Manzana4 = this.rectangule(startX + p + t + p, startY + p + t + p, t, t);
    Manzana4.setFill(Color.LIGHTBLUE);

    Rectangle calle7 = this.rectangule(startX, startY + p + t + p + t, m, p);
    calle7.setFill(Color.WHITE);

    this.elements.add(calle1);
    this.elements.add(calle2);
    this.elements.add(calle3);
    // this.elements.add(calle4);
    this.elements.add(calle5);
    this.elements.add(calle6);
    // this.elements.add(calle7);
    this.elements.add(Manzana1);
    this.elements.add(Manzana2);
    this.elements.add(Manzana3);
    this.elements.add(Manzana4);

    int randomImage = new Random().nextInt(13) + 1;

    this.imagen(startX + p, startY + p, t, t, "docs/ED" + randomImage + ".png");
    this.imagen(startX + p + t + p, startY + p, t, t, "docs/ED" + (randomImage + 1) + ".png");
    this.imagen(startX + p, startY + p + t + p, t, t, "docs/ED" + (randomImage + 2) + ".png");
    this.imagen(
        startX + p + t + p, startY + p + t + p, t, t, "docs/ED" + (randomImage + 3) + ".png");

    this.imagen(startX, startY, m, p, "docs/calle.png");
    this.imagen(startX, startY, p, m, "docs/calle2.png");
    this.imagen(startX + p + t, startY + p, p, t + p + t, "docs/calle2.png");
    this.imagen(startX, startY + p + t, m, p, "docs/calle.png");
  }

  public ImageView imagen(double startX, double startY, double m, double p, String path)
      throws Exception {
    FileInputStream input = new FileInputStream(path);
    Image image_calle = new Image(input);
    ImageView imageView1 = new ImageView();
    imageView1.setImage(image_calle);
    imageView1.setX(startX);
    imageView1.setY(startY);
    imageView1.setFitWidth(m);
    imageView1.setFitHeight(p);
    this.elements.add(imageView1);
    return imageView1;
  }

  public Rectangle rectangule(double x, double y, double w, double h) {
    Rectangle rect = new Rectangle();
    rect.setX(x);
    rect.setY(y);
    rect.setWidth(w);
    rect.setHeight(h);

    return rect;
  }

  public void dibujarObstaculos() throws Exception {

    ArrayList<String> obstaculos = this.controladorMovimientos.getObstaculos();

    for (int i = 0; i < obstaculos.size(); i++) {
      String[] strings = obstaculos.get(i).split(";");
      int x = Integer.parseInt(strings[0]);
      int y = Integer.parseInt(strings[1]);
      String entidad = strings[2];
      this.dibujarObstaculo(entidad, x, y);
    }
  }

  public void dibujarSorpresas() throws Exception {
    ArrayList<String> obstaculos = this.controladorMovimientos.getSorpresas();
    for (int i = 0; i < obstaculos.size(); i++) {
      String[] strings = obstaculos.get(i).split(";");
      int x = Integer.parseInt(strings[0]);
      int y = Integer.parseInt(strings[1]);
      this.dibujarSorpresa(x, y, strings[2]);
    }
  }

  public void dibujarSorpresa(int x, int y, String entidad) throws Exception {
    int coordenadaY = y;
    int coordenadaX = x;

    int cantidadCallesY = this.callesEnY;
    int cantidadCallesX = this.callesEnX;

    double techo =
        (Math.round((cantidadCallesY - coordenadaY) / 2) * this.AnchoAltoMatriz) + this.startMapY;

    double startY = techo;
    if (coordenadaY % 2 == 0) {
      startY += 0;
    } else {
      startY += this.altoCalle + this.altoAnchoCuadra;
    }

    double costado =
        (Math.round((cantidadCallesX - (cantidadCallesX - coordenadaX)) / 2)
            * this.AnchoAltoMatriz);
    double startX = costado + this.startMapX;

    if (coordenadaX % 2 == 0 & coordenadaX > 0) {
      startX -= ((this.altoCalle + this.altoAnchoCuadra) / 2);
    } else if (coordenadaX > 0) {
      startX += ((this.altoCalle + this.altoAnchoCuadra) / 2);
    }

    this.imagen(startX, startY, this.altoCalle, this.altoCalle, "docs/" + entidad + ".png");
  }

  public void dibujarObstaculo(String entidad, int x, int y) throws Exception {
    int coordenadaY = y;
    int coordenadaX = x;

    int cantidadCallesY = this.callesEnY;
    int cantidadCallesX = this.callesEnX;

    double techo =
        (Math.round((cantidadCallesY - coordenadaY) / 2) * this.AnchoAltoMatriz) + this.startMapY;

    double startY = techo;
    if (coordenadaY % 2 == 0) {
      startY += 0;
    } else {
      startY += this.altoCalle + this.altoAnchoCuadra;
    }

    double costado =
        (Math.round((cantidadCallesX - (cantidadCallesX - coordenadaX)) / 2)
            * this.AnchoAltoMatriz);
    double startX = costado + this.startMapX;

    if (coordenadaX % 2 == 0 & coordenadaX > 0) {
      startX += 0;
    } else if (coordenadaX > 0) {
      startX += this.altoCalle + this.altoAnchoCuadra;
    }

    this.imagen(startX, startY, this.altoCalle, this.altoCalle, "docs/" + entidad + ".png");
  }

  public void dibujarSecuencia(char direccion) {

    this.dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
    this.group.getChildren().remove(this.filtro);
    double movimiento = this.altoAnchoCuadra + this.altoCalle;
    switch (direccion) {
      case 'd': // r en mac d window
        this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
        this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() + movimiento);
        this.dibujoVehiculo.setRotate(0);
        break;
      case 'a': // l en mac a W
        this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
        this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() - movimiento);
        this.dibujoVehiculo.setRotate(180);
        break;
      case 'w': // u en mac w W
        this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() - movimiento);
        this.dibujoVehiculo.setRotate(270);
        break;
      case 's': // d en mac s W
        this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() + movimiento);
        this.dibujoVehiculo.setRotate(90);
        break;
      default:
        break;
    }

    this.circle.setCenterY(this.dibujoVehiculo.getY());
    this.circle.setCenterX(this.dibujoVehiculo.getX());

    this.filtro = Shape.subtract(this.capa, this.circle);
    this.filtro = Shape.subtract(this.filtro, this.meta);
    this.group.getChildren().add(this.filtro);
  }
}
