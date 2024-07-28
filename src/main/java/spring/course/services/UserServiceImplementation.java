package spring.course.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.course.model.UserModel;

import java.util.HashMap;
import java.util.Map;

@Service
@Qualifier("primary")
public class UserServiceImplementation implements UserService{

    private final TimeService timeService;
    private final Map<String, UserModel> userMap = new HashMap<>();

    public UserServiceImplementation(TimeService timeService) {
        this.timeService = timeService;
        userMap.put("John", new UserModel("John", "Doe", 1234));
        userMap.put("Jane", new UserModel("Jane", "Doe", 5432));
    }

    public UserModel getUser(String userName){
        return userMap.get(userName);
    }

    public void addUser(UserModel user){
        user.setCreationTime(timeService.getCurrentTime("Warsaw"));
        userMap.put(user.getFirstName(), user);
    }
    public void deleteUser(String userName){
        userMap.remove(userName);
    }



}
