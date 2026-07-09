package globant;

import java.util.Arrays;
import java.util.List;

public class MaxMinNumbers {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,4,5,6,8,2,3,4,5,6,7,8,9,10);
        int min = integers.stream().mapToInt(r->r.intValue()).min().getAsInt();
        System.out.println("Min " +  min);
        int max = integers.stream().mapToInt(r->r.intValue()).max().getAsInt();
        System.out.println("Max " +  max);

    }
}
