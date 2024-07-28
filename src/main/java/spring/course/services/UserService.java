package spring.course.services;

import spring.course.model.UserModel;

public interface UserService {

    UserModel getUser(String userName);
    void addUser(UserModel userName);
    void deleteUser(String userName);

}
