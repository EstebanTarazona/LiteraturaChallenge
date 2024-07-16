package com.alura.literatura_challenge;

import com.alura.literatura_challenge.menu.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraChallengelibreria implements CommandLineRunner {

    @Autowired
    private MainMenu mainMenu;

    public static void main(String[] args) {
        SpringApplication.run(AluraChallengelibreria.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainMenu.menuLista();
    }
}
