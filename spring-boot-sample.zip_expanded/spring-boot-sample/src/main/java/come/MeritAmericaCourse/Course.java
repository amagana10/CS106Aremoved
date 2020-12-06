package come.MeritAmericaCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Course {
	private String tittle;
	private Long course_id[];
	public Course(String tittle, Long[] course_id) {
		super();
		this.tittle = tittle;
		this.course_id = course_id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public Long[] getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long[] course_id) {
		this.course_id = course_id;
	}
	
	

}
