/*
 * finds the smallest number that can be divided evenly by any integer up to n
 */
import java.util.*;

public class p5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
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
