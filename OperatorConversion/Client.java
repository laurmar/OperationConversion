package proj4;

/**
 * This class is designed to be the user interface of the infix to postfix project.
 * 
 * @author Laura Marlin
 * @version October 27, 2018
 */

public class Client
{

    /**
     * This client implements the infix to postfix notation converter
     */
    public static void main(String[] args)
    {
        Converter newConverter= new Converter("src/proj4/proj4_input.txt");
        newConverter.convert();

       
    }
}

