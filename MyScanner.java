// MyScanner.java

import java.util.Scanner;

public class MyScanner {
    public static String getInput() {
        String utmatning = "Hello and welcome! Enter your words here:";
        System.out.println(utmatning);
        Scanner scanner = null;
        String rawinput = "";
        try {
            Scanner scanner = new Scanner(System.in);
            String rawinput = scanner.nextLine();
            // Stoppa bufferoverrun
            if (rawinput.length() > 1000) {
                rawinput = rawinput.substring(0, 1000);
            }
            // Kontrollera att )DROP.TABLE eller liknande specialtecken kommer igenom
            if (!rawinput.matches("[a-zA-Z0-9 ]*")) {
                throw new IllegalArgumentException("Ogiltig input");
            }
        } catch (Exception e) {
            System.err.println("Ett fel uppstod: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();  // Städa upp. Ett problem kan vara att metoden kan anropas många gånger efter varandra.
            }
        }
        System.out.println(rawinput);
        return rawinput;
    }
}