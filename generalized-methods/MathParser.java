
import java.util.*;
import java.math.BigDecimal;

public class MathParser {
  
private String orderOfOperations = "(^r*/+-";



public mathParser()
{}


public Number parseIntegerExpression(String math)
{
     
    while(math.contains("("))
    {
 int j = math.indexOf('('); int m = j+1; 
 int open = 1; int close = 0; 
 while(open != close) 
 {
     if(m >= math.length()) {m--; break;}
     
     Character k = math.charAt(m++);
     if(k.equals('(')) open++;
     if(k.equals(')')) close++;
 }  
 String recur = String.valueOf(parseIntegerExpression(math.substring(j+1, m-1))); 
 math = math.replace(math.substring(j, m), recur);
   }
    
 while(math.contains("^"))
 {
   int j = math.indexOf("^"); int l = j; 
   String first; String k = "0";
    while(!orderOfOperations.contains(k))
   {
       l--; if(l == 0) break;
       k = String.valueOf(math.charAt(l));
       if(orderOfOperations.contains(k)) l++;
   }
   first = math.substring(l, j);
   Integer beg = new Integer(l);
   
   l = j; 
   String second; k = "0";
   while(!orderOfOperations.contains(k))
   {
       l++; if(l == math.length()) break;
       k = String.valueOf(math.charAt(l));
   }
   second = math.substring(j+1, l);
   int end = l;
   
   double fir = Double.parseDouble(first); 
   double sec = Double.parseDouble(second);
   
   double temp = Math.pow(fir, sec);
   String recur = String.valueOf(temp);
   math = math.replace(math.substring(beg, end), recur);
 }

 /**while(math.contains("r"))
 {
   int j = math.indexOf("r"); int l = j; 
   String first; String k = "0";
   while(!orderOfOperations.contains(k))
   {
       l--;
       k = String.valueOf(math.charAt(l));
   }
   first = math.substring(l+1, j);
   Integer beg = new Integer(1);
   
   l = j; 
   String second; k = "0";
   while(!orderOfOperations.contains(k))
   {
       l++;
       k = String.valueOf(math.charAt(l));
   }
   second = math.substring(j+1, l);
   int end = 1;
   
   long fir = Long.parseLong(first);
   long sec = Long.parseLong(second);
   
   long temp = (long) Math.
   String recur = String.valueOf(temp);
   math.replace(math.substring(beg, end), recur);
 }*/
 
 while(math.contains("*"))
 {
   int j = math.indexOf("*"); int l = j; 
   String first; String k = "0";
    while(!orderOfOperations.contains(k))
   {
       l--; if(l == 0) break;
       k = String.valueOf(math.charAt(l));
       if(orderOfOperations.contains(k)) l++;
   }
   first = math.substring(l, j);
   Integer beg = new Integer(l);
   
   l = j; 
   String second; k = "0";
   while(!orderOfOperations.contains(k))
   {
       l++; if(l == math.length()) break;
       k = String.valueOf(math.charAt(l));
   }
   second = math.substring(j+1, l);
   int end = l;
   
   double fir = Double.parseDouble(first); 
   double sec = Double.parseDouble(second);
   
   double temp = fir*sec;
   String recur = String.valueOf(temp);
   math = math.replace(math.substring(beg, end), recur);
 }
 
 while(math.contains("/"))
 {
   int j = math.indexOf("/"); int l = j; 
   String first; String k = "0";
    while(!orderOfOperations.contains(k))
   {
       l--; if(l == 0) break;
       k = String.valueOf(math.charAt(l));
       if(orderOfOperations.contains(k)) l++;
   }
   first = math.substring(l, j);
   Integer beg = new Integer(l);
   
   l = j; 
   String second; k = "0";
   while(!orderOfOperations.contains(k))
   {
       l++; if(l == math.length()) break;
       k = String.valueOf(math.charAt(l));
   }
   second = math.substring(j+1, l);
   int end = l;
   
   long fir = Long.parseLong(first); 
   long sec = Long.parseLong(second);
   
   long temp = fir/sec;
   String recur = String.valueOf(temp); 
   math = math.replace(math.substring(beg, end), recur);
 }
 
 while(math.contains("+"))
 {
   int j = math.indexOf("+"); int l = j; 
   String first; String k = "0";
   while(!orderOfOperations.contains(k))
   {
       l--; if(l == 0) break;
       k = String.valueOf(math.charAt(l));
       if(orderOfOperations.contains(k)) l++;
   }
   first = math.substring(l, j);
   Integer beg = new Integer(l);
   
   l = j; 
   String second; k = "0";
   while(!orderOfOperations.contains(k))
   {
       l++; if(l == math.length()) break;
       k = String.valueOf(math.charAt(l));
   }
   second = math.substring(j+1, l);
   int end = l;
   
   double fir = Double.parseDouble(first); 
   double sec = Double.parseDouble(second);
   
   double temp = fir + sec; 
   String recur = String.valueOf(temp);
   math = math.replace(math.substring(beg, end), recur); 
 }

 while(math.lastIndexOf("-") > 0)
 {
   int j = math.indexOf("-", 1); int l = j; 
   String first; String k = "0";
   while(!orderOfOperations.contains(k))
   {
       l--; if(l == 0) break;
       k = String.valueOf(math.charAt(l));
       if(orderOfOperations.contains(k)) l++;
   }
   first = math.substring(l, j);
   Integer beg = new Integer(l);
   
   l = j; 
   String second; k = "0";
   while(!orderOfOperations.contains(k))
   {
       l++; if(l == math.length()) break;
       k = String.valueOf(math.charAt(l));
   }
   second = math.substring(j+1, l);
   int end = l;
   
   double fir = Double.parseDouble(first); 
   double sec = Double.parseDouble(second);
   
   double temp = fir - sec; 
   String recur = String.valueOf(temp); 
   math = math.replace(math.substring(beg, end), recur); 
 }
 
 return Double.parseDouble(math);
}



}


// array of math; filter operators in order of occurence along with integers; use those arrays with eachother to solve math expression