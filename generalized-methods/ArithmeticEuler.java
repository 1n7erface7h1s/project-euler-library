import java.util.*;

public class ArithmeticEuler<T> {

    public static boolean isInteger(Number n)
    {
        if (n.doubleValue() == n.intValue()) return true;
        return false;
    }
     public static <T extends Object> List<List<T>> returnListCopies(int copyNum, List<T> whatToCopy)
             {
                 return Collections.nCopies(copyNum, whatToCopy);
             }
    
     /**
      * 
      * @param birthList
      * @param size
      * @param totalSpace
      * @return 
      */
     public static List<List<Cell>> boundedSpaceOrder(List<Object> birthList, int totalSpace, int size) // (int, T) << turn into cell
     {
         CombGen gen = new CombGen();
         
         List<List<Object>> base = Collections.nCopies(size, birthList);
         List<List<Object>> totalizedStrings = gen.totalizeMList(base);
         
         ArrayList<Integer> intList = new ArrayList<Integer>();
         for(int i = 1; i<=totalSpace; i++) intList.add(i);
         List<List<Integer>> spacialCombinations = gen.combinateSList(size, intList);
         
         List<List<Cell>> masterList = new ArrayList<List<Cell>>();
         
         for(List<Integer> spacialComb : spacialCombinations)
         {
             for(List<Object> totString : totalizedStrings)
             {
                 List<Cell> cellList = new ArrayList<Cell>();
                 for(int i = 0; i <= size -1; i++) 
                 {
                 Cell cell; 
                 cell = new Cell(spacialComb.get(i), totString.get(i));
                 cellList.add(cell);
                 }
                 masterList.add(cellList);
             }
         }
         
         return masterList;
     }
     
     public static List<List<Cell>> totalSpaceOrder(List<Object> birthList, int totalSpace)
     {
        List<List<Cell>> masterList = new ArrayList<List<Cell>>();

        for(int i = 1; i <= totalSpace; i++)
        {
          List<List<Cell>> temp = boundedSpaceOrder(birthList, totalSpace, i);  
          masterList.addAll(temp);
        }
        
        return masterList;
     }
     
     /**
      * 
      * @param X
      * @return 
      */
  /**  public static String toString(List<List<Cell>> X)
    {
        String ans = "";
        
        for(int i = 0; i <= X.size() -1; i++)
        {
            for(int j = 0; j <= X.get(i).size() -1; j++)
            {
               ans += X.get(i).get(j).toString() + " ";
            }
            ans += "\n";
        }
        return ans;
    }*/
    
    public static void main(String[] args) {
        
        
        CombGen test = new CombGen();
        
        List charList = new ArrayList<Character>();
        charList.add('+');  charList.add('*'); charList.add('-'); //charList.add('/');
        List spaceList = new ArrayList<Character>();
        for(int i = 1; i <= 9; i++) spaceList.add(i);
        List<List<Character>> masterList = new ArrayList<List<Character>>();
        
            
        List<List<Cell>> bigList = totalSpaceOrder(charList, 8);
        
        
        for(int i = 0; i <= bigList.size() -1; i++)
        {
            List newPerm = new ArrayList<Character>(spaceList);
            List<Cell> current = bigList.get(i);
            int k = 0;
            for(Cell cell : current)
            {
                newPerm.add(cell.index + k++, (Character) cell.content);
            }
            masterList.add(newPerm);
        }
        
        List<String> sList = new ArrayList<String>();
        for(List mathExp : masterList)
        {
            String exp = "";
            for(Object c : mathExp)
            {
                exp += c;
            }
            sList.add(exp);
        }
        mathParser fil = new mathParser();
        List<Double> ansList = new ArrayList<Double>();
        for(String mathExp : sList)
        {
          Number ans = fil.parseIntegerExpression(mathExp);
          if(isInteger(ans)) ansList.add((Double) ans);
        }
        
        System.out.print(ansList);
        
    }
}
