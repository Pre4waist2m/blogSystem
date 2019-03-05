package demo.dao;

import demo.pojo.blog_class;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface blog_classMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(blog_class record);

    int insertSelective(blog_class record);

    blog_class selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(blog_class record);

    int updateByPrimaryKey(blog_class record);

    int selectClassIdByContent(String classContent);
}