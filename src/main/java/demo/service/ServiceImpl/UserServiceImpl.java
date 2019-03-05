package demo.service.ServiceImpl;

import demo.commen.ServerResonse;
import demo.dao.userMapper;
import demo.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private userMapper user_mapper;

    @Override
    public <user>ServerResonse<user> login(String userName,String password){
        if(user_mapper.checkUserName(userName)==0){
            return ServerResonse.CreateDefeat("用户不存在！");
        }
        if(user_mapper.checkAndSelectUser(userName,password)==null){
            return ServerResonse.CreateDefeat("密码错误！");
        }
        return ServerResonse.CreateSuccessAndReturn(user_mapper.checkAndSelectUser(userName,password),"登陆成功！");
    }
    @Override
    public ServerResonse regiester(String userName,String password){
        if(user_mapper.checkUserName(userName)!=0){
            return ServerResonse.CreateDefeat("用户已被注册！");
        }
        if(user_mapper.insertNewUser(userName,password)==0){
            return ServerResonse.CreateDefeat("数据库错误！");
        }
        return ServerResonse.CreateSuccess("注册成功！");

    }
}
