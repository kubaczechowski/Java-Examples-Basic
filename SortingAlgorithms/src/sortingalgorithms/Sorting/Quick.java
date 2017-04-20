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
<<<<<<< HEAD
public class Quick implements SortStrategy {
    
=======
public class Quick extends SortStrategy {

    public Quick(boolean isDescending)
    {
        super(isDescending);
    }
>>>>>>> origin/master
    @Override
    public Comparable[] sort(Comparable[] input) {
        Comparable pivot;
        int middle = input.length / 2;
        int i = 0;
        int j = 0;
        int k = 0;
        if (input.length < 2) {
            return input;
        } 
        else 
        {
            Comparable[] leftArray = new Integer[input.length];
            Comparable[] rightArray = new Integer[input.length];
            Comparable[] sorted = new Integer[input.length];
            pivot = input[middle];
            for (i = 0; i < input.length; i++) {
                if (i != middle) {
                    if (compareValues(pivot,input[i])) {
                        leftArray[j] = input[i];
                        j++;
                    } else {
                        rightArray[k] = input[i];
                        k++;
                    }
                }
            }
            Comparable[] sortedLeft = new Integer[j];
            Comparable[] sortedRight = new Integer[k];
            System.arraycopy(leftArray, 0, sortedLeft, 0, j);
            System.arraycopy(rightArray, 0, sortedRight, 0, k);
            sortedLeft = sort(sortedLeft);
            sortedRight = sort(sortedRight);
            System.arraycopy(sortedLeft, 0, sorted, 0, j);
            sorted[j] = pivot;
            System.arraycopy(sortedRight, 0, sorted, j + 1, k);
            return sorted;
        }
    }
}
