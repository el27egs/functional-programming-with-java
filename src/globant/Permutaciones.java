package globant;

import java.util.*;

public class Permutaciones {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result
    ) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            int chosen = nums.get(i);

            List<Integer> remaining = new ArrayList<>(nums);
            remaining.remove(i);

            List<List<Integer>> subPermutations = permute(remaining);

            for (List<Integer> sub : subPermutations) {
                List<Integer> permutation = new ArrayList<>();
                permutation.add(chosen);
                permutation.addAll(sub);

                result.add(permutation);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> permutations = permute(nums);

        for (List<Integer> p : permutations) {
            System.out.println(p);
        }


        List<Integer> numList = Arrays.asList(1, 2, 3);

        List<List<Integer>> permutations2 = permute(numList);

        for (List<Integer> p : permutations2) {
            System.out.println(p);
        }

    }
}