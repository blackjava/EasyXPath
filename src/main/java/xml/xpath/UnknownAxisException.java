package xml.xpath;

/**
 *
 */
public class UnknownAxisException extends Exception {
    private final String axisName;
    
    public UnknownAxisException(String axisName) {
        this.axisName = axisName;
    }
}
