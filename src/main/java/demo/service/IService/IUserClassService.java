package demo.service.IService;

import demo.commen.ServerResonse;
import demo.pojo.userClass;

public interface IUserClassService {
    public ServerResonse insertOrUpdateNumber(userClass record);
    public ServerResonse getClassAndNumberByUserId(int userId);
    public ServerResonse getBlog(int userId);
}
