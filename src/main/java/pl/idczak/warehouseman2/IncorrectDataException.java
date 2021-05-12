package pl.idczak.warehouseman2;

public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String message){
        super(message);
    }
}
