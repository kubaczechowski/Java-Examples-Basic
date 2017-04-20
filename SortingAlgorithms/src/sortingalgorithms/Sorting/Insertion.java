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
public class Insertion extends SortStrategy {

    public Insertion(boolean isDescending)
    {
        super(isDescending);
    }
    @Override
    public Comparable[] sort(Comparable[] input) {
        Comparable key;
        int i = 0;
        for (int j = 1; j < input.length; j++) {
            key = input[j];
            i = j - 1;
            while (i >= 0 && compareValues(input[i],key)) {
                input[i + 1] = input[i];
                i--;
                input[i + 1] = key;
            }
        }
        return input;
    }
}
