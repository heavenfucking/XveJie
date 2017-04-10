package com.zhxp;

import com.zhxp.web.entity.Course;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.mapper.CourseMapper;
import com.zhxp.web.mapper.StudentMapper;
import com.zhxp.web.mapper.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XveJieApplicationTests {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private CourseMapper courseMapper;

	@Test
	public void initStudentData() {
		Student student = new Student();
		student.setDepartment("计算机系");
		student.set_class("计科1311");
		student.setPassword("123456");
		for (int i = 0 ; i < 100 ; i++)
		{
			student.setNo(2013117100+i+"");
			student.setSex(i%2);
			student.setName("学生"+i);
			studentMapper.insert(student);
		}

	}

	@Test
	public void initTeacherData()
	{
		teacherMapper.selectByNo("1006");
//		Teacher teacher = new Teacher();
//		teacher.setPassword("123456");
//		teacher.setDepartment("计算机系");
//		for (int i = 0 ; i < 10 ; i++)
//		{
//			teacher.setNo(1010+i+"");
//			teacher.setSex(i%2);
//			teacher.setName("教师"+i);
//			teacherMapper.insert(teacher);
//		}
	}

	@Test
	public void initCourseData()
	{
		Course course = new Course();
		course.setAddress("4栋 112");
		course.setTime("7-8, 10-18");
		for (int i = 0 ; i < 20 ; i++)
		{
			course.setCourseId(100+i+"");
			course.setTeacherId(1010+i+"");
			course.setName("课程"+i);
			courseMapper.insert(course);
		}
	}
}
