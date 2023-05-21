package contact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/contacts")
public class ContactController {
    private final ContactService contactService;

    @PostMapping()
    public Integer save(@RequestBody  ContactRequest contactRequest){
        return contactService.saveContact(contactRequest);
    }
    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<ContactResponse>> findAll(@PathVariable("user-id") Integer id){
          return ResponseEntity.ok(contactService.findAllByUserId(id));
    }
    @GetMapping("/{contact-id}")
     public ResponseEntity<ContactResponse> findById(@PathVariable("contact-id") Integer id )
    {
        return ResponseEntity.ok(contactService.findById(id));
    }
    @DeleteMapping("/{contact-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteContact(
            @PathVariable("contact-id") Integer id )
    {
        contactService.deleteContact(id);
    }

}
