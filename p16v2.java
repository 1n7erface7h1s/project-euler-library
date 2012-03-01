import java.util.*;

public class p16v2{

public static void main(String[] args) {
        
        List<Integer> number = new ArrayList<Integer>();
        
        number.add(1);
        
        for (int i = 0; i < 1000; i++)
        {
            int carry = 0;
            for (int j = 0; j < number.size(); j++)
            {
                final int newVal = number.get(j) * 2 + carry;
                final int newDigit = newVal % 10;
                number.set(j, newDigit);
                carry = (newVal - newDigit) / 10;
            }
            if (carry > 0) number.add(carry);
        }
        
        int ans = 0;
        for (Integer digit : number)
        {
            ans += digit;
        }
        
        System.out.println(ans);
    }
}