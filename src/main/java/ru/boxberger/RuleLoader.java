package ru.boxberger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleLoader {
    public List<Rule> loadRules(String fileName) throws IOException {
        List<Rule> rules = new ArrayList<Rule>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> conditions = Arrays.asList(line.split(","));
                rules.add(new Rule(conditions));

            }
        }

        return rules;
    }
}
