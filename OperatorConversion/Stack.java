package proj4;

/**
 * This class is designed to implement a stack, a form of data structure in which
 * the user can only add and remove from one end of the data. Thus the behavior is
 * a first in, last out structure.
 *
 * @author Laura Marlin
 *  @version October 27, 2018
 */
public class Stack<T>
{

    private Object[] data;
    private int manyItems;
    private final int INITIAL_CAPACITY = 10;


    /**
     * This is the template for a new stack object
     * Inspired by Data Structures by Michael Main page 338
     */
    public Stack() {
        manyItems= 0;
        data= new Object[INITIAL_CAPACITY];
       
    }


    // BOOLEAN TESTS
    //--------------------------------------------------------------------------------------

    /**
     * This checks whether the stack is empty
     * @return boolean answer to if the stack is empty
     */
    public boolean isEmpty() {
        return manyItems ==0;
    }

    /**
     * This ensures that the inputted capacity is valid
     * @param attemptedCapacity: value for the capacity to change too
     */
    private boolean isValidCapacity(int attemptedCapacity){
        return attemptedCapacity>=0;
    }

    /**
     * This checks to see if the stack's data is full
     * @return boolean answer to whether the stack is full
     */
    private boolean isAtEnd(){
        return manyItems== data.length;
    }







    // CHANGING THE STACK
    //--------------------------------------------------------------------------------------

    /**
     * This function adds a new item to the stack. If the stack is full then it expands the
     * size of the stack to fill in the new item.
     * Inspired by Data Structures by Michael Main page 340
     * @param toPush new data to be put onto stack
     */
    public void push(T toPush) {
        if(isAtEnd()){
            ensureCapacity(manyItems*2+1);
        }
        setItemInData(manyItems, toPush);
        setManyItems(manyItems+1);



       
    }


    /**
     * This removes the top item off the stack and returns it.
     * If it is empty then null is returned.
     * Inspired by Data Structures by Michael Main page 340
     * @return the top item off the stack
     */
    public T pop() {
        if(!isEmpty()) {
            T answer= getItemInData(--manyItems);
            setItemInData(manyItems, null);
            return answer;
        }
        return null;

    } 









    //GETTERS AND SETTERS
    //--------------------------------------------------------------------------------------

    /**
     * This returns the value of the top item in the stack without removing it.
     * If the stack is empty then null is returned.
     * @return The value of the top object in the stack
     */
    public T peek() {
        if(!isEmpty()) {
            return getItemInData(manyItems-1);
        }
        return null;

    }

    /**
     * @return the number of items in the stack
     */
    public int size() {
        return manyItems;
    }

    /**
     * @return the capacity of the sequence.
     */
    private int getCapacity()
    {
        Object[] currentData= getData();
        return currentData.length;
    }

    /**
     * This obtains the array from sequence that holds the inputted values
     * @return string array containing the values inputted
     */
    private Object[] getData(){
        return data;
    }


    /**
     * This creates a new string array, with the same contents as the original,
     * to a specified size and then sets the sequence data pointer to the new array
     * @param newCapacity the new size of array
     */
    private void makeNewData(int newCapacity) {
        int newQuantity= size();
        if (isValidCapacity(newCapacity)){
            Object[] newData = new String[newCapacity];
            for(int i=0; i<newQuantity; i++){
                newData[i]= getItemInData(i);
            }

            setData(newData);


        }
    }

    /**
     * Obtains the value of an item in data at a specific location
     * @param index location in data to obtain from
     * @return the item contained within data at the specified index
     */
    private T getItemInData(int index){
        return (T) data[index];
    }

    /**
     * This set's the sequence's data array to a new array
     * @param newDataArray a new data array for sequence
     */
    private void setData(Object[] newDataArray){
        data= newDataArray;
    }


    /**
     * Changes the value of an item at a specific location in data
     * @param index: location in the data array to set
     * @param item: value to set the item in data too
     */
    private void setItemInData(int index, T item){
        data[index]= item;
    }



    /**
     * Changes the instance variable manyItems to a new value
     * @param newCount the new value of manyItems
     */
    private void setManyItems(int newCount){
        manyItems= newCount;
    }










    //MISCELLANEOUS
    //--------------------------------------------------------------------------------------


    /**
     * Produce a string representation of this stack.  The top
     * is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the top element, would print as:
     *
     *    {>B, A}
     *An empty sequence should give back "{}".
     *
     * @return a string representation of this sequence.
     */
    public String toString() {
        int lastItem= size()-1;

        String beginning= "{>";
        String ending= "}";

        String middle="";



        for(int i=lastItem; i>=0; i--){
            T currentItem= getItemInData(i);


            middle= middle+currentItem;


            if(i != 0){
                middle= middle+ ", ";
            }


        }

        return beginning+middle+ending;

    }





    //CHANGING CAPACITY
    //--------------------------------------------------------------------

    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    private void ensureCapacity(int minCapacity)
    {
        int currentCapacity= getCapacity();

        if(currentCapacity< minCapacity){
            makeNewData(minCapacity);
        }

    }


} 
   

