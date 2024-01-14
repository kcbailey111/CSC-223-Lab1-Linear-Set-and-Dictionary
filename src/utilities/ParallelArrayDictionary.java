package utilities;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	protected ArraySet<Key>    _keys;
	protected ArrayList<Value> _values;

	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	@Override
	public int size() {return _keys.size();}

	@Override
	public boolean isEmpty() {return _keys.isEmpty();}

	@Override
	public boolean containsKey(Object key) {return _keys.contains(key);}

	@Override
	public boolean containsValue(Object value) {return _values.contains(value);}

	@Override
	public Value get(Object key) {return _values.get(_keys.indexOf(key));}

	@Override
	public Value put(Key key, Value value) {
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

	@Override
	public Value remove(Object key) {
		int index = _keys.indexOf(key);
		_keys.remove(key);
		return _values.remove(index);
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Key> keySet() {return (Set<Key>) _keys.subList(0, _keys.size());}

	@Override
	public Collection<Value> values() {return _values.subList(0, _values.size());}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		
		
		
		return null;
	}

}