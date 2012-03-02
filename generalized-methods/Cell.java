

public class Cell<T> {
    
    public Integer index;
    public T content;
    
    public Cell(Integer index, T content)
    {
        this.index = index;
        this.content = content;
    }
    
    public String toString()
    {
        String ans = "(" + index + " " + content.toString() + ")";
        return ans;
    }

    
    
    
    
}
