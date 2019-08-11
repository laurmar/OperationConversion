package proj4;

/**
 * This class is designed to obtain data from a filereader and then convert equations from
 * an infix notation to a postfix notation
 * 
 * @author Laura Marlin
 *  * @version October 27, 2018
 */
public class Converter {

	private FileReader reader;
	private Stack stack;
	private String postfix;
	private String infix;

	
	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
    	reader= new FileReader(infile);
    	stack= new Stack();
    	postfix="";
    	infix="";

        
    }


    //CONVERT
    //---------------------------------------------------------------------------------------

	/**
	 * This method reads  tokens from the filereader, generates a infix and postfix response
	 * and then displays those responses line by line.
	 */
    public void convert(){

    	String currentItem=reader.nextToken();

    	while(currentItem != "EOF"){
			addToInfix(currentItem);

    		String response= getPostFixResponse(currentItem);
			addToPostfix(response);

			display(currentItem);
    		currentItem= reader.nextToken();
		}


	}












	//GETTERS AND SETTERS
	//---------------------------------------------------------------------------------------

	/**
	 * This function takes in a token and then handles converting it into
	 * postfix notation.
	 *
	 * If it is a operand then then it is merely added to the postfix response.
	 * Otherwise the token is told to handle itself.
	 * @param currentItem This is the current token that is being evaluated
	 * @return a portion of the postfix equation, based on the inputted token
	 */
	private String getPostFixResponse(String currentItem){
		String response="";
		if(isLetter(currentItem)){
			response= currentItem;
		}
		else {
			Token token= tokenize(currentItem);
			response= token.handle(stack);
		}
		return response;
	}











	//BOOLEAN TESTS
	//---------------------------------------------------------------------------------------

	/**
	 * This checks to see if the computer has reached the end of an equation
	 * @param item this is a token from the file to be evaluated
	 * @return boolean response to if it is a semicolon
	 */
	private boolean isEndofLine(String item){
    	return item.equals(";");

	}

	/**
	 * This checks to see if the current item is a letter
	 * @param item this is a token from the file to be evaluated
	 * @return boolean response to if it is a semicolon
	 */
	private boolean isLetter(String item) {
		return item.matches("[A-Z]");
	}












	//MISCELLANEOUS
	//---------------------------------------------------------------------------------------

	/**
	 * This adds an item to the postfix
	 * @param item token from the file to be added to postfix
	 */
	private void addToPostfix(String item){
		postfix+=item;
	}

	/**
	 * This adds an item to the infix as long as it isnt the end of the line
	 * @param item token from the file to be added to infix
	 */
	private void addToInfix(String item){
		if(!isEndofLine(item)){
			infix+=item;
		}
	}


	/**
	 * This helps organize the official structure of the displayed data
	 * @return the structured displayed response
	 */
	private String prepDisplay(){
			return infix + " --> " + postfix;
	}


	/**
	 * This resets the stack, postfix, and infix for a new equation
	 */
	private void makeNewEquation(){
    	stack= new Stack();
		postfix="";
		infix="";
	}


	/**
	 * This displays the current equation when a semicolon is reached
	 * and then resets the display and stacks for future equations
	 * @param currentItem this is the current token that is being evaluated
	 */
	private void display(String currentItem){
		if(isEndofLine(currentItem)){
			System.out.println(prepDisplay());
			makeNewEquation();
		}
	}


	/**
	 * This converts a string to a token based on the inputted string value
	 * @param item the current item to be evaluated
	 * @return a token
	 */
	private Token tokenize(String item){
		Token answer;
		if(item.equals("+")){
			answer= new Plus();
		}
		else if(item.equals("(")){
			answer= new LeftParen();

		}
		else if(item.equals("/")){
			answer= new Divide();
		}
		else if(item.equals("^")){
			answer = new Exponent();
		}
		else if(item.equals("-")){
			answer= new Minus();

		}
		else if(item.equals("*")){
			answer= new Multiply();


		}
		else if(item.equals(")")){
			answer= new RightParen();

		}

		else{
			answer= new Semicolon();

		}
		return answer;
	}



}

