package utilities;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		System.out.println(_dict.entrySet());
	}

	@Test
	void testGet()
	{
	}

	@Test
	void testPut()
	{
	}

	@Test
	void testRemove()
	{
	}

	@Test
	void testPutAll()
	{
	}

	@Test
	void testClear()
	{
	}
}
