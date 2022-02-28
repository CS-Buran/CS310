package A3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProbingHashTable<K extends Comparable<K>, V> implements MapInterface<K, V>{

	public K[] keys;
	public V[] vals;
	public static int max = 50;
	
	static long modCounter;
	static int curSize,tableSize;
	public ProbingHashTable(int capacity) 
    {
        curSize = 0;
        max = capacity;
        keys = (K[])new String[max];
        vals = (V[])new String[max];
    }
	
	private int getIndex(K key)			//done
	{
		int haCod=key.hashCode();
		return haCod % max;
	}
	
	@Override
	public V get(K key) {				//done
		int index = getIndex(key);
		while(keys[index] != null)
		{
			if(keys[index].equals(key))
			{
				return vals[index];
			}
			index++;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {	//done
		// TODO Auto-generated method stub
		int tmp = getIndex(key);
        int i = tmp;
        do
        {
            if (keys[i] == null)
            {
                keys[i] = key;
                vals[i] = value;
                curSize++;
                return;
            }
            if (keys[i].equals(key)) 
            { 
                vals[i] = value; 
                return; 
            }            
            i++;            
        } while (i != tmp);       
    }

	@Override
	public V remove(K key) {			//Done
		// TODO Auto-generated method stub
		int index = getIndex(key);
		if(keys[index] == null) {
			throw new NoSuchElementException();
		}
		while( !key.equals( keys[index])) {
			index++;
		}
		keys[index] = null;  
		vals[index] = null;
		return null;
	}

	@Override
	public int size() {					//done
		// TODO Auto-generated method stub
		return curSize;
	}

	@Override
	public boolean isEmpty() {			//done
		// TODO Auto-generated method stub
		if(curSize == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator keys() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator values() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printHashTable()		//done
	    {
	        System.out.println("Hash Table:  ");
	        System.out.println("Keys     Values  ");
	        for (int i = 0; i < max; i++) {
	            if (keys[i] != null) {
	                System.out.println(keys[i] +" "+ vals[i]);
	            }
	        System.out.println();
	    }   
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        
        ProbingHashTable table = new ProbingHashTable<String, String>(scan.nextInt());
        Scanner sc = new Scanner(new File("C:\\Users\\Mikhail\\eclipse-workspace\\A3\\src\\A3\\Records"));
        while (sc.hasNextLine()) {
        	table.put(sc.next(), sc.next() ); 
        }
        String input;
        char quit = 'y';
        //menu
        while (quit != 'n'){	
        
            System.out.println("Hash Table Operations");
            System.out.println("1. Insert ");
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
            
            table.printHashTable(); //diplay 
                       
        
            System.out.println("Go Back to main Menu Y/N");		
			input = scan.next().toLowerCase();
			quit = input.charAt(0);   
        }//menu
	}//main
}//class
