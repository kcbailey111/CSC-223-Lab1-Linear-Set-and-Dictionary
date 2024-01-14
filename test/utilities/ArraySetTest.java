/**
 * Test class for ArraySet.java. This class tests methods that didn't use delegation. 
 * 
 * @author Brodee Clontz and Kyler Bailey
 * @date 01/14/24
 */

package utilities;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArraySetTest
{


	@Test
	void testArraySetCollectionOfE()
	{
		//Creating a collection to test the parameterized constructor
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");
		colOfStrings.add("tsunami");

		//Testing the constructor with unique elements
		ArraySet<String> _list = new ArraySet<String>(colOfStrings);
		assertTrue(_list.contains("hello"));
		assertTrue(_list.contains("world"));
		assertTrue(_list.contains("tsunami"));

		//Clearing the collection and putting new non-unique values in
		colOfStrings.clear();
		colOfStrings.add("hello");
		colOfStrings.add("hello");
		colOfStrings.add("hello");

		//Making a new list with the collection and testing that it only adds one unique element
		ArraySet<String> _newList = new ArraySet<String>(colOfStrings);
		assertTrue(_newList.size()==1);
	}

	@Test
	void testAddE()
	{
		//Creating a loop to add 100 of the same element
		ArraySet<String> _list = new ArraySet<String>();
		for (int i = 0; i < 100; i ++) {
			_list.add("hello");
		}
		//Only one element should ever be added since all are the same
		assertTrue(_list.size()==1);
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
		//Creating and collection to addAll to the list
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");
		colOfStrings.add("tsunami");

		//Creating a list with one element from the collection and one not
		ArraySet<String> _list = new ArraySet<String>();
		_list.add("first");
		_list.add("tsunami");
		_list.addAll(colOfStrings);

		//Shouldn't add an additional "tsunami" so size should be 4
		assertTrue(_list.size()==4);
	}

	@Test
	void testRetainAll()
	{
		//Creating and collection to addAll to the list
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");
		colOfStrings.add("tsunami");

		//Creating a list with one element from the collection and one not
		ArraySet<String> _list = new ArraySet<String>();
		_list.add("first");
		_list.add("tsunami");
		_list.retainAll(colOfStrings);

		//Shouldn't add an additional "tsunami" so size should be 4
		assertTrue(_list.size()==3);
		
		//Adding the same element 3 times to the collection
		colOfStrings.clear();
		colOfStrings.add("hello");
		colOfStrings.add("hello");
		colOfStrings.add("hello");
		
		//It should only retain one unique element so size should be 1
		_list.retainAll(colOfStrings);
		assertTrue(_list.size()==1);
	}

	@Test
	void testRemoveAll()
	{
		//Creating a collection
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");

		//Creating a list with 3 elements, 2 are in the collection
		ArraySet<String> _list = new ArraySet<String>();
		_list.add("hello");
		_list.add("world");
		_list.add("tsunami");

		//Testing to see that the 2 elements from the collection were removed
		_list.removeAll(colOfStrings);
		assertTrue(_list.get(0).equals("tsunami"));
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		//Creating and collection to addAll to the list
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");
		colOfStrings.add("tsunami");

		//Creating a list with one element from the collection and one not
		ArraySet<String> _list = new ArraySet<String>();
		_list.add("first");
		_list.add("tsunami");
		_list.addAll(1, colOfStrings);

		//Shouldn't add an additional "tsunami" so size should be 4
		assertTrue(_list.size()==4);

		//Testing to make sure the elements were inserted in the right place
		assertTrue(_list.get(0).equals("first"));
		assertTrue(_list.get(1).equals("hello"));
		assertTrue(_list.get(2).equals("world"));
		assertTrue(_list.get(3).equals("tsunami"));
	}
}
