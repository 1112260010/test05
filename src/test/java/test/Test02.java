package test;

import dao.StudentDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import pojo.Student;
import util.MybatisUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {

    /**
     * 根据id查询学生
     * @throws IOException
     */
    @Test
    public void t1() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.findById(2);
        System.out.println(student.getSname()+"-----"+student.getSage());
    }

    /**
     * 查询所有用户
     * @throws IOException
     */
    @Test
    public void t2() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findAllUsers();
        for(User user:list){
            System.out.println(user.getLoginName()+"-----"+user.getUserName());
        }
    }



    /**
     * 增加学生
     * @throws IOException
     */
    @Test
    public void t3() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setSname("王五");
        stu.setSage(30);
        int rows = studentDao.AddStudent(stu);
        sqlSession.commit();
        if(rows > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    /**
     * 添加学生后查询最大id
     * @throws IOException
     */
    @Test
    public void t4() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setSname("赵六");
        stu.setSage(30);
        System.out.println(stu.getSid());
        int id= studentDao.AddStudentReturnMaxId(stu);
        sqlSession.commit();
        System.out.println(stu.getSid());
    }

    /**
     * 模糊查询用户名字、用户地址
     * @throws IOException
     */
    @Test
    public void t5() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setLoginName("a");
        user.setType(0);
        List<User> list = userDao.likeSelectAndAddress(user);

        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex()+"---"+u.getUAddress());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 多条件查询:condition
     * @throws IOException
     */
    @Test
    public void t6() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setLoginName("a");
        user.setType(0);
        List<User> list = userDao.selectByCondition(user);
        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 多条件查询:map
     * @throws IOException
     */
    @Test
    public void t7() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("loginName","a");
        map.put("type",0);
        List<User> list = userDao.selectByMap(map);
        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 智能标签if
     * @throws IOException
     */
    @Test
    public void testIfTag() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setLoginName("a");
        List<User> list = userDao.ifTag(user);
        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 智能标签choose
     * @throws IOException
     */
    @Test
    public void testChooseTag() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        /*user.setLoginName("a");*/
        List<User> list = userDao.chooseTag(user);
        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 智能标签foreach:数组
     * @throws IOException
     */
    @Test
    public void testForeachArrayTag() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int[] ids = {1,2,10,11,12};
        List<User> list = userDao.foreachTag(ids);
        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 智能标签foreach:集合
     * @throws IOException
     */
    @Test
    public void testForeachListTag() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        User u2 = new User();
        u2.setId(10);
        User u3 = new User();
        u3.setId(11);
        User u4 = new User();
        u4.setId(12);
        User u5 = new User();
        u5.setId(13);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        List<User> list = userDao.foreachListTag(userList);
        for(User u:list){
            System.out.println(u.getId()+"----"+u.getLoginName()+"---"+u.getSex());
        }
        /*logger2.debug("this is a debug message");*/
    }

    /**
     * 智能标签foreach:数组
     * @throws IOException
     */
    @Test
    public void testUpdateUser() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setId(36);
        u.setLoginName("wtc199");
        int num = userDao.updateUser(u);
        if(num > 0){
            System.out.println("修改成功");
        }
        /*logger2.debug("this is a debug message");*/
    }
}
