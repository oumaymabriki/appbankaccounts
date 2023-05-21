package contact;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactService {
  @Autowired
    private ContactRepository contactRepository;
 @Autowired
  private ContactMapper mapper;

    public  Integer saveContact(ContactRequest contactRequest){

    return contactRepository.save(mapper.ToContact(contactRequest)).getId();
  }
    public  List<ContactResponse> allContactByUserId (Integer userId){
      return (List<ContactResponse>) contactRepository.findAllByUserId(userId)
              .stream()
              .map(mapper::ToResponse)
              .collect(Collectors.toList());
  }

    public  ContactResponse contactById(Integer id){
      return contactRepository.findById(id)
              .map(mapper::ToResponse)
              .orElseThrow(() -> new EntityNotFoundException("this entity not found with " +id));
  }

  public void deleteContact(Integer id){
      contactRepository.deleteById(id);
  }
}
