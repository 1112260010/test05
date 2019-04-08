package dao;

import pojo.UserAddress;

public interface UserAddressDao {
    //多对一   单条sql
    public UserAddress selectManyToOnesingleSql(Integer id);

    //多对一   多条sql
    public UserAddress selectManyToOneMultiSql(Integer id);
}
