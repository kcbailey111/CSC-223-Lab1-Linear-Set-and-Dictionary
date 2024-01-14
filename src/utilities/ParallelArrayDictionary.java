/**
 * This class creates a dictionary of 2 different array types, Set<Key> and Value<List>. Both of these use
 * methods from the ArraySet.java class. This class has methods that manipulate a dictionary.
 * 
 * @author Brodee Clontz and Kyler Bailey
 * @date 01/14/24
 */

package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	protected ArraySet<Key>    _keys;
	protected ArrayList<Value> _values;

	/**
	 * Constructor.
	 */
	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	/**
	 * Returns the size of the dictionary.
	 */
	@Override
	public int size() {return _keys.size();}

	/**
	 * Returns if the dictionary is empty or not.
	 */
	@Override
	public boolean isEmpty() {return _keys.isEmpty();}

	/**
	 * Checks to see if a specified key is in the dictionary.
	 */
	@Override
	public boolean containsKey(Object key) {return _keys.contains(key);}

	/**
	 * Checks to see if a specified value is in the dictionary.
	 */
	@Override
	public boolean containsValue(Object value) {return _values.contains(value);}

	/**
	 * Returns the value at a specified key.
	 */
	@Override
	public Value get(Object key) {return _values.get(_keys.indexOf(key));}

	/**
	 * Associates a value to a key.
	 */
	@Override
	public Value put(Key key, Value value) {
		//If the key already exists it replaces the value there with the new value.
		if (_keys.contains(key)) {
			int index = _keys.indexOf(key);
			_values.set(index, value);
		}
		else {
			_keys.add(key);
			_values.add(value);
		}
		return value;
	}

	/**
	 * Removes the value and key at a specified key.
	 */
	@Override
	public Value remove(Object key) {
		int index = _keys.indexOf(key);
		_keys.remove(key);
		return _values.remove(index);
	}

	/**
	 * Puts an existing 'Map' into the dictionary.
	 */
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		_keys.addAll(m.keySet());
		_values.addAll(m.values());
	}

	/**
	 * Clears the dictionary of all keys and values.
	 */
	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	/**
	 * Returns a Set view of the keys contained in the dictionary.
	 */
	@Override
	public Set<Key> keySet() {
		Set<Key> tempKeys = new ArraySet<Key>();
		for (Key key: _keys) {
			tempKeys.add(key);
		}
		return tempKeys;
	}

	/**
	 * Returns a Set view of the values in the dictionary.
	 */
	@Override
	public Collection<Value> values() {return _values.subList(0, _values.size());}

	/**
	 * Returns a set view of the keys and values in the dictionary
	 * Output looks like [key=value]
	 */
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		HashMap<Key, Value> map = new HashMap<Key, Value>();
		int index = 0;
		for (Key key : _keys) {
			map.put(key, _values.get(index));
			index++;
		}
		return map.entrySet();
	}

}