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
public class Selection implements SortStrategy {

    @Override
    public Integer[] sort(Integer[] input) {
        int j = 0;
        int tmp = 0;
        for (int i = 0; i < input.length; i++) {
            j = i;
            for (int k = i; k < input.length; k++) {
                if (input[j] > input[k]) {
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
