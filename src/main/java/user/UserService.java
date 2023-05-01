package user;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import validator.ValidateObject;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper mapper;
    @Autowired
    private ValidateObject<UserRequest> validateObject;


    public Integer save(UserRequest request){
       //validate userRequest
        validateObject.Validate(request);
        return userRepository.save(mapper.ToUser(request)).getId();
    }
    public ResponseEntity<List<UserResponse>> getAll(){
        return (ResponseEntity<List<UserResponse>>) userRepository.findAll()
                .stream()
                .map(mapper::ToResponse)
                .collect(Collectors.toList())
                ;
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    public UserResponse getUserById(Integer id){
        return userRepository.findById(id)
                .map(mapper::ToResponse)
                .orElseThrow(() -> new EntityNotFoundException("entity not found with this id"+id))
                ;
    }
}
