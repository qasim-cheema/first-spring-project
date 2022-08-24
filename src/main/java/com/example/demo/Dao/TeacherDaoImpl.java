package com.example.demo.Dao;
import com.example.demo.models.CountClass;
import com.example.demo.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Repository
public class TeacherDaoImpl {

    @Autowired
    MongoTemplate mongoTemplate;

    public Teacher findById(int id)
    {
        return   mongoTemplate.findById(id, Teacher.class);
    }
    public Aggregation sumOfIds(){

        Aggregation aggregation = Aggregation.newAggregation(
                group("1").sum("_id" ).as("count"));

        mongoTemplate.aggregate(aggregation, Teacher.class, CountClass.class);
        return aggregation;
    }

}
