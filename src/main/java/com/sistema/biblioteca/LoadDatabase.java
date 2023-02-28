package com.sistema.biblioteca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sistema.biblioteca.model.Livro;
import com.sistema.biblioteca.model.Usuario;
import com.sistema.biblioteca.repository.LivroRepository;
import com.sistema.biblioteca.repository.UsuarioRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UsuarioRepository repository) {

    return args -> {
//      log.info("Preloading " + repository.save((Livro) new Livro("Modern API Developmento with Spring Rest", "Sourabh Sharma", "","Pckt","2021","Programming","1",582)));
//      log.info("Preloading " + repository.save((Livro) new Livro("Spring Rest: Building Java Microservices and Cloud Applcations", "Balaji V.; Maximim B.", "","Apress","2022","Programming","",250)));
    	//log.info("Preloadind user" + repository.save(Usuario) new Usuario(""));
    };
  }
}