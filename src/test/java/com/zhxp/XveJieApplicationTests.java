package com.zhxp;

import com.zhxp.web.entity.Course;
import com.zhxp.web.entity.Student;
import com.zhxp.web.entity.Teacher;
import com.zhxp.web.mapper.CourseMapper;
import com.zhxp.web.mapper.EvaluateInfoMapper;
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

	@Autowired
	private EvaluateInfoMapper evaluateInfoMapper;
//	@Test
//	public void initStudentData() {
//		Student student = new Student();
//
//		student.setPassword("123456");
//		for (int i = 0 ; i < 100 ; i++)
//		{
//			student.setNo(2013117100+i+"");
//			student.setSex(i%2);
//			student.setName("学生"+i);
//			studentMapper.insert(student);
//		}
//
//	}
//
//	@Test
//	public void initTeacherData()
//	{
//        evaluateInfoMapper.selectByType(1);
//	}
//
//	@Test
//	public void initCourseData()
//	{
//		Course course = new Course();
//		course.setAddress("4栋 112");
//		course.setTime("7-8, 10-18");
//		for (int i = 0 ; i < 20 ; i++)
//		{
//			course.setCourseId(100+i+"");
//			course.setTeacherId(1010+i+"");
//			course.setName("课程"+i);
//			courseMapper.insert(course);
//		}
//	}
}
