package ru.abramov.BigTaskHomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private T[] miniBox;
    private float weight;


    public Box(T[] minBox) {
        this.miniBox = minBox;
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T value : miniBox
        ) {
            boxWeight += value.getWeight();
        }
        return boxWeight;
    }

    public void puttInBox(Box<T> b){
        if(this.getClass() == b.getClass()){

        }
    }

    static class GenericBox {

        public static void main(String[] args) {
            Apple[] apples = new Apple[(int) Math.round(Math.random() * 20)];
            Orange[] oranges = new Orange[(int) Math.round(Math.random() * 20)];
            Box<Apple> appleBox = new Box<>(apples);
            Box<Orange> orangeBox = new Box<>(oranges);
            appleBox.ConvertsToArrayList();
            orangeBox.ConvertsToArrayList();
//float a=appleBox.getWeight();
          //  System.out.println(a);
            System.out.println(appleBox);
            System.out.println(orangeBox);

        }
    }
    private void ConvertsToArrayList(){
        List<T> ar = new ArrayList<>();
        ar.addAll(Arrays.asList(miniBox));
        System.out.println(ar);
    }
}
