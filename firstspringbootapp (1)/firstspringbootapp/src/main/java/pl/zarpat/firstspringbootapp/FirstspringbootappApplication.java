package pl.zarpat.firstspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zarpat.firstspringbootapp.student.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class FirstspringbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringbootappApplication.class, args);
	}

	@GetMapping
	public List<Student> hello() {

		return List.of(
				new Student(
						1L,
						"Patryk",
						"patrykz19@gmail.com",
						20,
						LocalDate.of(2001, Month.JANUARY, 19)
				)
		);
	}

}
