package ru.abramov.BigTaskHomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> boxWithFruits;


    public Box() {
        boxWithFruits = new ArrayList<>();
    }

    private List<T> getFruits() {
        return boxWithFruits;
    }

    private void clear() {
        boxWithFruits.clear();
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T value : boxWithFruits
        ) {
            boxWeight += value.getWeight();
        }
        return boxWeight;

    }

    /*public double getWeight() {
        double sum = 0;
        for(int i = 0; i < boxWithFruits.size(); i++) {
            sum += boxWithFruits.get(i).getWeight();
        }
        return sum;
    }*/
    /*public double getWeight() {
        return boxWithFruits.stream().mapToDouble(Fruit::getWeight).sum();
    }*/

    public void puttInBox(T fruit) {
        boxWithFruits.add(fruit);
    }

    public void put(T... fruit) {
        boxWithFruits.addAll(Arrays.asList(fruit));
    }

    public void putAll(Box<T> box) {
        boxWithFruits.addAll(box.getFruits());
        box.clear();
    }

    public <E extends Fruit> boolean compare(Box<E> box) {
        return getWeight() == box.getWeight();
    }


    static class GenericBox {

        public static void main(String[] args) {


            Apple a1 = new Apple();
            Apple a2 = new Apple();
            Apple a3 = new Apple();
            Apple a4 = new Apple();
            Apple a5 = new Apple();
            Apple a6 = new Apple();

            Orange o1 = new Orange();
            Orange o2 = new Orange();
            Orange o3 = new Orange();
            Orange o4 = new Orange();

            Box<Apple> appleBox = new Box<>();
            appleBox.put(a1, a2, a3, a4);
            Box<Orange> orangeBox = new Box<>();
            orangeBox.put(o1, o2, o3, o4);
            Box<Apple> appleBox2 = new Box<>();
            appleBox2.put(a5, a6);

            System.out.println("Вес коробки с яблоками=" + appleBox.getWeight());
            System.out.println("Вес коробки с яблоками=" + appleBox2.getWeight());
            System.out.println("Вес коробки с апельсинами=" + orangeBox.getWeight());
            System.out.println("Попытка положить яблоки к апельсинам: " + appleBox.compare(orangeBox));
            System.out.println("Положим все яблоки в один ящик");
            appleBox.putAll(appleBox2);
            System.out.println("Вес всех яблок=" + appleBox.getWeight());
            // System.out.println("1"+orangeBox.putAll(appleBox));


        }

        /**
         * Как распечатать список ящика?
         */
       /* private static <T extends Fruit> void infoList(Box<T> list) {
            for (T fruit : list
            ) {
                System.out.println(fruit);
            }
        }*/
    }


}
