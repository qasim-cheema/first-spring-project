package com.example.demo;

import com.example.demo.repositery.StudentRepo;
import com.example.demo.repositery.TeacherRepo;
import com.example.demo.servises.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class DemoApplicationTests {
 @MockBean
	StudentRepo sRepo;
 @Autowired
	TeacherService tService;
 @MockBean
	TeacherRepo tRepo;
	/*@Test
	public void getUsersTest() {
		List<Integer> lint =new ArrayList<>();
		lint.add(1);
		lint.add(2);
		Mockito.when(tRepo.findById(2)).thenReturn((new Teacher(2, "Danile", "BBA", lint)));
		Mockito.when(tRepo.findAll()).thenReturn(Stream
				.of(new Teacher(2, "Danile", "BBA", lint)).collect(Collectors.toList()));
		assertEquals(2, tService.getAllSubject(2).size());
	}*/

	//@Test
	//void creatTest()  throws Exception {
		//List<Integer> li=new ArrayList<>();
		//li.add(1);
		//li.add(2);
		/*Student student=new Student();
		student.setId(20);
		student.setAge(20);
		student.setCompany("Vroozi");
		student.setName("Qasim");
		student.setSub_ids(li);
		student.setT_id(li);*/

		//Student student=Student.builder().id(20).age(20).Comp("Vroozi").Name("Qasim").t_id(li).sub_ids(li).build();
		//sRepo.save(student);
		//assertNotNull(sRepo.findById(20).get());
	//}

}
