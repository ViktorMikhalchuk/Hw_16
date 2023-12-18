package generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    // Додавання фрукта (1 од.) до коробки
    public void addFruit(T fruit) {
        if (!fruits.isEmpty() && !fruits.get(0).getClass().equals(fruit.getClass())) {
            throw new IllegalArgumentException("Неприпустима комбінація фруктів у коробці");
        }
        fruits.add(fruit);
    }

    // Додавання фруктів (множ) у коробку
    public void addFruits(List<T> fruitsToAdd) {
        for (T fruit : fruitsToAdd) {
            addFruit(fruit);
        }
    }

    // Вираховує вагу коробки
    public double getWeight() {
        if (fruits.isEmpty()) {
            return 0;
        }
        return fruits.get(0).getClass() == Apple.class ? fruits.size() * 1.0 : fruits.size() * 1.5;
    }

    // Порівняння коробок
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    //Пересипання фруктів з іншої коробки
    public void merge(Box<T> anotherBox) {
        if (!fruits.isEmpty() && !anotherBox.fruits.isEmpty() &&
                !fruits.get(0).getClass().equals(anotherBox.fruits.get(0).getClass())) {
            throw new IllegalArgumentException("Неприпустима комбінація фруктів у коробках");
        }
        fruits.addAll(anotherBox.fruits);
        anotherBox.fruits.clear();
    }
}