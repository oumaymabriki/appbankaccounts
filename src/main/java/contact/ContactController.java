package contact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {


    private final ContactService contactService;

    @PostMapping()
    public Integer save(@RequestBody  ContactRequest contactRequest){
        return contactService.saveContact(contactRequest);
    }
    @GetMapping()
    public ResponseEntity<List<ContactResponse>> findall(){
        return ResponseEntity.ok(contactService.allContact());
    }
}
