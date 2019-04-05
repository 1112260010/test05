package test;

import dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import util.MybatisUtil;

import java.io.IOException;
import java.util.List;


public class Test01 {


    /**
     * 查询所有学生
     * @throws IOException
     */
    @Test
    public void t1() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = studentDao.findAll();
        for(Student stu:list){
            System.out.println(stu.getSname()+"----"+stu.getSage());
        }
    }

    /**
     * 模糊查询
     * @throws IOException
     */
    @Test
    public void t2() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = studentDao.likeSelect("三");
        for(Student stu:list){
            System.out.println(stu.getSname()+"----"+stu.getSage());
        }
    }
}
