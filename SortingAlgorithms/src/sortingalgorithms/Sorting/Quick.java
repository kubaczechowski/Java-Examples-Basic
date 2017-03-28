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
public class Quick implements SortStrategy {
    @Override
    public Integer[] sort(Integer[] input) {
        int pivot = 0;
        int middle = input.length / 2;
        int i = 0;
        int j = 0;
        int k = 0;
        if (input.length < 2) {
            return input;
        } 
        else 
        {
            Integer[] leftArray = new Integer[input.length];
            Integer[] rightArray = new Integer[input.length];
            Integer[] sorted = new Integer[input.length];
            pivot = input[middle];
            for (i = 0; i < input.length; i++) {
                if (i != middle) {
                    if (input[i] < pivot) {
                        leftArray[j] = input[i];
                        j++;
                    } else {
                        rightArray[k] = input[i];
                        k++;
                    }
                }
            }
            Integer[] sortedLeft = new Integer[j];
            Integer[] sortedRight = new Integer[k];
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
