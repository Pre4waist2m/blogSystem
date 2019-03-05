package demo.dao;

import demo.pojo.blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface blogMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(blog record);

    int insertSelective(blog record);

    blog selectByPrimaryKey(Integer blogId);

    int updateByPrimaryKeySelective(blog record);

    int updateByPrimaryKeyWithBLOBs(blog record);

    int updateByPrimaryKey(blog record);

    int insertBlog(blog record);

    int selectByUserId(int userId);

    List<blog> selectBlogByUserIdAndClassId(@Param("userId")int userId, @Param("classId")int classId);
}