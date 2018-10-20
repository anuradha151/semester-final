package lk.anuradha.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = " Data Validation Failed... Check And Input Valid Data")
public class ValidateException extends RuntimeException {

}
