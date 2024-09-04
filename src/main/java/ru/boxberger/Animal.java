package ru.boxberger;

public class Animal {
    private final String weight;
    private final String height;
    private final String type;

    public Animal(String weight, String height, String type) {
        this.weight = weight;
        this.height = height;
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }
}
