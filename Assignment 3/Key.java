package A3;
public class Key
{ 
   String key;
  
    public Key(String key) 
    { 
        this.key = key; 
    } 

    @Override
    public int hashCode() 
    { 
    	int R = 3;
    	int hCode = 0;
    	for (int i = 0; i < key.length(); i++)
    	    hCode = (R * hCode + key.charAt(i));
        return hCode; 
    } 
    
    public static void main(String[]args) {
    	
    }//main
} //class