package proj4;

/**
 * This class is designed to assist in ensuring that the minus symbol is put in
 * the right place in a postfix notation.
 *
 * @author Laura Marlin
 *  @version October 27, 2018
 */

public class Minus implements Token, Operator{
    private int precedence;
    private String value;

    private final int PRECEDENCE= 1;

    /**
     * This creates a new minus object
     */
    public Minus(){
        precedence= PRECEDENCE;
        value= "-";

    }

    /**
     * @return the symbol for minus
     */
    public String toString() {

        return value;
    }

    /**
     * This works with the Stack to ensure that the proper order of operations is created
     * for the postfix notation.
     *
     * In this case we remove some operators and then push a minus object onto the stack
     * @param s the proj4.Stack the token uses, if necessary, when processing itself.
     * @return items returned from the stack that need to be added to postfix
     */
    public String handle(Stack<Token> s)
    {
        String answer=handleHelper(s);
        s.push(this);
        return answer;
    }

    /**
     *
     * @return the precendence for minus
     */
    public int getPrecedence(){
        return precedence;
    }


    /**
     * This removes the proper items from the stack and saves them in a string for
     * the postfix notation.
     *
     * In this case, all items are removed from the stack until it is empty, the next item is
     * a left parenthesis, or the next item's precedence is lower.
     * @param s The stack on which the program is adding and removing operators
     * @return the symbols removed from the stack to be added to the postfix notation
     */
    private String handleHelper(Stack<Token> s){
        String answer="";
        if (s.isEmpty()|| (s.peek() instanceof LeftParen) || isLower(s.peek())){
            return answer;
        }
        else{
            answer= s.pop()+ handleHelper(s);
            return answer;
        }

    }


    /**
     * @param item current item to be evaluated
     * @return this checks if the current item is an operator
     */
    private boolean isOperator(Token item) {
        return (item instanceof Operator);
    }


    /**
     * This looks at precedences of operators to see how they compare to Minus
     * @param item current item to be evaluated
     * @return whether divide has a higher precedence than the evaluated item
     */
    private boolean isLower(Token item) {
        if (isOperator(item)) {
            Operator operator = (Operator) item;
            return this.getPrecedence() > operator.getPrecedence();

        }
        return false;
    }

}
