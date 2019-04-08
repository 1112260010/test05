package test;

import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import pojo.UserAddress;
import util.MybatisUtil;

public class Test03 {
    //一对多     单条sql
    @Test
    public void testOneToMany(){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.testOneToMany(35);
        System.out.println(user.getId()+"----------"+user.getUserName());
        System.out.println("-----------");
        System.out.println(user.getList().size());
        for(UserAddress address:user.getList()){
            System.out.println(address.getAddress());
        }
    }

    //一对多     多条sql
    @Test
    public void testOneToManyMultiSql(){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.testOneToManyMultiSql(35);
        System.out.println(user.getId()+"----------"+user.getUserName());
        System.out.println("-----------");
        System.out.println(user.getList().size());
        for(UserAddress address:user.getList()){
            System.out.println(address.getAddress());
        }
    }
}
