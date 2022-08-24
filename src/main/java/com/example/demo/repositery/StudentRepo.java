package com.example.demo.repositery;
import com.example.demo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student, Integer>{

   // public default List<Student> getStu()
    //{
      //  return findAll();
    //}

    public default ResponseEntity UpdateS( int id,  Student sts)
    {

        Optional<Student> studentData = findById(id);
        if (studentData.isPresent()) {
            Student _student = studentData.get();
            _student.setCompany(sts.getCompany());
            _student.setName(sts.getName());
            _student.setMarks(sts.getMarks());
            return new ResponseEntity<>(save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public List<Student> findByIdIn(Collection sub);
    @Query("{age : {$gte : ?0} }")
    public  List<Student> findWithConditionBy(int age);
    @Query("{age: {$lt: ?0}}")
    public List<Student> ageLessThan(int age);
    @Query("{age :?0}")
    public List<Student> ageEqualTo(int age);
    @Query("{age :?0, marks :{$gte :?1}}")
    public List<Student> getByAgeMarks( int age,int marks);

    @Query(value= "{Name: ?0}", fields="{Name:1, age:1}")
    public Student nameAge(String name);

    @Query("{ 'Name' : { $regex: ?0 } }")
    public List<Student> getBooksByAuthorRegEx(String name);

}
