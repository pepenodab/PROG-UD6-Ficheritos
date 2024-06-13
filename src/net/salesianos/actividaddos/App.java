package net.salesianos.actividaddos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class App {
  public static void main(String[] args) {
    final String PATH = "src/net/salesianos/actividaddos/input/Rebeldia.txt";
    try {
      final BufferedReader BUFFERED_READER = new BufferedReader(new FileReader(PATH));
      int byteNumber = BUFFERED_READER.read();
      while (byteNumber != -1) {
        System.out.print(((char) byteNumber) + "__" + (byteNumber) + ", ");
        byteNumber = BUFFERED_READER.read();
      }
      BUFFERED_READER.close();
    } catch (IOException e) {
      System.out.println("ERROR al acceso de entrada/salida estandar");
    }

  }
}
