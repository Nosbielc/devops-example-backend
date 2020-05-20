package nosbielc.com.devops.example.backend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends Exception {
    public ValidationException (String message) {
        super(message);
    }
}
