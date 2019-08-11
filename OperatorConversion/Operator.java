package proj4;

/**
 * Describes the methods that must be defined in order for an
 * object to be considered an operator.  Every operator must have a getPrecedence method.
 * 
 * @author Laura Marlin
 * @version 10/29/18
 *
 */
public interface Operator
{

	/**
	 * This gets the operator's precedence level .
	 * @return the operators precedence lever
	 */
	public int getPrecedence();

}
