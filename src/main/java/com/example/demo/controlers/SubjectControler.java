package com.example.demo.controlers;

import com.example.demo.models.Subject;
import com.example.demo.models.SubjectTS;
import com.example.demo.repositery.SubjectRepo;
import com.example.demo.servises.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectControler {
    @Autowired
    private SubjectRepo subRepo;
    @Autowired
    private SubjectService subService;

    @PostMapping("/addSubject")
    public String addSbject(@RequestBody Subject subject)
    {
        subRepo.save(subject);
        return "Subject Added";
    }
    @GetMapping("/teacher-student-of-subject/{id}")
    public SubjectTS TeacherStudentOfSub(@PathVariable int id)
    {
        return subService.TeacherStudentOfSub(id);
    }
}
