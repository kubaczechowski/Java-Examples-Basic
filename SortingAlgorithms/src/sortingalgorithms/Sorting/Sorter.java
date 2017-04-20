/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms.Sorting;

import java.util.List;

/**
 *
 * @author Jeppe
 */
public class Sorter {
    SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    public Comparable[] sort(Comparable[] input)
    {
        return strategy.sort(input);
    }
    
    
}
