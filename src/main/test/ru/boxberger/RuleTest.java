package ru.boxberger;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleTest {

    @Test
    public void testMatchesWithPositiveCondition() {
        Rule rule = new Rule(Arrays.asList("ВСЕЯДНОЕ"));
        Animal animal = new Animal("ЛЕГКОЕ", "МАЛЕНЬКОЕ", "ВСЕЯДНОЕ");
        Animal nonMatchingAnimal = new Animal("ЛЕГКОЕ", "МАЛЕНЬКОЕ", "ТРАВОЯДНОЕ");

        assertTrue(rule.matches(animal));
        assertFalse(rule.matches(nonMatchingAnimal));
    }

    @Test
    public void testMatchesWithNegationCondition() {
        Rule rule = new Rule(Arrays.asList("!ВСЕЯДНОЕ"));
        Animal animal = new Animal("ЛЕГКОЕ", "МАЛЕНЬКОЕ", "ВСЕЯДНОЕ");
        Animal nonMatchingAnimal = new Animal("ЛЕГКОЕ", "МАЛЕНЬКОЕ", "ТРАВОЯДНОЕ");

        assertFalse(rule.matches(animal));
        assertTrue(rule.matches(nonMatchingAnimal));
    }

    @Test
    public void testMatchesWithMultipleConditions() {
        Rule rule = new Rule(Arrays.asList("!ВСЕЯДНОЕ", "МАЛЕНЬКОЕ"));
        Animal animal = new Animal("ЛЕГКОЕ", "МАЛЕНЬКОЕ", "ТРАВОЯДНОЕ");
        Animal nonMatchingAnimal = new Animal("ЛЕГКОЕ", "ВЫСОКОЕ", "ВСЕЯДНОЕ");

        assertTrue(rule.matches(animal));
        assertFalse(rule.matches(nonMatchingAnimal));
    }
}