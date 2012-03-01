 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that this program is entirely my own work and none of it is the work of any other person.
  */ 
import java.util.*;

public class p10 {

    public static void main(String[] args) {
        
        p7v2 p = new p7v2();
        ArrayList<Long> primes = p.calculatePrimesN(2000000);
        
        long sum = 0L;
        
        for(int i = 0; i <= primes.size() - 1; i++)
        {
            sum += primes.get(i);
        }
        
        System.out.print(sum);
    }
}
