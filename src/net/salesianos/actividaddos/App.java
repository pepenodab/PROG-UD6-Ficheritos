package net.salesianos.actividaddos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        String path = "./src/net/salesianos/actividaddos/output/testazo.txt";
        
        try {
            BufferedReader leerFicheraso = new BufferedReader(new FileReader(path));
            int asciiNumber = leerFicheraso.read();
            while (asciiNumber != -1) {
                System.out.print(((char)asciiNumber + "__" + (asciiNumber) + ", "));
                asciiNumber = leerFicheraso.read();
            }
            leerFicheraso.close();
        } catch (IOException e) {
            System.out.println("ta mal");
        }
    }
}
