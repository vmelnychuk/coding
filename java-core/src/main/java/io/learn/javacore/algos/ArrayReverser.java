package io.learn.javacore.algos;

public class ArrayReverser {

    public void reverse(int[] array) {
        if (array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public int[] reverse1(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
        return array;
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
