package com.example.demo.servises;

import com.example.demo.models.Student;
import com.example.demo.models.Subject;
import com.example.demo.models.SubjectTS;
import com.example.demo.models.Teacher;
import com.example.demo.repositery.StudentRepo;
import com.example.demo.repositery.SubjectRepo;
import com.example.demo.repositery.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class SubjectService {
    @Autowired
    private StudentRepo sRepo;
    @Autowired
    private TeacherRepo tRepo;
    @Autowired
    private SubjectRepo subRepo;

    public SubjectTS TeacherStudentOfSub(int id)
    {
        //Try to solve using IN query
        Subject sub= subRepo.findById(id).get();
        SubjectTS subTS=new SubjectTS();
        subTS.setSubId(id);
        subTS.setSubName(sub.getName());

        subTS.gettList().addAll(tRepo.findByIdIn(tRepo.findAll()));

       // subTS.getsList().addAll(subRepo.findByIdIn(tRepo.findAll()));
        return subTS;
        //return tRepo.findByIdIn(tRepo.findAll());

      //  for(Student student :std)
        //{
          //  if(student.getSub_ids().contains(id))
            //{
              //  subTS.getsList().add(student);
            //}
        //}

        //for(Teacher teacher :tec)
        //{
          //  if(teacher.getSub_ids().contains(id))
            //{
              //  subTS.gettList().add(teacher);
            //}
        //}

        //return subTS;
    }

}
