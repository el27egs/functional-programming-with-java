package globant;

public class SplitArraySum {
    //9,7,1,1 true
    //7,5,2,10,4 true
    //1,1,1,2,1 true
    //10,9 false
    //8,3,1,20 false

    public static void main(String[] args) {

        int nums[] = {8,3,1,20};

        System.out.println("Respuesta: " +  method(nums));
    }

    private static boolean method(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum  = sum(0,i+1,nums);
            rightSum = sum(i+1,nums.length,nums);
            System.out.println(i + " " + leftSum + " " + rightSum);
            if (leftSum == rightSum) {
                return true;
            }

            if (leftSum > rightSum) {
                return false;
            }
        }

        return false;
    }

    private static int sum(int start, int end, int[] nums) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
