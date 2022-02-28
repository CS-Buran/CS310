package A3;

import java.util.Iterator;

interface MapInterface<K,V>{
			V get(K key);
			
			void put(K key, V value);
			
			V remove(K key);
			
			int size();
			
			boolean isEmpty();
			
			Iterator keys();
			
			Iterator values();
			
}
