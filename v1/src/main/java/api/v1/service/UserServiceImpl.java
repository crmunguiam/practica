package api.v1.service;

import api.v1.entity.User;
import api.v1.json.*;
import api.v1.repository.UserRepository;
import api.v1.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Items getUser(String name) {
        Items userList = new Items();
        List<UserListResponse> usersList = new ArrayList<>();
        List<User> users = userRepository.findByName(name);
        if(users==null) {
            String rfc= name;
            users = userRepository.findByRfc(rfc);
        }
        for(User user:users ) {
            UserListResponse userListResponse = new UserListResponse();
            userListResponse.setKeyUser(user.getId().toString());
            userListResponse.setName(user.getName());
            userListResponse.setLastName(user.getLastName());
            userListResponse.setSurname(user.getSurname());
            Profile profile= new Profile();
            if(user.getGender().equals("1"))
                profile.setName("FEMENINO");
            else
                profile.setName("MASCULINO");
            profile.setId(user.getGender());
            userListResponse.setProfile(profile);
            userListResponse.setRfc(user.getRfc());

            Workshift workshift = new Workshift();
            workshift.setId(user.getWorshift());
            if(user.getWorshift().equals(1))
                workshift.setName("MATUTINO");
            else
                workshift.setName("VESPERTINO");
            userListResponse.setWorkshift(workshift);
            userListResponse.setStatus(true);
            usersList.add(userListResponse);
        }
        userList.setUserList(usersList);
        return userList;
    }

    public List<User> getUserOrRfc(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User createUser(UserRequest userRequest) {


        if(userRequest.getId()!=null) {
            User userDB =getUser(userRequest.getId());
            if (null != userDB) {
                userDB.setBirthdate(Util.formatFecha(userRequest.getBirthdate()));
                userDB.setName(userRequest.getName());
                userDB.setGender(userRequest.getGender());
                userDB.setLastName(userRequest.getLastName());
                userDB.setPhone(userRequest.getPhone());
                userDB.setPin(userRequest.getPin());
                userDB.setRfc(userRequest.getRfc());
                userDB.setWorshift(userRequest.getWorshift());
                userDB.setSurname(userRequest.getSurname());
                return userRepository.save(userDB);
            }
        }else{
            User userDB = new User();
            userDB.setBirthdate(Util.formatFecha(userRequest.getBirthdate()));
            userDB.setName(userRequest.getName());
            userDB.setGender(userRequest.getGender());
            userDB.setLastName(userRequest.getLastName());
            userDB.setPhone(userRequest.getPhone());
            userDB.setPin(userRequest.getPin());
            userDB.setRfc(userRequest.getRfc());
            userDB.setWorshift(userRequest.getWorshift());
            userDB.setSurname(userRequest.getSurname());
            return userRepository.save(userDB);

        }
        return null;
    }

}