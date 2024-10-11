package Products;

import java.io.Serial;

public class CustomException extends Exception{

    @Serial
    private static final long serialVersionUID = -4406558825639364387L;
    int status;
    String error;
    public CustomException(String c){
        super(c);
    }

    public CustomException(String errorMessage, int status){
        this.error = errorMessage;
        this.status = status;

    }
}
