package xml.xpath;

/**
 * A step is a part of a path expression that generates a sequence of items and 
 * then filters the sequence by zero or more predicates. The value of the step 
 * consists of those items that satisfy the predicates, working from left to 
 * right.
 */
public abstract class Step {
    public static Step parse(String expression) {
        return AxisStep.parse(expression);
    }
}
