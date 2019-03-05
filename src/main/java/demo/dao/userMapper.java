package demo.dao;

import demo.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    int checkUserName(String userName);

    user checkAndSelectUser( String userName,String password);

    int insertNewUser(@Param("userName") String userName,@Param("password") String password);
}