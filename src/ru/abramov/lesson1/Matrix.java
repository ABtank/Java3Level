package ru.abramov.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix<T extends Object> {
    private T[] array;

    public Matrix(T[] array) {
        this.array = array.clone();
    }

    static class Main {

        public static void main(String[] args) {

            String a = "Во всем на свете совершенство достигается не тогда " +
                    "когда уже нечего добавить а тогда когда уже нечего убрать ";
            String b = "Никто не говорит что будет легко но в " +
                    "конце ты будешь благодарен себе за то что прошел через все это";

            String text = a + b;
            String[] arrText = text.split(" ");
            Matrix<String> stringMatrix = new Matrix<>(arrText);
            stringMatrix.change();
            stringMatrix.printMatrix();

            Matrix<String> stringMatrix1 = new Matrix<>(a.split(" "));
            stringMatrix1.ConvertsToArrayList();


        }
    }

private void ConvertsToArrayList(){
    List<T> ar = new ArrayList<>();
    ar.addAll(Arrays.asList(array));
    System.out.println(ar);
}

    private void printMatrix() {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) System.out.print("[");
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    public void change() {
        T a;
        for (int i = 1; i < array.length-1; i+=2) {
            if (i % 2 == 1) {
                a = array[i - 1];
                array[i - 1] = array[i];
                array[i] = a;
            }
        }
    }


}
