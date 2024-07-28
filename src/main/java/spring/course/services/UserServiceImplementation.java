package spring.course.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.course.data.UserEntity;
import spring.course.data.UserRepository;
import spring.course.mapper.EntityMapper;
import spring.course.model.UserModel;

import java.util.HashMap;
import java.util.Map;

@Service
@Qualifier("primary")
public class UserServiceImplementation implements UserService{

    private final TimeService timeService;
    private final UserRepository userRepository;
    private final EntityMapper<UserEntity, UserModel> enityMapper;

    public UserServiceImplementation(TimeService timeService, UserRepository userRepository, EntityMapper<UserEntity, UserModel> enityMapper) {
        this.timeService = timeService;
        this.userRepository = userRepository;
        this.enityMapper = enityMapper;
    }

    public UserModel getUser(String userName){
        return enityMapper.map(userRepository.findByFirstName(userName));
    }

    public void addUser(UserModel user){
        user.setCreationTime(timeService.getCurrentTime("Warsaw"));
        userRepository.save(enityMapper.reverseMap(user));
    }
    @Transactional
    public void deleteUser(String userName){
        userRepository.deleteByFirstName(userName);
    }



}
