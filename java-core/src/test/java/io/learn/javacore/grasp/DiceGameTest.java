package io.learn.javacore.grasp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiceGameTest {
    @Test
    @DisplayName("test win scenario")
    public void testWinScenario() {
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(5);
        Die die1 = new Die(random);
        Die die2 = new Die(random);

        DiceGame diceGame = new DiceGame(die1, die2);

        diceGame.play();
    }
}
