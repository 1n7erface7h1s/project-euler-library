 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that the method definitions and import statement in this program 
  * are entirely my own work and none of it is the work of any other person.
  */
import java.util.*;

// finds the smallest number that can be divided evenly by any integer up to n
public class p5 {

    
    public static void main(String[] args) {
        
        
        p7v2 p = new p7v2(); long upTo = 10000000;
        ArrayList<Long> primes = p.calculatePrimesN(upTo);   
        ArrayList<Long> ans = new ArrayList<Long>();
        int n; 
        
        for(int i = 0; i <= primes.size() -1; i++)
        {
          long prime = primes.get(i);
          ans.add(prime); n = 2;
          
          while(true)
          {
             if(Math.pow(prime, n) > upTo) break;
             ans.add(prime); n++;
          }
          
        }
        
        System.out.print(ans.toString());
        
        
        
    }
}
