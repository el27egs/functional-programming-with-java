package globant;

public class Pyramid {

    /*

    1->1  1 + (1-1)
    2->3  2 + (2-1)
    3->5  3 + (3-1)
    4->7  4 + (4-1)
    5->9  5 + (5-1) <- NumChars

    # <- ( 2 * (row-1) ) + 1

    */

    public static void main(String[] args) {

        int numRows = 10;
        pyramidOwn(numRows);
        System.out.println("---------------------------------------");
        pyramidIA(numRows);
    }

    private static void pyramidOwn(int numRows) {
        int numChars = numRows + (numRows - 1);

        for (int row = 1; row <= numRows; row++) {
            int content = (2 * (row -1))+1;
            int spaces =(int) Math.floor( (double) (numChars - content) /2);
            System.out.print(" ".repeat(spaces));
            System.out.print("#".repeat(content));
            System.out.print(" ".repeat(spaces));
            System.out.println();
        }

    }

    private static void pyramidIA(int numRows){

        int numChars = (numRows * 2) - 1;

        for (int row = 1; row <= numRows; row++) {
            int content = (2 * row) - 1;
            int spaces = (numChars - content) / 2;

            System.out.print(" ".repeat(spaces));
            System.out.print("#".repeat(content));
            System.out.println();
        }
    }
}
