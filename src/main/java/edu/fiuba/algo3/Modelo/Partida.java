package edu.fiuba.algo3.Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
  private ArrayList<String> podio = new ArrayList<String>();

  public ArrayList<String> actualizarPodio(String nickname, Integer puntaje) {

    this.leer_archivo();
    this.podio_viejo.add(nickname + ";" + puntaje);
    this.escribir_archivo();
    this.podio_viejo = new ArrayList<String>();
    this.leer_archivo();
    return this.podio;
  }

  public void leer_archivo() {
    try {
      File myObj = new File("src/main/java/edu/fiuba/algo3/rankings.txt");
      Scanner myReader = new Scanner(myObj);
      int i =0;
      while (myReader.hasNextLine() && i <= 6) {
        String data = myReader.nextLine();
        this.podio_viejo.add(data.replaceAll("\\n", ""));
        i++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
    }
  }

  private void escribir_archivo() {
    try {
      FileWriter myWriter = new FileWriter("src/main/java/edu/fiuba/algo3/rankings.txt");
      for (int i = 0; i < this.podio_viejo.size(); i++) {
        myWriter.write( this.podio_viejo.get(this.podio_viejo.size() - 1 - i) + "\n");
      }
      myWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
