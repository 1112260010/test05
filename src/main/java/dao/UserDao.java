package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询所有用户
    public List<User> findAllUsers();

    //查询用户名模糊查询、用户地址
    public List<User> likeSelectAndAddress(User user);

    //多条件查询:condition
    public List<User> selectByCondition(User user);

    //多条件查询:Map
    public List<User> selectByMap(Map<String, Object> map);

    //智能标签if
    public List<User> ifTag(User user);

    //智能标签choose
    public List<User> chooseTag(User user);

    //智能标签foreach:数组
    public List<User> foreachTag(int[] ids);

    //智能标签foreach:集合
    public List<User> foreachListTag(List<User> list);

    //修改用户
    public int updateUser(User user);
}
