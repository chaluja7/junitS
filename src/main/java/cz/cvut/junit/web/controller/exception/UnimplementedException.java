package cz.cvut.junit.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sange on 19/04/16.
 */

public class UnimplementedException extends RuntimeException {

    public UnimplementedException(String message) {
        super(message);
    }
}
