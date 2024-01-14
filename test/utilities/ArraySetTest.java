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
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
	}

	@Test
	void testRetainAll()
	{
	}

	@Test
	void testRemoveAll()
	{
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");
		
		ArraySet<String> _list = new ArraySet<String>();
		_list.add("hello");
		_list.add("world");
		_list.add("tsunami");
		_list.removeAll(colOfStrings);
		assertTrue(_list.get(0).equals("tsunami"));
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
	}
}
