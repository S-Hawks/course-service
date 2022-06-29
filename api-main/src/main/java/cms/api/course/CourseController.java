package cms.api.course;

import cms.api.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController{
	
	@Autowired
	private CourseService courseService; //Dependency Injection(Dependent to topicService).

	//Get all courses at once
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		//TODO:Will tackle it latter
		return courseService.getAllCourses(topicId);
	}
	//Get a specific course
	@RequestMapping(method = RequestMethod.GET, value = "/topic/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	//Post a new course
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public Course addCourses(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		 return courseService.addCourses(course);
	}

	//Update a specific course
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	//Delete a specific course
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse (@PathVariable String topicId, @PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
