package utilities;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArraySetTest
{

	
	@Test
	void testArraySetCollectionOfE()
	{
		ArrayList<String> colOfStrings = new ArrayList<String>();
		colOfStrings.add("hello");
		colOfStrings.add("world");
		colOfStrings.add("tsunami");
		ArraySet<String> _list = new ArraySet<String>(colOfStrings);
		assertTrue(_list.contains("hello"));
		assertTrue(_list.contains("world"));
		assertTrue(_list.contains("tsunami"));
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
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
	}
}
