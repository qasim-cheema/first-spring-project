package com.example.demo.servises;

import com.example.demo.Dao.TeacherDaoImpl;
import com.example.demo.models.Student;
import com.example.demo.models.Subject;
import com.example.demo.models.Teacher;
import com.example.demo.repositery.StudentRepo;
import com.example.demo.repositery.SubjectRepo;
import com.example.demo.repositery.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private StudentRepo sRepo;
    @Autowired
    private TeacherRepo tRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    TeacherDaoImpl teacherDaoImpl;

    public Teacher findTeacher(int id)
    {
        return teacherDaoImpl.findById(id);
    }
    public Aggregation sumOfIds()
    {
        return teacherDaoImpl.sumOfIds();
    }

    public List<Student> getTeacher(int id ) {
        List<Student> std = new ArrayList<>();
                std= sRepo.findAll();
        List<Student> newStd = new ArrayList<>();
        for(Student student :std)
        {
            if(student.getT_id().contains(id))
            {
                student.getTecList().addAll(tRepo.findByIdIn(student.getT_id()));
                 student.getTecList().add(tRepo.findById(id));
                newStd.add(student);
            }
        }
        return newStd;
    }
    // Try using IN Query
    public List<Subject> getAllSubject(int id)  // techer id
    {
        Teacher tec=tRepo.findById(id);

        List<Subject> sub= subjectRepo.findAll();
        List<Subject> newSub=new ArrayList<>();
        for(Subject subject :sub)
        {
            if(tec.getSub_ids().contains(subject.getId()))
            {
                newSub.add(subject);
            }
        }
        return newSub;
    }
    public List[] getAllSubTec( int id)
    {

        Teacher tec=tRepo.findById(id);
       // List<Subject> sub= subRepo.findAll();
        List<Student> std=sRepo.findAll();

       // List<Subject> newSub=new ArrayList<>();
        List<Student> newstd=new ArrayList<>();
       /* for(Subject subject :sub)
        {
            if(tec.getSub_ids().contains(subject.getId()))
            {
                newSub.add(subject);
            }
        }
*/
        for(Student student :std)
        {
            if(student.getT_id().contains(id))
            {
                newstd.add(student);
            }
        }
        return new List[] { getAllSubject(id), newstd };
    }

    public Teacher findTec(int id)
    {
        return tRepo.findById(id);
    }

}
