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
public class Bubble implements SortStrategy {

    @Override
    public Integer[] sort(Integer[] input) {
        int tmp = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = (input.length - 1); j >= (i + 1); j--) {
                if (input[j] < input[j - 1]) {
                    tmp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = tmp;
                }
            }
        }
        return input;
    }
}
