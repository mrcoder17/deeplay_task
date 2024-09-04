package ru.boxberger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalLoader {
    public List<Animal> loadAnimals(String fileName) throws IOException {
        List<Animal> animals = new ArrayList<Animal>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] properties = line.split(",");
                animals.add(new Animal(properties[0], properties[1], properties[2]));
            }
        }
        return animals;
    }
}
