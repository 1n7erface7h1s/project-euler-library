 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that this program is entirely my own work and none of it is the work of any other person.
  */ 
  
public class p3v2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
