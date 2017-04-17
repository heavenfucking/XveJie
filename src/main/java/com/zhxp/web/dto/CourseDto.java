package com.zhxp.web.dto;


/**
 * Created by zhh on 2017/4/16.
 */
public class CourseDto {

    private Integer id;

    private String courseId;

    private String name;

    private String teacherName;

    private String className;

    private Integer openStudentEvaluate;

    private Integer openTeacherEvaluate;

    public CourseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getOpenStudentEvaluate() {
        return openStudentEvaluate;
    }

    public void setOpenStudentEvaluate(Integer openStudentEvaluate) {
        this.openStudentEvaluate = openStudentEvaluate;
    }

    public Integer getOpenTeacherEvaluate() {
        return openTeacherEvaluate;
    }

    public void setOpenTeacherEvaluate(Integer openTeacherEvaluate) {
        this.openTeacherEvaluate = openTeacherEvaluate;
    }
}
