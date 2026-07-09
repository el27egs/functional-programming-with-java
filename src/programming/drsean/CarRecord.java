package programming.drsean;


public record CarRecord (String numReg, String owner){

    public CarRecord{
        if (numReg.length() <= 4) {
            throw new IllegalArgumentException("NumReg must be greater than 4 please");
        }
    }

    public CarRecord(){
        this("","");
    }
}
