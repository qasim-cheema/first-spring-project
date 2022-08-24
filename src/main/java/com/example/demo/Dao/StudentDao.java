package com.example.demo.Dao;
import com.example.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentDao  {
    @Autowired
    MongoTemplate mongoTemplate;


}
