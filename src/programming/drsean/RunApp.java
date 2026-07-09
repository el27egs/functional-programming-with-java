package programming.drsean;

public class RunApp {

    public static void main(String[] args) {
        CarRecord carRecord = new CarRecord("123","John");
        System.out.println(carRecord.numReg());
        System.out.println(carRecord.owner());
    }
}
