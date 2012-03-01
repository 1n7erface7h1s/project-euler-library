 /**
  * @author 1n7erface7h1s 
  * @email 1n7erface7h1s@gmail.com
  * 
  * I affirm that this program is entirely my own work and none of it is the work of any other person.
  */ 

import java.util.*;
import javax.swing.*;

public class p2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ArrayList<Integer> init = new ArrayList<Integer>();
        init.add(1); init.add(2);
        int i = 0;
        
        while(true)
        {
            init.add(init.get(i) + init.get(i + 1));
            i++;
            if(init.get(i+1) > 4000000){init.remove(i+1); break;}
        }
        
        
        int sum = 0;
        for(int j = 0; j <= init.size() - 1; j++)
        {
            int term = init.get(j);
            if(term % 2 == 0) sum += term;
        }
        
        System.out.print(sum);
    }
}
