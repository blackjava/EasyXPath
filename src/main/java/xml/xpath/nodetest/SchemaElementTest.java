package xml.xpath.nodetest;

import static xml.xpath.expression.EQName.EQNAME_PATTERN;

import i18n.ErrorCode;
import xml.xpath.NodeTest;
import xml.xpath.UnsupportedExpressionException;

public class SchemaElementTest implements NodeTest {
    private static final String SCHEMAELEMENTTEST_PATTERN = "schema-element\\(" + EQNAME_PATTERN + "\\)";
    
    public SchemaElementTest() {
        throw new UnsupportedExpressionException(ErrorCode.UNSUPPORTED_NODETEST_SCHEMAELEMENTTEST);
    }
    
    public static boolean isSchemaElementTest(String expression) {
        return expression.matches(SCHEMAELEMENTTEST_PATTERN);
    }
}
