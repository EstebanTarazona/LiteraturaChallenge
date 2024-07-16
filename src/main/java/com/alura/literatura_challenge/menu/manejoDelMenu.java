package com.alura.literatura_challenge.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class manejoDelMenu {
    public static int validar(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Solo se aceptan números para operar el menu\n");
                sc.nextLine();
                System.out.println("Vuelve a ingresar la opción: \n");

            }
        }
    }

    public static String validarPorLengua(Scanner sc) {
        String lang = sc.nextLine();
        while (true) {
            if (!lang.isBlank()) {
                switch (lang.toLowerCase().replace(" ", "")) {
                    case "español":
                        return "es";
                    case "ingles":
                        return "en";
                    case "frances":
                        return "fr";
                    default:
                        return "N/A";
                }
            } else {
                System.out.println("Debes escribir [español, ingles, frances] para obtener los libros listados por idioma\n");
                lang = sc.nextLine();
            }
        }
    }
    public static String getLengua(String langCode){
        switch (langCode.toLowerCase().replace(" ", "")) {
            case "es":
                return "Español";
            case "en":
                return "Inglés";
            case "fr":
                return "Francés";
            default:
                return "N/A";
        }
    }
}
