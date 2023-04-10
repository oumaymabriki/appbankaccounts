package validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import Exception.ObjectToValidateExeption;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ValidateObject<T> {
    //factory heya hstjibli validate

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();
    public void Validate(T objectToValidate){
       Set<ConstraintViolation<T>> violationSet = validator.validate(objectToValidate);
       if(!violationSet.isEmpty()){
            Set<String> errorMsgs = violationSet
                   .stream()
                   .map(ConstraintViolation::getMessage)
                   .collect(Collectors.toSet());
            throw new ObjectToValidateExeption(errorMsgs, objectToValidate.getClass().getName());

       }
    }



}
