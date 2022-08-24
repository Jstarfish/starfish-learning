package ink.starfish.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * TODO
 *
 * @author: starfish
 * @date: 2022/8/10 16:15
 **/
public class GlobalException extends ResponseStatusException {
    public GlobalException(HttpStatus status, String message) {
        super(status, message);
    }
    public GlobalException(HttpStatus status, String message, Throwable e) {
        super(status, message, e);
    }
}
