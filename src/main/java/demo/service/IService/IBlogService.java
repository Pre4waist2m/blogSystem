package demo.service.IService;

import demo.commen.ServerResonse;
import demo.pojo.blog;

public interface IBlogService {
    public <Integer>ServerResonse selectBlogIdByContent(String classContent);
    public  ServerResonse insertBlog(blog record);
}
