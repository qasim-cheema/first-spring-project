package com.example.demo.controlers;

import com.example.demo.*;
import com.example.demo.models.Student;
import com.example.demo.models.Subject;
import com.example.demo.models.Teacher;
import com.example.demo.repositery.StudentRepo;
import com.example.demo.repositery.TeacherRepo;
import com.example.demo.servises.TeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepo repo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/get-by-id/{id}")
    public Teacher getById(@PathVariable int id)
    {
        return teacherService.findTeacher(id);
    }
    @GetMapping("/sum-of-teacher-ids")
    public Aggregation sumOfIds()
    {

        return teacherService.sumOfIds();
    }

    //Ading Techer in database
    @PostMapping("/addTeacher")
    public String addTeacher(@RequestBody Teacher teacher) {

      //  teacher.setS_id(1);
        //teacher.setS_id(2);
       repo.save(teacher);
       return "Added Successfully";
    }

    @GetMapping("/findAllT")
    public List<Teacher> getTeacher() {
         return repo.findAll();
        //return repo.getStu();
    }

    @GetMapping("/getAllStudentOf/{id}")
    public List<Student> getTeacher(@PathVariable int id ) {
        return teacherService.getTeacher(id);
    }

    @GetMapping("/getAllSubjectOf/{id}")
    public List<Subject> getAllSubject(@PathVariable int id) {
        return teacherService.getAllSubject(id);
    }

    @GetMapping("/get-all-sub-stu-of/{id}")
    public List[] getAllSubTec(@PathVariable int id) {
        return teacherService.getAllSubTec(id);

    }

    @GetMapping("/findTbyName/{name}")
    public Teacher getTeacherByName(@PathVariable String name) {
        return( repo.findOneByName(name));
    }

    // Delete from data base
    @DeleteMapping("/deleteT/{id}")
    public String deleteTeacher(@PathVariable int id){
        try
        {
            repo.deleteById(id);
            return "Delete Successfully";

        } catch (Exception e) {
            throw new ProductNotfoundException();
        }
    }
}
