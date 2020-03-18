package ru.abramov.lesson6_testing;


import java.util.Arrays;

public class CalcArray {

    /*public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arr2 = {1, 1, 2, 2, 4, 4};
        int[] arr3 = {12, 21, 12, 22, 1};
        System.out.println(Arrays.toString(puller(arr)));
        System.out.println(iLoveFourAndOne(arr2));

        System.out.println(Arrays.toString(puller(arr2)));
        System.out.println(Arrays.toString(puller(arr3)));

    }*/

    public boolean iLoveFourAndOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 4) {
            }else{
                return false;
            }
        }
        return true;
    }

    public int[] puller(int[] arr) {
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 4) {
                sum++;
            } else {
                break;
            }
        }

        if (sum == arr.length) throw new RuntimeException("нет тут 4");

        int[] arr2 = new int[sum];
        int i;
        int j;
        for (i = 0, j = arr.length - sum; i < sum; j++, i++) {
            arr2[i] = arr[j];
        }
        return arr2;
    }
}
