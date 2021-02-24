package pl.zarpat.firstspringbootapp.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {


    public List<Student> getStudents() {

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
