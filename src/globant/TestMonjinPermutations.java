package globant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestMonjinPermutations {

    /*
        perm(a) -> a
        perm(a,b) -> a,perm(b) & b,perm(a)
        perm(a,b,c) -> a,perm(b,c) & b,perm(a,c) & c,perm(a,b)
     */

    private static int[] removeValueAtIndex(int index, int[] numbers) {
        int[] retVal = new int[numbers.length - 1];
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i == index) {
                continue;
            } else {
                retVal[j++] = numbers[i];
            }
        }
        return retVal;
    }

    /*
       private static int[] removeValueAtIndex(int index, int[] arr) {
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // return the resultant array
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }
    private static int[] appendValueAt(int[] arr, int value, int index) {
        return IntStream.range(0, arr.length + 1)
                .map(i -> {
                    if (i != index && i < index) {
                        return arr[i];
                    }
                    if (i == index){
                        return value;
                    }
                    return arr[--i];
                })
                .toArray();
    }
     */
    private static int[] appendValueAt(int[] numbers, int value, int index) {
        int[] retVal = new int[numbers.length + 1];
        retVal[index] = value;
        for (int i = 0; i < retVal.length; i++) {
            if (index == i) {
                continue;
            }
            retVal[i] = numbers[i - 1];
        }
        return retVal;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3,};
        System.out.println(Arrays.deepToString(getPermutations(input)));
        HashMap<String, String> properties = new HashMap<>();
        properties.put("rds.iam.enabled","true");
        properties.putIfAbsent("rds.iam.enabled","false");
        System.out.println(properties.get("rds.iam.enabled"));

    }
    private static int[][] getPermutations(int[] input) {

        if (input.length == 1) {
            int[][] retVal = new int[1][];
            retVal[0] = input;
            return retVal;
        }

        List<int[]> items = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int pivot = input[i];
            int[] slide = removeValueAtIndex(i, input);
            int[][] values = getPermutations(slide);
            for (int j = 0; j < values.length; j++) {
                items.add(appendValueAt(values[j], pivot, 0));
            }
        }
        int[][] retVal = new int[items.size()][];
        for (int i=0; i<items.size(); i++){
            retVal[i] = items.get(i);
        }
        return retVal;
    }
}
