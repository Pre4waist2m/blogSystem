package demo.service.IService;

import demo.commen.ServerResonse;

public interface IUserService {
    public <user>ServerResonse<user> login(String userName, String password);
    public ServerResonse regiester(String userName, String password);
}
