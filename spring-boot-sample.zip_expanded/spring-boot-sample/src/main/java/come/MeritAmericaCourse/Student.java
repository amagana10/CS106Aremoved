package come.MeritAmericaCourse;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String studentName;
	private Long student_id;

	
	public Student(String studentName, Long student_id) {
		super();
		this.studentName = studentName;
		this.student_id = student_id;
		
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	
	
}
