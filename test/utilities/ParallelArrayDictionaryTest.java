package utilities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	void testParallelArrayDictionary()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		assertTrue(_dict.size()==0);
		assertTrue(_dict.isEmpty());
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		assertTrue(_dict.size()==4);
		assertTrue(_dict.containsKey(1));
		assertFalse(_dict.containsKey(7));
		assertTrue(_dict.containsValue("tsunami"));
		assertFalse(_dict.containsValue("word"));
	}

	@Test
	void testGet()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		assertTrue(_dict.get(1).equals("hello"));
		assertTrue(_dict.get(2).equals("world"));
		assertTrue(_dict.get(3).equals("tsunami"));
		assertTrue(_dict.get(4).equals("last"));
	}

	@Test
	void testPut()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		assertTrue(_dict.put(4, "first").equals("first"));
		assertFalse(_dict.get(4).equals("last"));
		assertTrue(_dict.size()==4);
	}

	@Test
	void testRemove()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		assertTrue(_dict.remove(4).equals("last"));
		assertTrue(_dict.size()==3);
	}

	@Test
	void testPutAll()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		
		
		ParallelArrayDictionary<Integer, String> _newDict = new ParallelArrayDictionary<Integer, String>();
		_newDict.putAll(_dict);
		assertTrue(_dict.entrySet().equals(_newDict.entrySet()));
		
		
		_newDict = new ParallelArrayDictionary<Integer, String>();
		_newDict.put(1, "goodbye");
		_newDict.putAll(_dict);
		assertFalse(_newDict.get(1).equals(_dict.get(1)));
		assertTrue(_newDict.size()==4);
	}

	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		_dict.clear();
		assertTrue(_dict.size()==0);
	}
}
