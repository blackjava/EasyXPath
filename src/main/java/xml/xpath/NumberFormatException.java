package xml.xpath;

import i18n.ErrorCode;

public class NumberFormatException extends java.lang.NumberFormatException {
    private final ErrorCode errorCode;
    private final String[] parameters;
    
    public NumberFormatException(Throwable cause, ErrorCode errorCode, String... parameters) {
        this.errorCode = errorCode;
        this.parameters = parameters;
        
        super.addSuppressed(cause);
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
    
    public String[] getParameters() {
        return parameters;
    }
}
