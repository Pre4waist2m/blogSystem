package demo.service.ServiceImpl;

import demo.commen.ServerResonse;
import demo.dao.blogMapper;
import demo.dao.blog_classMapper;
import demo.dao.userClassMapper;
import demo.pojo.blog;
import demo.pojo.userClass;
import demo.pojo.userClassKey;
import demo.service.IService.IUserClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserClassServiceImpl implements IUserClassService {
    @Autowired
    private userClassMapper user_classMapper;
    @Autowired
    private blogMapper blog_mapper;
    @Autowired
    private blog_classMapper blogClassMapper;
    @Override
    public ServerResonse insertOrUpdateNumber(userClass record){
        userClassKey user_classKey=new userClassKey(record.getUserId(),record.getClassId());
        if(user_classMapper.selectByPrimaryKey(user_classKey)==null){
            if(user_classMapper.insert(record)==0){
                return ServerResonse.CreateDefeat("数据库错误");
            }
                return ServerResonse.CreateSuccess("插入成功");
        }else{
            if(user_classMapper.updateNumber(record.getUserId(),record.getClassId())==0){
                return ServerResonse.CreateDefeat("分类表更改失败");
            }
                return ServerResonse.CreateSuccess("分类表更改成功");
        }
    }
    @Override
    public ServerResonse getClassAndNumberByUserId(int userId){
        if(blog_mapper.selectByUserId(userId)==0){
            return ServerResonse.CreateSuccess("该用户未有文章");
        }
        List<userClass> userClassList=new LinkedList();
        /*存放userClass对象*/
        userClassList=user_classMapper.selectObjectByUserId(userId);
        if(userClassList==null){
            return ServerResonse.CreateDefeat("数据库错误！");
        }
        Map classAndNumber=new HashMap();
        /*存放classContent和number的key-value*/
        for(userClass user_class:userClassList){
            classAndNumber.put(blogClassMapper.selectByPrimaryKey(user_class.getClassId()).getClassContent(),user_class.getNumber()) ;
        }
        return ServerResonse.CreateSuccessAndReturn(classAndNumber,"返回分类成功");
    }
    @Override
    public ServerResonse getBlog(int userId){
        if(blog_mapper.selectByUserId(userId)==0){
            return ServerResonse.CreateSuccess("该用户未有文章");
        }
        List<userClass> userClassList=new LinkedList<>();
        userClassList=user_classMapper.selectObjectByUserId(userId);
        if(userClassList==null){
            return ServerResonse.CreateDefeat("数据库错误！");
        }
        /*一个用户对应多个分类，一个分类对应多篇文章
        * 分类集合里面嵌套每个分类对应多篇文章集合*/
        List<List<blog>> blogList=new LinkedList<>();
        for (userClass u:userClassList) {
            blogList.add(blog_mapper.selectBlogByUserIdAndClassId(u.getUserId(),u.getClassId()));
        }
        if(blogList==null){
            return ServerResonse.CreateDefeat("文章列表返回错误");
        }
        return ServerResonse.CreateSuccessAndReturn(blogList,"成功");
    }

}
