package pl.idczak.warehouseman2;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){
        super(message);
    }
}
