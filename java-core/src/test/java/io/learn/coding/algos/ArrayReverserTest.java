package io.learn.coding.algos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayReverserTest {
    private ArrayReverser reverser = new ArrayReverser();

    @Test
    @DisplayName("should reverse same empty array when empty array is passed")
    void shouldReverseEmptyArrayWhenEmptyArray() {
        int[] array = new int[0];

        reverser.reverse1(array);

        assertArrayEquals(new int[0], array);
    }

    @Test
    @DisplayName("should reverse array when array with size 1 is passed")
    void shouldReverseEmptyArrayWhenSizeOneArray() {
        int[] array = {2};

        reverser.reverse(array);

        assertArrayEquals(new int[]{2}, array);
    }

    @Test
    @DisplayName("should reverse array when not empty array is passed")
    void shouldReverseNotEmptyArrayWhenNotEmptyArray() {
        int[] array = {1, 2, 3, 5};

        reverser.reverse1(array);

        assertArrayEquals(new int[]{5, 3, 2, 1}, array);
    }
}
