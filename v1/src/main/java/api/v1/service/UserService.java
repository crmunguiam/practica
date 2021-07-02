package api.v1.service;

import api.v1.entity.User;
import api.v1.json.Items;
import api.v1.json.UserRequest;

public interface UserService {
    User getUser(Long id);
    Items getUser(String name);
    User createUser(UserRequest userRequest);
}
