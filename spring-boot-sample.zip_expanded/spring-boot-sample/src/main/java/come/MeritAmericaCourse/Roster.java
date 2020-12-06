package come.MeritAmericaCourse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wwex.springbootsample.model.Student;

@RestController
public class Roster {
	
	@Autowired
	private Student student;
	
	@Autowired
	private Course course;
	
 @GetMapping(value = "/students")
public List<Student>allStudents(){
		
		List<Student> students = new ArrayList<>();
		Student gebremedhin = new Student("Gebremedhin","Maths",101);
		Student mamo = new Student("mamo","physics",102);
		Student yonas = new Student("yonas","Economics",103);
		Student befrdu = new Student("befrdu","Computerscience",104);
		
		students.add(gebremedhin);
		students.add(befrdu);
		students.add(yonas);
		students.add(mamo);
		
		return students;
	}

}
