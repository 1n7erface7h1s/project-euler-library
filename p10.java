import java.util.*;

public class p10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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