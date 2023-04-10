package Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
@RequiredArgsConstructor
public class ObjectToValidateExeption extends RuntimeException {
    @Getter
    private final Set<String> errors;
    @Getter
    private final String errorsSource;



}
