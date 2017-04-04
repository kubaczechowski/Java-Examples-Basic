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
public class Merge extends SortStrategy {

    public Merge(boolean isDescending)
    {
        super(isDescending);
    }

    @Override
    public Comparable[] sort(Comparable[] input) {
        if (input.length <= 1) {
            return input;
        } else {
            Integer middle = input.length / 2;
            int rem = input.length - middle;
            Comparable[] leftArray = new Integer[middle];
            Comparable[] rightArray = new Integer[rem];
            System.arraycopy(input, 0, leftArray, 0, middle);
            System.arraycopy(input, middle, rightArray, 0, rem);
            leftArray = this.sort(leftArray);
            rightArray = this.sort(rightArray);
            return merge(leftArray, rightArray);
        }
    }

    public Comparable[] merge(Comparable[] leftArray, Comparable[] rightArray) {
        int lenL = leftArray.length;
        int lenR = rightArray.length;
        Comparable[] merged = new Integer[lenL + lenR];
        int i = 0;
        int j = 0;
        while (i < lenL || j < lenR) {
            if (i < lenL & j < lenR) {
                if (super.compareValues(rightArray[j],leftArray[i])) {
                    merged[i + j] = leftArray[i];
                    i++;
                } else {
                    merged[i + j] = rightArray[j];
                    j++;
                }
            } else if (i < lenL) {
                merged[i + j] = leftArray[i];
                i++;
            } else if (j < lenR) {
                merged[i + j] = rightArray[j];
                j++;
            }
        }
        return merged;
    }
}
