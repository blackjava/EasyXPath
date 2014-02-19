package xml.xpath.expression;

import i18n.ErrorCode;

public class UnsupportedExpressionException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String[] details;
    
    public UnsupportedExpressionException(ErrorCode errorCode, String... details) {
        this.errorCode = errorCode;
        this.details = details;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
    
    public String[] getDetails() {
        return details;
    }
}
