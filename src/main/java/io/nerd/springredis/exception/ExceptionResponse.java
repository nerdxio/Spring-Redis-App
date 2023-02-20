package io.nerd.springredis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String path;

}
