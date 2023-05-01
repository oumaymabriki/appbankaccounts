package contact;

import org.springframework.stereotype.Component;
import user.User;

@Component
public class ContactMapper {
  public Contact ToContact(ContactRequest contactRequest){
      return Contact.builder()
              .id(contactRequest.getId())
              .firstname(contactRequest.getFirstname())
              .lastname(contactRequest.getLastname())
              .email(contactRequest.getEmail())
              .iban(contactRequest.getIban())
              .user(
                      User.builder()
                              .id(contactRequest.getUserId())
                              .build()
              )
              .build();
  }
  public ContactResponse ToResponse(Contact contact){
         return ContactResponse.builder()
                 .id(contact.getId())
                 .firstname(contact.getFirstname())
                 .lastname(contact.getLastname())
                 .email(contact.getEmail())
                 .iban(contact.getIban())
                 .build();
  }
}
