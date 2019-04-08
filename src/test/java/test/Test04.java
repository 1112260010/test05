package test;

import dao.CategoryDao;
import dao.TeacherDao;
import dao.UserAddressDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.*;
import util.MybatisUtil;

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
        System.out.println(userAddress.getUser().getUserName());
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
}
