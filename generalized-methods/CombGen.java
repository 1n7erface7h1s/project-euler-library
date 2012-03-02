
import java.util.*;

public class CombGen<T> 
{
    
    // cannot handle null lists
    // 
    public CombGen()
    {   }
    
   
    public List<ArrayList<T>> totalizeMList(List<ArrayList<T>> X)
    {
        int r = X.size();
        List<ArrayList<T>> ans = new ArrayList<ArrayList<T>>();
        
        int[] iter = new int[r];
        for(int i = 0; i <= r -1; i++) iter[i] = 0;
        
        main : while(true)
        {
        ArrayList<T> comb = new ArrayList<T>();
        for(int j = 0; j <= r -1; j++) 
        {
          comb.add(X.get(j).get(iter[j]));  
        }
        ans.add(comb);
        
        for(int k = r-1; k >= 0; k--)
        {
           if(iter[k] != X.get(k).size()-1)
           {
               iter[k] += 1;
               continue main;
           }

           iter[k] = 0;
        }
      
        return ans;
        }
    }
    
    public List<ArrayList<T>> permutateMList(List<ArrayList<T>> X)
    {
        List<ArrayList<T>> ans = new ArrayList<ArrayList<T>>();
        ans = totalizeMList(X);
        removeDups(ans);
        return ans;
    }
    
    public List<ArrayList<T>> combinateMList(List<ArrayList<T>> X)
    {
        return X;
    }
    
    public void removeDups(List<ArrayList<T>> X)
    { 
        for(ListIterator<ArrayList<T>> itr = X.listIterator(); itr.hasNext(); )
        {
            List<T> current = itr.next();
            Set<T> set = new HashSet<T>(current);
            if(current.size() != set.size()) itr.remove();
        }
    }
    
    

    public List<ArrayList<T>> combinateSList(int r, ArrayList<T> X)
    {
        
        int n = X.size(); // n is the size of the 'set' to be combinated
            
        List<ArrayList<T>> anchorSet = new ArrayList<ArrayList<T>>();
        
        
       for(int i = 0; i <= n - r ; i++)
       {
           ArrayList toAdd = new ArrayList<T>();
           toAdd.add(X.get(i)); anchorSet.add(toAdd);
       }
       
            for(int i = 2; i <= r; i++)
            { 
		List<ArrayList<T>> resultSet = new ArrayList<ArrayList<T>>();
                int ceiling = n - r + i - 1;

                for(ArrayList<T> comb : anchorSet)
                {
                    for(int j = X.indexOf(comb.get(i-2)) + 1; j <= ceiling; j++)
                    {
                        ArrayList<T> newComb = new ArrayList<T>();
                        newComb.addAll(comb); newComb.add(X.get(j));
                        resultSet.add(newComb);
                    }
                }

                    anchorSet.clear(); anchorSet.addAll(resultSet);
            }
                       
            return anchorSet;
    }

    public List<ArrayList<T>> permutateSList(int r, ArrayList<T> X)
    {
        
      int n = X.size(); // n is the size of the 'set' to be combinated
      
       List<ArrayList<T>> combinSet = combinateSList(r, X);
       
       List<ArrayList<T>> results = new ArrayList<ArrayList<T>>();
      
       
       for( ArrayList<T> comb : combinSet )
       {
		   List<ArrayList<T>> anchor = new ArrayList<ArrayList<T>>();
           anchor.add(comb);
           
           
           for(int i = 0; i <= comb.size() - 2; i++)
           {
			ArrayList<ArrayList<T>> temp = new ArrayList<ArrayList<T>>();
               for(ArrayList<T> perm : anchor)
			   {
                   for(int j = i + 1; j <= comb.size() - 1; j++)
				   { 
                       ArrayList<T> newPerm = new ArrayList<T>(); newPerm.addAll(perm);
                       Collections.swap(newPerm, i, j); temp.add(newPerm);
                   }
			   }
               anchor.addAll(temp);
           }
           results.addAll(anchor); anchor.clear();
       }
       
       return results;
    }
    
    public List<ArrayList<T>> totalizeSList(int r, ArrayList<T> X)
    {
        List<ArrayList<T>> ans = new ArrayList<ArrayList<T>>();
        return ans;
    }
    
}