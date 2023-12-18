package generics;

import java.util.List;

public class Application {
//    public static <T> List<T> toList(T[] array) {
//        return new ArrayList<>(Arrays.asList(array));
//    }

    public static void main(String[] args) {
        // Завдання 1
        String[] strArray = {"one", "two", "three"};
        List<String> strList = ArrayToListConverter.toList(strArray);
        System.out.println("Converted List: " + strList);

        // Завдання 2
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        // Порівняння коробок
        System.out.println("Are the boxes equal in weight? " + appleBox1.compare(orangeBox));

        // Пересипання фруктів
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox1.merge(appleBox2);
        System.out.println("Merged Apple Boxes: " + appleBox1.getWeight() + ", " + appleBox2.getWeight());
    }
}
