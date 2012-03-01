/*
 * calculates the largest prime factor for a number, can be used to find all the prime factors of a number
 */
public class p3v2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           long ans = 0;
           long num = 600851475143L;
           int i = -1; long z = 2; 
           
           for(long m = 1; ; m++)
           {
            long primeCan = 6 * z + (long) Math.pow(i, m);
            if(primeCan % 5 != 0) 

               while(num % primeCan == 0) num /= primeCan;
               if(num == 1) {ans = primeCan;  break;}
               
            if(m % 2 == 0) z++;
           }
           
           System.out.print(ans);
    }
}
