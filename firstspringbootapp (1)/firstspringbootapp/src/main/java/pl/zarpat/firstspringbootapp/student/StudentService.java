package pl.zarpat.firstspringbootapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        studentRepository.save(student);
    }

    public void deletingChosenStudent(Student student){

        studentRepository.deleteById(student.getId());
    }

    @Transactional
    public void updateStudent(Long studentId, Student studentData){

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with " +studentId+" does not exist" ));


            student.setName(studentData.getName());
            student.setEmail(studentData.getEmail());
    }
}
