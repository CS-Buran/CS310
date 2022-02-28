package A3;
import A3.Key;
import java.util.*;
public class DataClass<K, V> implements Comparable<DataClass<K, V>>
{ 
    K key; 
    V value; 
  
    DataClass<K, V> next; 
    
    
    public void DataClass(K key, V value) 
    { 
        this.key = key; 
        this.value = value; 
        
    } 
    
    
    public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}


	public int compareTo(DataClass<K, V> node)
    {
        return ((Comparable<K>) key).compareTo((K) node.key);
    }
    
    
    public int hashFunction() 
    { 
        int index = (this.key.hashCode() & 0x7FFFFFFF) % 50; //Some computation using key.hashCode() to generate index 
        return index; 
    } 

    public String toString() {
        return "Key=" + getKey() + ", Value=" + getValue();
    }
    
    public static void main(String[]args) {
    	
    }//class
} //main