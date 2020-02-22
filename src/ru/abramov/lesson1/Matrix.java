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
            printMatrix(arrText);
            System.out.println("Меняем 2 элемента");
            changeTwoElements(arrText, 0, 1);
            printMatrix(arrText);
            changeTwoElements(arrText, 0, 1);

            System.out.println("Меняем все элементы");
            change(arrText);
            printMatrix(arrText);
            change(arrText);

            System.out.println("Переносим все в лист");
            List<String> list = ConvertsToArrayList(arrText);
            System.out.println(list);

        }
    }

    private static <T> List<T> ConvertsToArrayList(T[] array) {
        List<T> ar = new ArrayList<>(Arrays.asList(array));
        //ar.addAll(Arrays.asList(array));
        return ar;
    }

    private static <T> void printMatrix(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) System.out.print("[");
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static <T> void change(T[] arr) {
        T a;
        for (int i = 1; i < arr.length - 1; i += 2) {
            if (i % 2 == 1) {
                a = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = a;
            }
        }
    }

    public static <T> void changeTwoElements(T[] arr, int a, int b) {
        T c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }


}
