package ru.boxberger;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private final List<String> conditions = new ArrayList<String>();

    public Rule(List<String> conditions) {
        this.conditions.addAll(conditions);
    }

    /**
     * Проверяет, соответствует ли объект `Animal` набору условий, представленных в виде списка строк.
     *
     * Метод возвращает `true`, если все условия выполнены, и `false`, если хотя бы одно условие не выполнено.
     * Условия могут быть прямыми или отрицательными. Прямое условие требует соответствия одному из свойств животного,
     * тогда как отрицание означает, что свойство животного не должно соответствовать условию.
     *
     * @param animal Объект класса {@link Animal}, который проверяется на соответствие правилам.
     * @return {@code true}, если объект {@code Animal} соответствует всем условиям, указанным в {@code conditions};
     *         {@code false}, если не соответствует хотя бы одному условию.
     */
    public boolean matches(Animal animal) {
        for (String condition : conditions) {
            boolean isNegation = condition.startsWith("!");
            String actualCondition = isNegation ? condition.substring(1) : condition;

            if (isNegation) {
                if (actualCondition.equals(animal.getWeight()) ||
                        actualCondition.equals(animal.getHeight()) ||
                        actualCondition.equals(animal.getType())) {
                    return false;
                }
            } else {
                if (!(actualCondition.equals(animal.getWeight()) ||
                        actualCondition.equals(animal.getHeight()) ||
                        actualCondition.equals(animal.getType()))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.join(", ", conditions);
    }
}
