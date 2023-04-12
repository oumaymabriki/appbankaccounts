package user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
   public User ToUser(UserRequest request){
       return User
               .id(request.getId())
               .firstname(request.getFistrname())
               .lastname(request.getLastname())
               .email(request.getEmail())
               .password(request.getPassword())
               .builder()
               .build();
   }
   public UserResponse ToResponse(User user){
       return UserResponse
               .id(user.getId())
               .firstname(user.getFirstName())
               .lastname(user.getLastname())
               .email(user.getEmail())
               .password(user.getPassword())
               .iban(user.getAccount().getIban())
               .active(user.isActive())
               .builder()
               .build();
   }
}
