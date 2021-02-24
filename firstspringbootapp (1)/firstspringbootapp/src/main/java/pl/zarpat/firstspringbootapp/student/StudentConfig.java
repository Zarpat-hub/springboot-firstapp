package pl.zarpat.firstspringbootapp.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Patryk =  new Student(
                    "Patryk",
                    "patrykz19@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 19)
            );

            Student Aleks =  new Student(
                    "ALeks",
                    "aleksi@wp.pl",
                    LocalDate.of(2001, Month.APRIL, 21)
            );

            repository.saveAll(List.of(Patryk,Aleks));
        };
    }
}
