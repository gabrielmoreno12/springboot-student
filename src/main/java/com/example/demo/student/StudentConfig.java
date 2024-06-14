package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration  // Indica que esta classe é uma classe de configuração Spring
public class StudentConfig {

    @Bean   // Define um bean que será gerenciado pelo contêiner Spring
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student gabriel = new Student(
                    "Gabriel",
                    "gabriel@email.com",
                    LocalDate.of(2003, Month.JUNE, 12)
            );

            Student mariana = new Student(
                    "Mariana",
                    "mariana@email.com",
                    LocalDate.of(2010, Month.MAY, 25)
            );
            // Salva os estudantes no repositório
            repository.saveAll(List.of(gabriel, mariana));
        };

    }

}
    