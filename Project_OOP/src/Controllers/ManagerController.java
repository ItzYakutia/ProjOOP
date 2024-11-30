package Controllers;

import Models.Course;
import Models.Lesson;
import Models.Teacher;

public class ManagerController {

	public static Lesson createLesson(Teacher teacher, Course course) {
		if (teacher == null || course == null) return null;
		
		return new Lesson(teacher, course);
	}
	
	public static Course createCourse(String title) {
		return new Course(title);
	}
}