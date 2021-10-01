package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitionArrayIntoDisjointIntervalsTest {

    private PartitionArrayIntoDisjointIntervals partitionArrayIntoDisjointIntervals = new PartitionArrayIntoDisjointIntervals();

    @BeforeEach
    void setUp() {
    }

    @Test
    void partitionDisjointEx1() {
        int[] nums = new int[]{5, 0, 3, 8, 6};
        int expectedResult = 3;

        int result = partitionArrayIntoDisjointIntervals.partitionDisjoint(nums);

        assertEquals(expectedResult, result);
    }

    @Test
    void partitionDisjointEx2() {
        int[] nums = new int[]{1, 1, 1, 0, 6, 12};
        int expectedResult = 4;

        int result = partitionArrayIntoDisjointIntervals.partitionDisjoint(nums);

        assertEquals(expectedResult, result);
    }
}
