 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that this program is entirely my own work and none of it is the work of any other person.
  */ 
import java.util.*;
import java.math.BigInteger;

//underconstruction
public class p359 {

    static ArrayList<ArrayList<Long>> hilHot = new ArrayList<ArrayList<Long>>();
    
    public static boolean isPerfectSquare(long n)
    {
        double x = Math.sqrt(n);
        if(Math.ceil(x)== x) return true;
        return false;
    }
 
    public static long P(int f, int r)
    {
        return hilHot.get(f).get(r);
    }
    
    
    public static void main(String[] args) {
        
        long ans;
        
        
        HashMap<Long, ArrayList<BigInteger>> hilHH;
        
        for(long i = 1; i <= Long.MAX_VALUE -1; i++)
        {
            long p = i+1;
            ArrayList<BigInteger> curr = new ArrayList<BigInteger>();
            curr.add(BigInteger.ONE); 
        }
        
        System.out.print("done");
       /** hilHot.ensureCapacity(2);
        BigInteger sumP = new BigInteger("0");
        long p = 1; int f = 1;
        
        do
        {
            while(hilHot.size()-1 < f) hilHot.add(new ArrayList<Long>());
            ArrayList<Long> cur = hilHot.get((int)f);
                
                if(cur.isEmpty()) 
                {cur.add(p); p++; continue;}
                
                else if(isPerfectSquare((long)Math.sqrt(cur.get(cur.size()-1) + p))) 
                {cur.add(p); p++; continue;}
                
                else f++;
        }
            while(f <= Integer.MAX_VALUE);
        
    } 
        
      
}
