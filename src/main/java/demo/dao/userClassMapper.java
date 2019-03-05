package demo.dao;

import demo.pojo.userClass;
import demo.pojo.userClassKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userClassMapper {
    int deleteByPrimaryKey(userClassKey key);

    int insert(userClass record);

    int insertSelective(userClass record);

    userClass selectByPrimaryKey(userClassKey key);

    int updateByPrimaryKeySelective(userClass record);

    int updateByPrimaryKey(userClass record);

    int updateNumber(@Param("userId")int userId,@Param("classId")int classId);

    List<userClass> selectObjectByUserId(int userId);
}