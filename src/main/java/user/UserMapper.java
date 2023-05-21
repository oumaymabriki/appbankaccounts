package user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
   public User ToUser(UserRequest request){
       return User.builder()
               .id(request.getId())
               .firstName(request.getFistrname())
               .lastname(request.getLastname())
               .email(request.getEmail())
               .password(request.getPassword())
               .build();
   }
   public UserResponse ToResponse(User user){
       return UserResponse.builder()
               .id(user.getId())
               .firsname(user.getFirstName())
               .lastname(user.getLastname())
               .email(user.getEmail())
               .iban(user.getIban())
               .active(user.isActive())
               .build();
   }
}
