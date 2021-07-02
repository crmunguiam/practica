package api.v1.service;

import api.v1.entity.User;
import api.v1.json.Items;
import api.v1.json.Profile;
import api.v1.json.UserListResponse;
import api.v1.json.Workshift;
import api.v1.repository.UserRepository;
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
    public User createUser(User user) {
        user.setBirthdate(new Date());

        if(user.getId()!=null) {
            User userDB =getUser(user.getId());
            if (null != userDB) {
                userDB.setName(user.getName());
                userDB.setBirthdate(user.getBirthdate());
                userDB.setGender(user.getGender());
                userDB.setLastName(user.getLastName());
                userDB.setPhone(user.getPhone());
                userDB.setPin(user.getPin());
                userDB.setRfc(user.getRfc());
                userDB.setWorshift(user.getWorshift());
                userDB.setSurname(user.getSurname());
                return userRepository.save(userDB);
            }
        }else{
            return userRepository.save(user);

        }
        return null;
    }

}