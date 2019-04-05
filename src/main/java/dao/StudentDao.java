package dao;

import pojo.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDao {
    //查询所有学生
    public List<Student> findAll() throws IOException;

    //根据id查询单个学生
    public Student findById(Integer id) throws IOException;

    //添加学生
    public int AddStudent(Student student);

    //添加学生并返回最大id
    public int AddStudentReturnMaxId(Student stu);

    //模糊查询
    public List<Student> likeSelect(String sname);
}
