package proj4;



/**
 * This class is designed to assist in ensuring that the semicolon symbol is handled correctly
 * for a postfix notation
 *
 * @author Laura Marlin
 *  @version October 27, 2018
 */

public class Semicolon implements Token {

    private String symbol;

    /**
     * This is the template for creating a new SemiColon object
     */
    public Semicolon(){
        symbol= ";";
    }

    /**
     * @return The symbol that represents a semicolon
     */
    public String toString() {
        return symbol;
    }

    /**
     * This works with the Stack to ensure that the proper order of operations is created
     * for the postfix notation
     * @param s the proj4.Stack the token uses, if necessary, when processing itself.
     * @return items returned from the stack that need to be added to postfix
     */
    public String handle(Stack<Token> s)
    {
        return handleHelper(s);

    }

    /**
     * This removes the proper items from the stack and saves them in a string for
     * the postfix notation.
     *
     * In this case, all items are removed from the stack until it is empty.
     * @param s
     * @return the symbols removed from the stack to be added to the postfix notation
     */
    private String handleHelper(Stack<Token> s){
        String answer="";
        if(s.isEmpty()){
            return answer;
        }
        else{
            answer= s.pop()+ handleHelper(s);
            return answer;
        }

    }
	
}
