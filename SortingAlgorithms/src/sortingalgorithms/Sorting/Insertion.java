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
public class Insertion implements SortStrategy {
    @Override
    public Integer[] sort(Integer[] input) {
        int key=0;
        int i = 0;
        for (int j = 1; j < input.length; j++) {
            key = input[j];
            i = j - 1;
            while (i >= 0 && input[i] > key) {
                input[i + 1] = input[i];
                i--;
                input[i + 1] = key;
            }
        }
        return input;
    }
}
