/**
 * Author: Matthew Szeto
 * Class ID: 195
 * Assignment: 1
 */

package cse360assign2;
import java.util.*;
/**
 * 
 * @author Matthew Szeto
 * This class creates a simple list of up to ten elements which contains
 * methods to modify the list, including a search method, add, remove, 
 * and count and toString to display information on the list
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
	 * other elements right
	 * @param numToBeAdded is the int to be added
	 * @return none
	 */
	
	public void add(int numToBeAdded)
	{
		if(this.count + 1 > this.list.length)//count should never be greater than the length of the list
		{
			//copy current array into new array which is 50% larger
			int newArrSize = (int) ((.5*this.list.length) + this.list.length);
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
	 * numToBeRemoved
	 * @param numToBeRemoved is the integer to be removed
	 * @return none
	 */
	
	public void remove(int numToBeRemoved)
	{
		if(search(numToBeRemoved) >= 0)
		{
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
	
	public int search(int intToFind)
	{
		boolean found = false;
		int foundIndex = -1;
		for(int index = 0; index < count(); index++)
		{
			if(this.list[index] == intToFind && !found)
			{
				found = true;
				foundIndex = index;
			}
		}
		return foundIndex;
	}
	
	
}
