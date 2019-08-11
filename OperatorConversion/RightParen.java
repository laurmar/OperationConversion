package proj4;


/**
 * This class is designed to assist in ensuring that the right parenthesis  symbol is
 * handled properly in a postfix notation.
 *
 * @author Laura Marlin
 *  @version October 27, 2018
 */
public class RightParen implements Token {

    private String symbol;

    /**
     * This is the template for a new right parenthesis object
     */
    public RightParen(){
        symbol= ")";
    }

    /**
     * @return the symbol that represents a right parenthesis
     */
    public String toString() {
        return symbol;
    }


    /**
     * This works with the Stack to ensure that the proper order of operations is created
     * for the postfix notation.
     *
     * In this case operators are removed until a left parenthesis is found.
     * Both the right and left parethesis are discarded.
     * @param s the proj4.Stack the token uses, if necessary, when processing itself.
     * @return items returned from the stack that need to be added to postfix
     */
    public String handle(Stack<Token> s) {
        String answer= handleHelper(s);
        s.pop();
        return answer;
    }

    /**
     * This removes the proper items from the stack and saves them in a string for
     * the postfix notation.
     *
     * In this case, all items are removed from the stack until it is empty or the next item is
     * a left parenthesis.
     * @param s The stack on which the program is adding and removing operators
     * @return the symbols removed from the stack to be added to the postfix notation
     */
    private String handleHelper(Stack<Token> s){
        String answer="";
        if(s.isEmpty() || (s.peek() instanceof LeftParen)){
            return answer;
        }
        else{
            answer= s.pop()+ handleHelper(s);
            return answer;
        }

    }
	
}
