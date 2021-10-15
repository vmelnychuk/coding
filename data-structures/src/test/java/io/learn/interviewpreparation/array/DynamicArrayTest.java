package io.learn.interviewpreparation.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicArrayTest {

    @Test
    @DisplayName("size of new dynamic array with no-arg constructor")
    public void sizeOfNewArrayWithDefaultConstructor() {
        DynamicArray dynamicArray = new DynamicArray();

        assertEquals(0, dynamicArray.size());
    }


    @Test
    @DisplayName("size of new dynamic array with parametrized constructor")
    public void sizeOfNewArrayWithParamConstructor() {
        DynamicArray dynamicArray = new DynamicArray(10);

        assertEquals(10, dynamicArray.size());
    }
}
