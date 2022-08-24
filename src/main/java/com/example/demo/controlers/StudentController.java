package com.example.demo.controlers;
import com.example.demo.servises.StudentService;
import com.example.demo.ProductNotfoundException;
import com.example.demo.models.Student;
import com.example.demo.repositery.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
public class StudentController {

    List<Student> l1 = new ArrayList<Student>();
    List<Student> l2 = new ArrayList<Student>();
   /* @PostConstruct
    private void postConstruct() {
        Student myObj1 = new Student(900,"Qasim ",22,70,"Vroozi");
        Student myObj2 = new Student(200,"Ali Ahmad ",20,50,"Vroozi");
        Student myObj3 = new Student(903,"sarfraz",20,50,"Vroozi");
        Student myObj4 = new Student(400,"Hamza",20,50,"Vroozi");
        Student myObj5 = new Student(600,"Awais",20,50,"Vroozi");
        l1.add(myObj1);
        l1.add(myObj2);
        l1.add(myObj3);
        l1.add(myObj4);
        l1.add(myObj5);
    }*/
    @Autowired
    StudentService myServices;
    @Autowired
    private StudentRepo repo;
   // @Bean
    //public Student collegeBean()
   // {
       //  Return the College object
      //  return new Student();
    //}
   // Adding in data base
    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student){
        repo.save(student);
        // i am saving user

        return "Added Successfully";
    }
    // getting data from db
    @GetMapping("/findAllS")
    public List<Student> getStudent() {

        return repo.findAll();
       // return myServices.getStu();
       // return l1;
    }
    /* Delete from data base */@DeleteMapping("/deleteS/{id}")
    public String deleteStudent(@PathVariable int id){

        try
        {
            repo.deleteById(id);
            return "Delete Successfully";

        } catch (Exception e) {
            throw new ProductNotfoundException();
        }
    }

    // Update student in database
    @PutMapping("/updateS/{id}")
    ResponseEntity updateStudent(@PathVariable int id, @RequestBody Student sts) {
       /* Optional<Student> studentData = repo.findById(id);
        if (studentData.isPresent()) {
            Student _student = studentData.get();
            _student.setCompany(sts.getCompany());
            _student.setName(sts.getName());
            _student.setMarks(sts.getMarks());
            return new ResponseEntity<>(repo.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return repo.UpdateS(id,sts);


    }
    @GetMapping("/hi")
    public String hello() {

        return "hello Vroozi";
    }
    @GetMapping("/sts-/{id}")
    ResponseEntity sts(@PathVariable int id) {
        for (int i = 0; i < l1.size(); i++) {
            if( l1.get(i).getId() == id)
            {
               // return l1.get(i);
                return new ResponseEntity<>(
                        l1.get(i),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Id not found",
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllStudents")
    public List<Student> students() {

                return myServices.getAllStudents();

    }


    @PostMapping(
            value = "/createStudent", consumes = "application/json", produces = "application/json")
    public Student createStudent(@RequestBody Student student) {

        /*int maxId=l1.get(0).getId();
        for (int i = 1; i < l1.size(); i++) {
            if( l1.get(i).getId() >= maxId)
            {
               maxId=l1.get(i).getId();
            }
        }
        maxId++;*/

        Student maxId = l1
                .stream()
                .max(Comparator.comparing(Student::getId))
                .orElseThrow(NoSuchElementException::new);
        student.setId(maxId.getId()+1);
       l1.add(student);
        return student;
    }

   /* @DeleteMapping("/student/{id}")
    public List deleteEmployee(@PathVariable("id") int id) {
        l1.remove(id);
       // assertEquals(4, l1.size());
        //assertNotEquals(sports.get(1), "Basketball");
        return l1;

    }*/

    @PutMapping("/stud/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable int id) {

        //if(!l1.get(id))throw new ProductNotfoundException();
int temp=-1;
        for (int i = 0; i < l1.size(); i++) {

            if( l1.get(i).getId() == id)
            {
                temp=i;
                if(newStudent.getName()!= null)
                l1.get(i).setName(newStudent.getName());
                if(newStudent.getAge()!=0)
                l1.get(i).setAge(newStudent.getAge());
                if(newStudent.getCompany()!=null)
                l1.get(i).setCompany(newStudent.getCompany());
                if(newStudent.getMarks()!=0)
                l1.get(i).setMarks(newStudent.getMarks());

               // return new ResponseEntity<>(
                 //       l1.get(i),HttpStatus.OK);
                return l1.get(i);
            }

        }
        throw new ProductNotfoundException();
    }

    @GetMapping("/student-greaterthan-/{age}")
    public List<Student> findWithCondition(@PathVariable int age) {
        return myServices.findWithConditionby(age);
    }
    @GetMapping("/age-less-than/{age}")
    public List<Student> ageLessThan(@PathVariable int age)
    {
        return myServices.ageLessThan(age);
    }
    @GetMapping("age-marks-greaterthan/{age}/{marks}")
    public List<Student> getByAgeMarks(@PathVariable int age, @PathVariable int marks)
    {
        return myServices.getByAgeMarks(age,marks);
    }

    @GetMapping("name-age/{name}")
    public Student nameAge(@PathVariable String name)
    {
        return myServices.nameAge(name);
    }




}

