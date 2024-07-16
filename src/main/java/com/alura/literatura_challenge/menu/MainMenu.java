package com.alura.literatura_challenge.menu;

import com.alura.literatura_challenge.repository.AuthorRepository;
import com.alura.literatura_challenge.repository.BookRepository;
import com.alura.literatura_challenge.service.RepositoryService;
import com.alura.literatura_challenge.service.ConnectionAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
public class MainMenu {
    private static Scanner sc = new Scanner(System.in);
    private static String api_url = "https://gutendex.com/books/";

    @Autowired
    private RepositoryService service;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void menuLista() {
        int option = -1;
        while (option != 0) {
            System.out.print("" +
                    "BIENVENIDO A LA LIBRERIA ALURA\n" +
                    "--------------------------------\n" +
                    "COMO DESEA INICIAR SU BUSQUEDA\n" +

                    "1. Buscar libros por titulo\n" +
                    "2. Mostrar todos los libros   \n" +
                    "3. Mostrar todos los autores\n" +
                    "4. Mostrar autores vivos en un año \n" +
                    "5. Mostrar libros por idioma \n" +
                    "0. Salir\n");

            option = manejoDelMenu.validar(sc);
            sc.nextLine();
            switch (option) {
                case 1:
                    libro();
                    break;
                case 2:
                    listaDeLibros();
                    break;
                case 3:
                    listDeAutores();
                    break;
                case 4:
                    autoresPorAño();
                    break;
                case 5:
                    librosPorLengua();
                    break;
                case 0:
                    System.out.println("Busqueda finalizada\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción invalida\n");
                    System.out.println();
            }
        }
    }

    private void libro() {
        System.out.println("Ingresar el título del libro que deseas buscar: \n");
        String bookTitle = sc.nextLine().toLowerCase();
        String encodedURL = api_url + "?search=" + URLEncoder.encode(bookTitle, StandardCharsets.UTF_8);
        String json = ConnectionAPI.getJsonData(encodedURL);
        service.encontrarLibros(json);
    }

    private void listaDeLibros() {
        service.encontrarTodosLosLibros();
    }

    private void listDeAutores() {
        service.encontrarPorAutor();
    }
    private void autoresPorAño() {
        System.out.println("Ingresa el año que deseas saber si un autor estuvo vivo: \n");
        int year = manejoDelMenu.validar(sc);
        service.obtenerAutorAño(year);
    }

    private void librosPorLengua() {
        System.out.println("Por favor ingrese el idioma que desee: \n");
        String lang = manejoDelMenu.validarPorLengua(sc);
        if (!lang.equals("N/A")) {
            service.discriminarPorLengua(lang);
        } else {
            System.out.println("---------------------------------------------------\n");
            System.out.println("Ese idioma no está registrado en nuestro programa\n");
        }
    }

}
