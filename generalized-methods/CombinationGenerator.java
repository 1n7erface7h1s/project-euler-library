import java.util.*;

public class  CombinationGenerator<T>{
    
    private ArrayList<T> X = new ArrayList<T>(); // to pull values from
    private ArrayList<ArrayList<T>> anchorSet; // initialized
    private int r; // r is the length of the combination; r choose n
    private int n; // n is the size of the 'set' to be combinated
    
    private ArrayList<ArrayList<T>> combinSet; private boolean combined;
    private ArrayList<ArrayList<T>> permutSet; private boolean permuted;
    
    
    private final void initializeAnchor(ArrayList<T> X, int r)
    {
        this.anchorSet = new ArrayList<ArrayList<T>>();
        
       for(int i = 0; i <= X.size()- r ; i++)
       {
           ArrayList toAdd = new ArrayList<T>();
           toAdd.add(X.get(i)); anchorSet.add(toAdd);
       }
    }
    
    public CombinationGenerator(Collection<T> X, int r)
    {
      this.X.addAll(X);
      initializeAnchor(this.X, r);
      n = X.size();
      this.r = r;  
      combined = false; permuted = false;
    }
    
    public ArrayList<ArrayList<T>> getCombList()
    {
        return combinSet;
    }
    
    public ArrayList<ArrayList<T>> getPermList()
    {
        return permutSet;
    }
    
    public ArrayList<ArrayList<T>> combinateSet() // 
    {
        combined = true;
ArrayList<ArrayList<T>> copy = new ArrayList<ArrayList<T>>();
copy.addAll(anchorSet);

            for(int i = 2; i <= r; i++)
            { 

                int ceiling = n - r + i - 1;
                ArrayList<ArrayList<T>> resultSet = new ArrayList<ArrayList<T>>();

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
            combinSet = new ArrayList<ArrayList<T>>();
            combinSet.addAll(anchorSet); anchorSet.clear(); anchorSet.addAll(copy);
            
            return combinSet;
    }
    
    public ArrayList<T> nextCombination(ArrayList<T> comb) // not yet
    {
        if(!combined) combinateSet();
        int pos = combinSet.indexOf(comb);
        ArrayList<T> ans = combinSet.get(pos + 1);
        return ans;
    }
    
    
    public void permutateSet()
    {
       if(!combined)combinateSet();
       
       ArrayList<ArrayList<T>> results = new ArrayList<ArrayList<T>>();
       ArrayList<ArrayList<T>> anchor = new ArrayList<ArrayList<T>>();
       
       for( ArrayList<T> comb : combinSet )
       {
           anchor.add(comb);
           ArrayList<ArrayList<T>> temp = new ArrayList<ArrayList<T>>();
           
           for(int i = 0; i <= comb.size() - 2; i++)
           {
               for(ArrayList<T> perm : anchor){
                   for(int j = i + 1; j <= comb.size() - 1; j++){
                       
                       ArrayList<T> newPerm = new ArrayList<T>(); newPerm.addAll(perm);
                       Collections.swap(newPerm, i, j); temp.add(newPerm);
                   }}
               anchor.addAll(temp); temp.clear();
           }
           results.addAll(anchor); anchor.clear();
       }
       permutSet = new ArrayList<ArrayList<T>>();
       permutSet.addAll(results);
    }
    
   /** public List nextPermutation()
    {
        return X;
    }*/
    
     
    
   public void printCombList()
   {
       for(ArrayList<T> comb : combinSet)
       {
       System.out.println(comb.toString());
       }
   } 
   
   public void printPermList()
   {
       for(ArrayList<T> perm : permutSet)
       {
       System.out.println(perm.toString());
       }
   } 
    
    
}