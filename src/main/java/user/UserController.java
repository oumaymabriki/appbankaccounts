package user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public Integer save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> allusers(){
        return userService.getAll() ;
    }
    @GetMapping("/{user_id}")
    public UserResponse getUser(@PathVariable Integer user_id)
    {
        return userService.getUserById(user_id);

    }
    @PatchMapping("/activate/{user-id}")
    public Integer validate(@PathVariable("user-id") Integer id){
      return userService.ValidateAccount(id);
    }

    @PatchMapping("/inactivate/{user-id}")
    public Integer Invalidate(@PathVariable("user-id") Integer id){
      return userService.InactiveAccount(id);
    }
}
