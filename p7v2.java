 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that this program is entirely my own work and none of it is the work of any other person.
  */ 
import java.util.*;

// makes a list of primes up to the specified number of primes or up to a certain arbitrary integer max
public class p7v2 {

    public p7v2()
    {
       
    }
    
    public ArrayList<Long> calculatePrimes(long nprimes)
    {
    ArrayList<Long> primeList = new ArrayList<Long>();
    primeList.add(2L); primeList.add(3L); primeList.add(5L); primeList.add(7L);
      
       int i = -1; int m = 1; int z = 2; int j;
        while(primeList.size() <= nprimes)
        {
            long testP = 6 * z + (long) Math.pow(i, m);
            if(testP % 5 != 0) 
            { 
                j = 3;
                while(true)
                {
                    long prime = primeList.get(j);
                    if(prime > Math.floor(Math.sqrt(testP))) 
                    {primeList.add(testP); break;}
                    if(testP % prime == 0) break;
                    j++;
                }
            }
            if(m % 2 == 0) z++;
            m++;
        }
        
        return primeList;
    }
    
    public ArrayList<Long> calculatePrimesN(long maxNum)
    {
    ArrayList<Long> primeList = new ArrayList<Long>();
    primeList.add(2L); primeList.add(3L); primeList.add(5L); primeList.add(7L);
      
       int i = -1; int m = 1; int z = 2; int j;
        while(true)
        {
            long testP = 6 * z + (long) Math.pow(i, m);
            if(testP > maxNum)return primeList;
            if(testP % 5 != 0) 
            { 
                j = 3;
                while(true)
                {
                    long prime = primeList.get(j);
                    if(prime > Math.floor(Math.sqrt(testP))) 
                    {primeList.add(testP); break;}
                    if(testP % prime == 0) break;
                    j++;
                }
            }
            if(m % 2 == 0) z++;
            m++;
        }
    }
    
    /**
     * @params 
     */
    public static void main(String[] args) {
      
        p7v2 p = new p7v2();
        long prime = p.calculatePrimes(20).get(19);
        
        System.out.print(prime);
    }

}