package com.example.demo.repositery;

import com.example.demo.models.Subject;
import com.example.demo.models.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface SubjectRepo extends MongoRepository<Subject, Integer> {
    public List<Teacher> findByIdIn(List<Integer> li);
    public List<Teacher> findByIdIn(Collection sub);
}
