package proj4;


/**
 * This class is designed to assist in ensuring that the left parenthesis symbol is
 * handled properly in a postfix notation.
 *
 * @author Laura Marlin
 *  @version October 27, 2018
 */
public class LeftParen implements Token {

    private String symbol;

    /**
     * This is the template when creating a new Left Paren Object
     */
    public LeftParen(){
        symbol= "(";
    }

    /**
     * @return the symbol for left parenthesis
     */
    public String toString() {
        return symbol;
    }

    /**
     * This pushes the left parenthesis on the stack so that it can processed
     * @param s the proj4.Stack the token uses, if necessary, when processing itself.
     * @return An empty string
     */
    public String handle(Stack<Token> s) {
        s.push(this);
        return"";
    }
}
