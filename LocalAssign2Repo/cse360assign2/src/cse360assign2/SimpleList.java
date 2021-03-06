/**
 * Author: Matthew Szeto
 * Class ID: 195
 * Assignment: 2
 */

package cse360assign2;
import java.util.*;
/**
 * 
 * @author Matthew Szeto
 * This class creates a simple list. The list size is increased by 50% when appended to or
 * added to. The size is decreased by 25% when there is more that 25% slots in the array
 * not used.
 *
 */

public class SimpleList {
	
	private int list[];
	private int count;
	
	/**
	 * Constructor for simple list
	 */
	
	public SimpleList(){
		this.list = new int[10];
		this.count = 0;
	}
	
	/**
	 * This method adds an integer to index 0 of the list and shifts the 
	 * other elements right. If there is not enough space, the new array size
	 * is 1.5x the old size.
	 * @param numToBeAdded is the int to be added
	 * @return none
	 */
	
	public void add(int numToBeAdded)
	{
		if(this.count + 1 > this.list.length)//count should never be greater than the length of the list
		{
			//copy current array into new array which is 50% larger
			int newArrSize = ((int)(.5*this.list.length) + this.list.length);
			this.list = Arrays.copyOf(this.list,newArrSize);//copies previous array values into new one
		}

		for(int currentIndex = this.count-1; currentIndex >= 0; currentIndex--)//shifts array values to a new one
		{
			this.list[currentIndex+1] = this.list[currentIndex];
		}
		this.list[0] = numToBeAdded;
		this.count++;

	}
	
	/**
	 * This method removes all integers in the list with the value
	 * numToBeRemoved, if there is more than 25% empty space, it reduces list
	 * size by 25%
	 * @param numToBeRemoved is the integer to be removed
	 * @return none
	 */
	
	public void remove(int numToBeRemoved)
	{

		if((search(numToBeRemoved) >= 0) && ((this.count - 1) != 0))
		{
			double percentPresent = this.count / this.list.length;
			if(1 - percentPresent > .25)//adjusts array size
			{				
				int newArrSize =(this.list.length - (int)(.25*this.list.length));
				this.list = Arrays.copyOf(this.list,newArrSize);//copies previous array values into new one
			}
			
			int indexToBeRemoved = search(numToBeRemoved);
			for(int currentIndex = indexToBeRemoved; currentIndex < this.count - 1; currentIndex++)
			{
				this.list[currentIndex] = this.list[currentIndex+1];
			}
			this.count--;
		}
	}
	
	/**
	 * This method returns the count, or amount of elements in the list
	 * @param none
	 * @return int
	 */
	
	public int count()
	{
		return this.count;
	}
	
	/**
	 * This method lists all the elements in the list
	 * @return String a list of all the elements in the list
	 */
	
	public String toString()
	{
		String toString = "";
		
		for( int elementInListIndex = 0; elementInListIndex < this.count(); elementInListIndex++)
		{
			if(elementInListIndex == this.count() - 1)
			{
				toString = toString +  this.list[elementInListIndex];
			}
			else
			{
				toString = toString +  this.list[elementInListIndex] + " ";
			}
		}
		
		return toString;
	}
	
	/**
	 * This method returns the index of the first occurance of a searched
	 * integer, if it is not present, it returns -1
	 * @param intToFind is the integer to search for
	 * @return int the index of the integer being searched for in the list
	 */
	
	public int search(int numToFind)
	{
		boolean found = false;
		int foundIndex = -1;
		for(int index = 0; index < count(); index++)
		{
			if(this.list[index] == numToFind && !found)
			{
				found = true;
				foundIndex = index;
			}
		}
		return foundIndex;
	}
	
	/**
	 * This appends a new integer to the end of the list, if there is not 
	 * enough space in the array, the array length is increased by 50%. Count
	 * is always incremented
	 * @param numToAppend is the integer to append at the end of the list
	 * @return None
	 */
	public void append(int numToAppend)
	{
		if(this.count + 1 > this.list.length)//count should never be greater than the length of the list
		{
			//copy current array into new array which is 50% larger
			int newArrSize = ((int)(.5*this.list.length) + this.list.length);
			this.list = Arrays.copyOf(this.list,newArrSize);//copies previous array values into new one
		}

		this.list[count] = numToAppend;//adds number to end of the list
		this.count++;
	}
	/**
	 * This returns the first integer in the array, if the list is empty, 
	 * it returns -1
	 * @param None
	 * @return firstNum is the int at index 0 of the array
	 */	
	public int first() {
		int firstNum = -1;
		if(this.list.length > 0)
		{
			firstNum = this.list[0];
		}
		return firstNum;
	}
	/**
	 * This returns the last integer in the array, if the list is empty, 
	 * it returns -1
	 * @param None
	 * @return lastNum is the int at the count index of the array.
	 */	
	public int last() {
		int lastNum = -1;
		if(this.list.length > 0)
		{
			lastNum = this.list[this.count - 1];
		}
		return lastNum;
	}
	/**
	 * This returns the size of the array, it includes empty and 
	 * non-empty indices
	 * @param None
	 * @return Returns the size of the array.
	 */	
	public int size() {
		return this.list.length;
	}

	
}
