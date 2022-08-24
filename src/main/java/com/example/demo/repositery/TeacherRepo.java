package com.example.demo.repositery;

import com.example.demo.models.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Collection;
import java.util.List;

public interface TeacherRepo extends MongoRepository<Teacher, Integer> {
    public default List<Teacher> getTec()
    {
        return findAll();
    }
    //public default List<Teacher> getStu()
    //{
      //  return findAll();
    //}
    public Teacher findOneByName(String name);
    public Teacher findById(int id);
   // public List<Teacher> findByIdIn(List<Integer> li);
    public List<Teacher> findByIdIn(Collection sub);
}
