package user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Integer save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> allusers(){
        return userService.getAll() ;
    }
    @GetMapping("/{user_id}")
    public UserResponse getUser(@PathVariable Integer user_id){
        return userService.getUserById(user_id);
    }
}
