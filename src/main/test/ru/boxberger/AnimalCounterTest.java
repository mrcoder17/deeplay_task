package ru.boxberger;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalCounterTest {

    @Test
    public void testAnimalCounter() throws IOException {

        List<Animal> testAnimals = Arrays.asList(
                new Animal("ЛЕГКОЕ", "МАЛЕНЬКОЕ", "ВСЕЯДНОЕ"),
                new Animal("ТЯЖЕЛОЕ", "МАЛЕНЬКОЕ", "ТРАВОЯДНОЕ"),
                new Animal("ТЯЖЕЛОЕ", "НЕВЫСОКОЕ", "ТРАВОЯДНОЕ")
        );

        List<Rule> testRules = Arrays.asList(
                new Rule(Arrays.asList("ТРАВОЯДНОЕ")),
                new Rule(Arrays.asList("!ВСЕЯДНОЕ", "МАЛЕНЬКОЕ")),
                new Rule(Arrays.asList("ВСЕЯДНОЕ", "!ВЫСОКОЕ"))
        );

        assertEquals(2, testAnimals.stream().filter(testRules.get(0)::matches).count());
        assertEquals(1, testAnimals.stream().filter(testRules.get(1)::matches).count());
        assertEquals(1, testAnimals.stream().filter(testRules.get(2)::matches).count());
    }

}