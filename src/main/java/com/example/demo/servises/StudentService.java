package com.example.demo.servises;

import com.example.demo.models.Student;
import com.example.demo.repositery.StudentRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
//@Builder
@Service
public class StudentService {
    @Autowired
    StudentRepo sRepo;
    List<Student> l1 = new ArrayList<Student>();
    public void addElments () {
        //Builder
       // Student myObj1=Student.builder().id(1).age(20).marks(90).Comp("Vroozi").Name("Qasim Cheema").build();
        //Student myObj2=Student.builder().id(2).age(21).marks(91).Comp("Vroozi").Name("Awais").build();

      /*  Student myObj2 = new Student(200,"Ali Ahmad ",20,50,"Vroozi");
        Student myObj3 = new Student(903,"sarfraz",20,50,"Vroozi");
        Student myObj4 = new Student(400,"Hamza ",20,50,"Vroozi");
        Student myObj5 = new Student(600,"Awais ",20,50,"Vroozi");
        l1.add(myObj2);
        l1.add(myObj3);
        l1.add(myObj4);
        l1.add(myObj5);*/

        // Builder
       // l1.add(myObj1);
        //l1.add(myObj2);
    }
    public List<Student> getAllStudents() {
        addElments();
        return l1;
    }

    public  List<Student> findWithConditionby(int age) {
        return sRepo.findWithConditionBy(age);
    }

    public List<Student> ageLessThan(int age) {
        return sRepo.ageLessThan(age);
    }

    public List<Student> ageEqualTo(int age) {
        return sRepo.ageEqualTo(age);
    }

    public List<Student> getByAgeMarks( int age,int marks) {
        return sRepo.getByAgeMarks(age,marks);
    }

    public Student nameAge(String name){
  return sRepo.nameAge(name);
    }

    public List<Student> getBooksByAuthorRegEx(String name){
        return sRepo.getBooksByAuthorRegEx(name);
    }
}
