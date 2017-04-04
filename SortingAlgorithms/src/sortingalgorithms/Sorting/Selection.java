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
public class Selection extends SortStrategy {

    public Selection(boolean isDescending)
    {
        super(isDescending);
    }
    public Comparable[] sort(Comparable[] input) {
        int j = 0;
        Comparable tmp;
        for (int i = 0; i < input.length; i++) {
            j = i;
            for (int k = i; k < input.length; k++) {
                if (compareValues(input[j],input[k])) {
                    j = k;
                }
            }
            tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
        }
        return input;
    }
}
