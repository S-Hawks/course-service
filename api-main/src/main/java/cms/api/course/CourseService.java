package cms.api.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
	private final CourseRepository courseRepository;  //Creating construction is used instead of @Autowired annotation.

	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> getAllCourses(String topicId){
//		List<Course> courses = new ArrayList<>();
//		//TODO:Need to overview it if bug arise.
//		courseRepository.findById(topicId).map(courses::add);
//		return courses;
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(String id) {
		//TODO:Need to Work on it if but arise
		return courseRepository.findById(id).get();
	}

	public Course addCourses(Course course) {
		return courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
		
	}
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	
}
