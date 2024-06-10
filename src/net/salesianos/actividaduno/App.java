package net.salesianos.actividaduno;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    boolean keepAsking = true;
    String path = "src/net/salesianos/actividaduno/output/Fichero.txt";
    File newFile = new File(path);

    final Scanner SCANNER = new Scanner(System.in);
    String userText = "";

    while (keepAsking) {
      System.out.println("Porfavor introduzca una cadena de texto de al menos 30 caracteres");
      userText = SCANNER.nextLine();
      if (userText.length() < 30) {
        System.out.println("Usted introdujo " + userText.length() + " caracteres, debe de colocar al menos "
            + (30 - userText.length()) + " caracteres");
      } else {
        System.out.println("-- TEXTO VALIDADO --");
        keepAsking = false;
      }
    }

    String newText = userText.toUpperCase().replaceAll(" ", "_");

    try {
      BufferedOutputStream writeFile = new BufferedOutputStream(new FileOutputStream(newFile));
      // https://www.baeldung.com/java-string-to-byte-array
      writeFile.write(newText.getBytes());
      System.out.println("El texto fue creado con exito");
      writeFile.close();
    } catch (IOException e) {
      System.out.println("Ocurrio un error al usar el buffer para escribir en el fichero");
    }

    SCANNER.close();
  }
}