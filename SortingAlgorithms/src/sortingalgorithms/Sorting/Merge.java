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
public class Merge implements SortStrategy {

    @Override
    public Integer[] sort(Integer[] input) {
        if (input.length <= 1) {
            return input;
        } else {
            Integer middle = input.length / 2;
            int rem = input.length - middle;
            Integer[] L = new Integer[middle];
            Integer[] R = new Integer[rem];
            System.arraycopy(input, 0, L, 0, middle);
            System.arraycopy(input, middle, R, 0, rem);
            L = this.sort(L);
            R = this.sort(R);
            return merge(L, R);
        }
    }

    public Integer[] merge(Integer[] L, Integer[] R) {
        int lenL = L.length;
        int lenR = R.length;
        Integer[] merged = new Integer[lenL + lenR];
        int i = 0;
        int j = 0;
        while (i < lenL || j < lenR) {
            if (i < lenL & j < lenR) {
                if (L[i] <= R[j]) {
                    merged[i + j] = L[i];
                    i++;
                } else {
                    merged[i + j] = R[j];
                    j++;
                }
            } else if (i < lenL) {
                merged[i + j] = L[i];
                i++;
            } else if (j < lenR) {
                merged[i + j] = R[j];
                j++;
            }
        }
        return merged;
    }
}
