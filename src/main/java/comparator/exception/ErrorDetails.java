package comparator.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {

    private String status;
    private String message;
    private String field;

    public ErrorDetails(String status, String message) {
        this.status = status;
        this.message = message;
    }
}