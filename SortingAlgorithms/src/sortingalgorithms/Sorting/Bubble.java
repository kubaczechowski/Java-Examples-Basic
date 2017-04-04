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
public class Bubble extends SortStrategy {

    public Bubble(boolean isDescending)
    {
        super(isDescending);
    }
    @Override
    public Comparable[] sort(Comparable[] input) {
        Comparable tmp;
        for (int i = 0; i < input.length; i++) {
            for (int j = (input.length - 1); j >= (i + 1); j--) {
                if (compareValues(input[j - 1],input[j])) {
                    tmp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = tmp;
                }
            }
        }
        return input;
    }
    
    
}
