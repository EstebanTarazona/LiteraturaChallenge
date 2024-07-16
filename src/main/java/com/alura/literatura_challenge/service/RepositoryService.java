package com.alura.literatura_challenge.service;

import com.alura.literatura_challenge.entities.Books;
import com.alura.literatura_challenge.repository.AuthorRepository;
import com.alura.literatura_challenge.repository.BookRepository;
import com.alura.literatura_challenge.entities.Authors;
import com.alura.literatura_challenge.menu.manejoDelMenu;
import com.alura.literatura_challenge.models.BooksAPI;
import com.alura.literatura_challenge.models.ResultsAPI;
import com.alura.literatura_challenge.models.dto.AuthorsDTO;
import com.alura.literatura_challenge.models.dto.BooksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepositoryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private DataConverter dataConverter;

    public void encontrarLibros(String json) {
        ResultsAPI results = dataConverter.convertData(json, ResultsAPI.class);
        if (!results.datos().isEmpty()) {
            BooksAPI booksAPI = results.datos().get(0);
            Optional<Books> existingBook = bookRepository.findByTitle(booksAPI.getTitle());
            if (existingBook.isPresent()) {
                System.out.println("El libro ya existe en la base de datos\n");
                System.out.println(existingBook.get());
            } else {
                Books books = new Books(booksAPI);
                Authors author = books.getAuthor();
                Optional<Authors> existingAuthor = authorRepository.findByName(
                        author.getName());
                if (existingAuthor.isPresent()) {
                    books.setAuthor(existingAuthor.get());
                } else {
                    authorRepository.save(author);
                }
                bookRepository.save(books);
                System.out.printf("\nTitulo del libro: %s " +
                                "\nNombre del autor: %s " +
                                "\nFecha de nacimiento: %s " +
                                "\nIdioma: %s " +
                                "\nDescargas totales: %s\n",
                        books.getTitle(), books.getAuthor().getName(), books.getAuthor().getBirthAndDeathYear(),
                        manejoDelMenu.getLengua(books.getLanguage()), books.getDownloads());

                System.out.println("El libro se ha guardado exitosamente en la base de datos\n");
            }
        } else {
            System.out.println("No se encontraron libros con los datos proporcionados\n");
        }
    }

    public void encontrarPorAutor() {
        if (!authorRepository.findAll().isEmpty()) {
            List<AuthorsDTO> author = autoresDTOconverter(authorRepository.findAll());
            System.out.println("LISTA DE AUTORES: ");
            author.forEach(e -> System.out.printf(
                    "---------------------------------------------------\n" +
                    "Nombre del autor: %s " +
                    "\nFecha de nacimiento: %s" +
                    "\nLibros escritos: %s\n",
                    e.name(), e.getBirthAndDeathYear(), e.books().get(0).getTitle()));
                    System.out.println("---------------------------------------------------\n");
        } else {
            System.out.println(" NO TENEMOS REGISTRADOS ESTOS AUTORES EN NUESTRA BASE DE DATOS\n");

        }
    }

    public void encontrarTodosLosLibros() {
        List<BooksDTO> books = librosDTOconverter(bookRepository.findAll());
        if (!books.isEmpty()) {
            books.forEach(e -> System.out.printf("---------------------------------------------------\n" +
                            "Titulo del libro: %s\nNombre del autor: %s\nFecha de nacimiento: %s-%s\nIdioma: %s \nDescargas Totales: %s\n",

                            e.title(), e.author().getName(), e.author().getBirthYear(), e.author().getDeathYear(), manejoDelMenu.getLengua(e.language()), e.downloads()));
        } else {
            System.out.println("---------------------------------------------------\n");
            System.out.println("No encontramos ningun libro, intente de nuevo");
        }
    }

    private void guardarEnLibreria (BooksAPI books) {
        Books book = new Books(books);
        bookRepository.save(book);
    }

    public void obtenerAutorAño(int year) {
        if (!authorRepository.findAll().isEmpty()) {
            List<AuthorsDTO> listaAutores = autoresDTOconverter(authorRepository.findAll().stream()
                    .filter(a -> a.getBirthYear() != null && a.getBirthYear() <= year)
                    .filter(a -> a.getDeathYear() != null && a.getDeathYear() >= year)
                    .collect(Collectors.toList()));
            if (!listaAutores.isEmpty()) {
                System.out.println("Hemos obtenido " + listaAutores.size() + " autores en nuestra base de datos!");
                System.out.println("---------------------------------------------------\n");
                listaAutores.stream()
                        .forEach(a -> System.out.println("Nombre del autor: " + a.name() +
                                "\nFecha de nacimiento: " + a.getBirthAndDeathYear() +
                                "\nLibros escritos: " + a.books().get(0).getTitle() +
                                "\n---------------------------------------------------\n"));
            } else {
                System.out.println("---------------------------------------------------\n");
                System.out.println("No se encontraron autores en el año " + year);
            }
        } else {
            System.out.println("---------------------------------------------------\n");
            System.out.println("No encontramos ningun libro, intente de nuevo\n");
        }
    }

    public void discriminarPorLengua(String lang) {
        String uncodedLanguage = manejoDelMenu.getLengua(lang);
        if (!bookRepository.findByLanguage(lang).isEmpty()) {
            bookRepository.findByLanguage(lang).stream()
                    .forEach(b -> System.out.printf("---------------------------------------------------\n" +
                                    "Titulo del libro: %s\nNombre del autor: %s\nFecha de nacimiento: %s-%s\nIdioma: %s \nDescargas Totales: %s\n" +
                                    "---------------------------------------------------\n",
                            b.getTitle(), b.getAuthor().getName(), b.getAuthor().getBirthYear(), b.getAuthor().getDeathYear(), uncodedLanguage, b.getDownloads()));
        } else {
            System.out.println("---------------------------------------------------\n");
            System.out.println("No encontramos ningun libro, intente de nuevo\n");
        }
    }


    private List<BooksDTO> librosDTOconverter(List<Books> books) {
        return books.stream().map(b -> new BooksDTO(b.getTitle(), b.getAuthor(), b.getLanguage(), b.getDownloads())).collect(Collectors.toList());
    }

    private List<AuthorsDTO> autoresDTOconverter(List<Authors> authors) {
        return authors.stream().map(a -> new AuthorsDTO(a.getName(), a.getBirthYear(), a.getDeathYear(), a.getBooks())).collect(Collectors.toList());
    }
}

