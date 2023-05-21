package handler;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class ExceptionResponse {

    private String ErrorMsg;
    private String ErrorsSources;
    private Set<String> validationsErrors;
}
