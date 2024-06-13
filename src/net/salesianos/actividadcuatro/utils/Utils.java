package net.salesianos.actividadcuatro.utils;

import net.salesianos.actividadcuatro.Mesa.Table;

import java.io.*;
import java.util.ArrayList;

public class Utils {
  private static final Console CONSOLE = System.console();
  private static final String PATH = "src/net/salesianos/actividadcuatro/in_out/Fichero.txt";
  private static boolean isEmpty;

  public static void saveTable() throws Exception {
    System.out.println("Introduce el color de tu mesita");
    String colour = CONSOLE.readLine();
    if (colour.isEmpty()) {
      colour = "Blanquita";
    }

    System.out.println("Introduzca ahora el numero de patas");
    Integer nLegs = Integer.parseInt(CONSOLE.readLine());

    final Table TABLE = new Table(colour, nLegs);

    final File FILE = new File(PATH);

    if (FILE.length() == 0) {
      isEmpty = true;
    } else {
      isEmpty = false;
    }

    final FileOutputStream FILE_OUTPUT = new FileOutputStream(FILE, true);
    final BufferedOutputStream BUFFERED_OUTPUT = new BufferedOutputStream(FILE_OUTPUT);
    final ObjectOutputStream OBJECT_OUTPUT = isEmpty ? new ObjectOutputStream(BUFFERED_OUTPUT)
        : new MyObjectOutputStream(BUFFERED_OUTPUT);

    try {
      OBJECT_OUTPUT.writeObject(TABLE);

    } catch (FileNotFoundException e) {
      System.out.println("ERROR no se ha encontrado el fichero");
    } catch (IOException e) {
      System.out.println("ERROR al acceso a la entrada/salida ");

    } finally {
      OBJECT_OUTPUT.close();
    }
  }

  public static void showTable() throws Exception {

    System.out.println("======MESAS=======");
    ArrayList<Table> tableList = new ArrayList<>();

    try {
      final FileInputStream FILE_INPUT = new FileInputStream(PATH);
      final BufferedInputStream BUFFERED_INPUT = new BufferedInputStream(FILE_INPUT);
      final ObjectInputStream OBJECT_INPUT = new ObjectInputStream(BUFFERED_INPUT);

      while (true) {
        try {
          Table table = (Table) OBJECT_INPUT.readObject();
          tableList.add(table);
        } catch (EOFException e) {
          break;
        }
      }
      OBJECT_INPUT.close();

    } catch (FileNotFoundException e) {
      System.out.println("ERROR no se ha encontrado el fichero");
    } catch (ClassNotFoundException e) {
      System.out.println("ERROR no se es capaz de deserializar correctamente el objeto");
    } catch (IOException e) {
      System.out.println("ERROR con los acceso de entrada/salida");

    }

    for (Table table : tableList) {
      System.out.println(table);
    }
  }

  private static class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) throws IOException {
      super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
  }

}