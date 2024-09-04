package ru.boxberger;

import java.io.IOException;
import java.util.List;

public class AnimalCounter {
    public static void main(String[] args) throws IOException {
        AnimalLoader animalLoader = new AnimalLoader();
        List<Animal> animals = animalLoader.loadAnimals("animals.txt");

        RuleLoader ruleLoader = new RuleLoader();
        List<Rule> rules = ruleLoader.loadRules("rules.txt");

        for (Rule rule : rules) {
            long count = animals.stream().filter(rule::matches).count();
            System.out.println("Rule: " + rule + ". Count: " + count);
        }
    }
}
