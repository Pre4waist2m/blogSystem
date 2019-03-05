package demo.service.ServiceImpl;

import demo.commen.ServerResonse;
import demo.dao.blogMapper;
import demo.dao.blog_classMapper;
import demo.pojo.blog;
import demo.service.IService.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private blog_classMapper blogClassMapper;
    @Autowired
    private blogMapper blog_mapper;
    @Override
    public <Integer>ServerResonse selectBlogIdByContent(String classContent){
        if(blogClassMapper.selectClassIdByContent(classContent)==0){
            return ServerResonse.CreateDefeat("数据库无此分类");
        }else
            return ServerResonse.CreateSuccess(blogClassMapper.selectClassIdByContent(classContent));
    }
    @Override
    public  ServerResonse insertBlog(blog record){
        if(blog_mapper.insertBlog(record)==0){
            return ServerResonse.CreateDefeat("写入文章失败");
        }else{
            return ServerResonse.CreateSuccess("博客写入成功");
        }
    }



}
