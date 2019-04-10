package test;

import dao.CategoryDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UserAddressDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.*;
import util.MybatisUtil;

import java.io.IOException;
import java.util.List;

public class Test04 {
    //多对一   单条sql
    @Test
    public void testManyToOneSingleSql(){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserAddressDao userAddressDao = sqlSession.getMapper(UserAddressDao.class);
        UserAddress userAddress = userAddressDao.selectManyToOnesingleSql(47);
        System.out.println(userAddress.getId()+"==="+userAddress.getAddress());
        System.out.println("--------");
        System.out.println(userAddress.getUser().getUserName());
    }

    //多对一   多条sql
    @Test
    public void testManyToOneMultiSql(){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserAddressDao userAddressDao = sqlSession.getMapper(UserAddressDao.class);
        UserAddress userAddress = userAddressDao.selectManyToOneMultiSql(47);
        System.out.println(userAddress.getId()+"==="+userAddress.getAddress());
        System.out.println("--------");
        /*System.out.println(userAddress.getUser().getUserName());*/
    }

    //自关联  1：N
    @Test
    public void testSelf1(){
        SqlSession sqlSession = MybatisUtil.getSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        List<Category> list = categoryDao.selectCategoryByParentId(0);
        for(Category c:list){
            System.out.println(c);
        }

    }

    //自关联  N:1
    @Test
    public void testSelf2(){
        SqlSession sqlSession = MybatisUtil.getSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        List<Category> list = categoryDao.selectCategoryById(717);
        for(Category c:list){
            System.out.println(c);
        }

    }

    //多对多
    @Test
    public void testManyToMany(){
        SqlSession sqlSession = MybatisUtil.getSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        Teacher ts = teacherDao.selectStudentByTid(1);
        for(Student stu:ts.getList()){
            System.out.println(stu);
        }
    }

    //测试一级缓存默认存在
    @Test
    public void testLazyloading() throws IOException {
        SqlSession sqlSession1 = MybatisUtil.getSession();
        StudentDao dao1 = sqlSession1.getMapper(StudentDao.class);
        List<Student> list1 = dao1.findAll();
        for(Student stu:list1){
            System.out.println(stu.getSname());
        }
        System.out.println("==================");
        List<Student> list2 = dao1.findAll();
        for(Student stu:list2){
            System.out.println(stu.getSname());
        }
        System.out.println("==================");
        List<Student> list3 = dao1.findAll();
        for(Student stu:list3){
            System.out.println(stu.getSname());
        }
    }

    //测试增删改对一级缓存的影响
    //一级缓存失效
    @Test
    public void testUpdateLazyloading() throws IOException {
        SqlSession sqlSession1 = MybatisUtil.getSession();
        StudentDao dao1 = sqlSession1.getMapper(StudentDao.class);
        List<Student> list1 = dao1.findAll();
        for(Student stu:list1){
            System.out.println(stu.getSname());
        }
        System.out.println("==================");
        Student student = new Student();
        student.setSname("小小");
        student.setSage(30);
        dao1.AddStudent(student);
        System.out.println("==================");
        List<Student> list3 = dao1.findAll();
        for(Student stu:list3){
            System.out.println(stu.getSname());
        }
    }

    //测试二级缓存---作用域是StudentDao.xml
    @Test
    public void testSecondLevel() throws IOException {
        SqlSession sqlSession1 = MybatisUtil.getSession();
        StudentDao dao3 = sqlSession1.getMapper(StudentDao.class);
        List<Student> list1 = dao3.findAll();
        for(Student stu:list1){
            System.out.println(stu.getSname());
        }
        sqlSession1.close();
        System.out.println("==================");
        SqlSession sqlSession2 = MybatisUtil.getSession();
        StudentDao dao2 = sqlSession2.getMapper(StudentDao.class);
        List<Student> list2 = dao2.findAll();
        for(Student stu:list2){
            System.out.println(stu.getSname());
        }
        sqlSession2.close();
    }

    //延迟加载
    @Test
    public void testLazyLoad() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserAddressDao userAddressDao = sqlSession.getMapper(UserAddressDao.class);
        UserAddress userAddress1 = userAddressDao.selectManyToOneMultiSql(49);
        System.out.println(userAddress1.getId()+"==="+userAddress1.getAddress());
        System.out.println("--------");
        /*System.out.println(userAddress1.getUser().getUserName());*/
    }


}
