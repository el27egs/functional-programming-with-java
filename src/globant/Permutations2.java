package globant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {

        int[] seed = {1, 2, 3};
        boolean[] used = new boolean[seed.length];
        List<Integer> current = new ArrayList<>();

        List<List<Integer>> permutations = new ArrayList<>();

        generatePermutations(seed, used, current, permutations);

        for (List<Integer> p : permutations) {
            System.out.println(p);
        }

        System.out.println("--------------");
        List<Integer> numList = Arrays.asList(1, 2, 3);

        permutations = generatePermutations(numList);

        for (List<Integer> p : permutations) {
            System.out.println(p);
        }

    }

    private static void generatePermutations(int[] seed, boolean[] used, List<Integer> current, List<List<Integer>> permutations) {

        if (current.size() == seed.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < seed.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            current.add(seed[i]);

            generatePermutations(seed, used, current, permutations);

            current.remove(current.size() - 1);
            used[i] = false;
        }

    }

    private static List<List<Integer>> generatePermutations(List<Integer> nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        if (nums.size() == 0) {
            result.add(new ArrayList<>());
            return result;
        }


        for (int i = 0; i < nums.size(); i++) {
            int chosen = nums.get(i);
            List<Integer> remaining =  new ArrayList<>(nums);
            remaining.remove(i);

            List<List<Integer>> permutations = generatePermutations(remaining);

            for (List<Integer> p : permutations) {
                List<Integer> permutation =  new ArrayList<>();
                permutation.add(chosen);
                permutation.addAll(p);
                result.add(permutation);
            }
        }

        return result;
    }
}
