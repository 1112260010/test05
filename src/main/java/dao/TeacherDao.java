package dao;

import pojo.Student;
import pojo.Teacher;
import pojo.TeacherStudent;

import java.util.List;

public interface TeacherDao {
    //根据教师id查询该教师下所有学生
    public Teacher selectStudentByTid(Integer tid);
}
