package io.learn.javacore.algos.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

class ShuffleAnArrayTest {

    @Test
    void reset() {
        int nums[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
        int[] reset = shuffleAnArray.reset();

        assertThat(nums, equalTo(reset));
    }

    @Test
    void shuffle() {
        int nums[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
        int[] shuffle = shuffleAnArray.shuffle();

        assertThat(nums, not(equalTo(shuffle)));
    }
}
