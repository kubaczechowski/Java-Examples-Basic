/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms.Sorting;

/**
 *
 * @author Jeppe
 */
public abstract class SortStrategy {
    private boolean isDescending=false;

    public SortStrategy(boolean isDescending)
    {
        this.isDescending = isDescending;
    }

    public void setIsDescending(boolean isDescending)
    {
        this.isDescending = isDescending;
    }
    
    protected boolean compareValues(Comparable c1, Comparable c2)
    {
        if(isDescending)
            return c1.compareTo(c2)>0;
        else
            return c2.compareTo(c1)>0;
    }
    
    public abstract Comparable[] sort(Comparable[] input);
}
