 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that this program is entirely my own work and none of it is the work of any other person.
  */ 
  
public class p14 {

   
    public static void main(String[] args) {
    
        int max = 0; int ans = 0; int cnt; 
        final int k = -1; int j; long n;
        
        for(int i = 1; i <= 1000000; i += 2)
        { // odds up to max, evens below max/2 can be skipped since for any 2n < max/2 2*2n -> 2n
        n = i; cnt = 0;
            while(n != 1)
            {
                if(n % 2 != 0) {n = 3*n + 1; cnt++;}
                while(n % 2 == 0) {n = n / 2; cnt++;}   
            }
            if(cnt > max) {ans = i; max = cnt;}
        }
        
        for(int i = 500005; i <= 1000000; i += 6) 
        { // n > max/2, not of the form 3m+1, and even
            for(j = 0; j <= 1; j++)
            {
            n = i + (long) Math.pow(k, j); cnt = 0;
                while(n != 1)
                {
                if(n % 2 != 0) {n = 3*n + 1; cnt++;}
                while(n % 2 == 0) {n = n / 2; cnt++;}   
                }
                if(cnt > max) {ans = i; max = cnt;}
             }
        }
        
        System.out.print(ans);
        
    }
}
