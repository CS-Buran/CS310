package A3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChainingHashTable<K,V> implements MapInterface<K,V> {

	public LinkedList<DataClass<K,V>>[] table;
	
	public int max = 50;
	int modCounter,tableSize;

	static int size;
	

	public ChainingHashTable(int n) {				//done
        this.tableSize = n;
        table = (LinkedList<DataClass<K, V>>[]) new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }
	
	private int getIndex(K key)						//done
	{
		int haCod=key.hashCode();
		return haCod % max;
	}
	
    public V get(K key) {							//done
        int index = getIndex(key);
        if (table[index].size() == 0) {
        	throw new NoSuchElementException();
        }
        for (int i = 0; i < table[index].size(); i++) {
            DataClass<K, V> cur = table[index].get(i);
            if (cur.key.equals(key)) {
                return table[index].get(i).getValue();
            } else {
                System.out.println("Key not found");
                return null;
            }
        }
        return null;
    }
	
	@Override
	public void put(K key, V value) { 				//done
		int index = getIndex(key);
		LinkedList<DataClass<K, V>> head = new LinkedList<DataClass<K, V>>() ;
		DataClass<K, V> newNode = new DataClass<>();
		newNode.key = key;
		newNode.value = value;
		
			table[index].addLast(newNode);
			size++;
			modCounter++;
		
	        return;
	}

	@Override										
	public V remove(K key) {						//done
		int index = getIndex(key);
		if (table[index].size() == 0) {
			throw new NoSuchElementException();
        }
		for (int i = 0; i < table[index].size(); i++) {
			DataClass<K, V> curr = table[index].get(i);
				if(curr.key.equals(key)) {
					table[index].remove(i);
					modCounter++;
				}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int size() {								//done
		return size;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {						//done
		if(size == 0) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

    public Iterator keys()							//done
    {

    	return new KeyIteratorHelper<K>();
    }

    public Iterator values()						//done
    {
    	return new ValueIteratorHelper<V>();
    }
    
    abstract class IteratorHelper<E> implements Iterator<E>{
    	
    	protected DataClass<K,V> [] nodes;
    	
    	protected int idx;
    	protected long modCheck;
    	
    	
    	
    	public IteratorHelper() {
    		nodes = new DataClass[size()];
    		idx = 0;
    		int j = 0;
    		modCheck = modCounter;
    		//System.out.println("20 ");
    		for(int i = 0; i < 50; i++) 
    			for(DataClass<K,V> n : table[i]) 
    				nodes[j++] = n;
    			//System.out.println(nodes);
    			
    			shellSort(nodes);  
    			
    		
    		//System.out.println("23 ");
    		
    	}//iterator helper
    	
    	public boolean hasNext() {
    		if(modCheck != modCounter) {
    			throw new ConcurrentModificationException();
    		}
    		return idx < size();
    	}//has next

    	public abstract E next();
    	
    	public void remove() {
    		throw new UnsupportedOperationException();
    	}//remove
    }//abstract iterator helper class
    
    class KeyIteratorHelper<K> extends IteratorHelper<K>{
    	public KeyIteratorHelper() {
    		super();
    	}
    	
		public K next() {
			return (K) nodes[idx++].key;
		}//next
    }//key
    
    class ValueIteratorHelper<V> extends IteratorHelper<V>{
    	public ValueIteratorHelper() {
    		super();
    	}
    	
    	public V next() {
    		return (V) nodes[idx++].value;
    	}
    	
    }
    
    private void shellSort(DataClass<K, V> [] nodes)
    {
        DataClass<K, V> [] n = nodes;
        DataClass<K, V> temp;
        int in, out, h = 1;
        int curSize = n.length;
        
        while(h <= curSize/3)
            h = h*3+1;
        
        while(h > 0)
        {
        	//System.out.println("177 ");
            for(out=h; out < curSize; out++)
            {
            	//System.out.println("1123 ");
                temp = n[out];
                in = out;
                
                while(in > h-1 && n[in-h].compareTo(temp) >= 0)
                {
                	//System.out.println("1 ");
                    n[in] = n[in-h];
                    in-=h;
                }
                n[in] = temp;
            }
            h = (h-1)/3;
        }
    }//shell sort

    public void display() {							//done
        for(int i=0; i<max;i++) {
            if(table[i]!=null) {
                System.out.println(table[i].toString());

            }
        }
    }
    
public static void main(String[] args) throws FileNotFoundException {
		String input;
		char quit = 'y';
		Scanner scan = new Scanner(System.in);
       
        System.out.println("Enter Size");
		
        ChainingHashTable<String, String> table = new ChainingHashTable<String,String>(scan.nextInt());
		
		
		Scanner sc = new Scanner(new File("C:\\Users\\Mikhail\\eclipse-workspace\\A3\\src\\A3\\Records"));
        while (sc.hasNextLine()) {

            String key = new String(sc.next()); 
            String value = new String(sc.next());
             table.put(key, value);
        }
        
        while (quit != 'n'){	//menu start
        
            System.out.println("Hash Table");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Get");            
            System.out.println("4. Size");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter key and value");
                table.put(scan.next(), scan.next() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter key");
                table.remove( scan.next() ); 
                break;                        
            case 3 : 
                System.out.println("Enter key");
                System.out.println("Value : "+ table.get( scan.next() )); 
                break;                                   
            case 4 : 
                System.out.println("Size : "+ table.size() );
                break;         
            default : 
                System.out.println("Not an option ");
                break;   
            }
            
            table.display(); //diplay 
                     
        
            System.out.println("Go Back to main Menu Y/N");		
			input = scan.next().toLowerCase();
			quit = input.charAt(0);   
        }//menu
	}//main
}//class