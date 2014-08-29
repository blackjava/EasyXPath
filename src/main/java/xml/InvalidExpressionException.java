package xml;

import i18n.ErrorCode;

/**
 *
 */
public class InvalidExpressionException extends Exception {
    private final ErrorCode errorCode;

    public InvalidExpressionException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
