package grider;

import java.util.Arrays;

public class Chunk {

    public static void main(String[] args) {

        int[] data = new int[]{1, 2, 3, 4, 5};

        int[][] matrix = chunk(data, 2);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] chunk(int[] a, int size) {

        if (a.length <= size) {
            int[][] r = new int[1][0];
            r[0] = a;
            return r;
        }

        int a1 = 5;
        int b1 = 3;
        System.out.println("5/2 = " +  Math.ceil(a1/b1));
        int numArrays = (int) Math.ceil((double) a.length / size);
        int[][] result = new int[numArrays][0];
        int numElements = 0;
        int offset = 0;
        for (int index = 0; index < numArrays; index++) {
            int remaining = a.length - offset;
            numElements = Math.min(remaining, size);
            result[index] = new int[numElements];
            for (int count = 0; count < numElements; count++) {
                result[index][count] = a[offset];
                offset++;
            }
        }
        return result;
    }

}
