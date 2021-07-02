package api.v1.controller;

import api.v1.json.Items;
import api.v1.util.ErrorMessage;
import api.v1.json.UserResponse;
import api.v1.entity.User;
import api.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (null == user) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/users/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<Items> getUsers(@RequestParam String nombre ) {
        Items userListResponse = userService.getUser(nombre);
        if (null == userListResponse.getUserList()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userListResponse);
    }

    @RequestMapping(value = "/user/saveOrUpdate", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<UserResponse> createProduct(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        User userCreate = userService.createUser(user);
        UserResponse  userResponse = new UserResponse ();
        userResponse.setId(userCreate.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
