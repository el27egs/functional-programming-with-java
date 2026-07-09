package grider;

import java.util.stream.IntStream;

public class Steps {

    public static void main(String[] args) {

        int number = 5;

        printSteps(number);
        System.out.println("---------------");
        printStepsIA(number);
    }

    private static void printSteps(int number) {

        IntStream.rangeClosed(1,number)
                .limit(number)
                .forEach( row -> {
                    IntStream.rangeClosed(1,number)
                            .forEach( column ->{

                                if (column <= row){
                                    System.out.print("#");
                                }else{
                                    System.out.print(" ");
                                }
                            });
                    System.out.println();
                });
    }

    private static void printStepsIA(int number){

        IntStream.rangeClosed(1, number)
                .forEach(row -> System.out.println("#".repeat(row)));
    }

}
