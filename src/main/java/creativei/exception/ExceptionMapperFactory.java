package creativei.exception;

public class ExceptionMapperFactory{
    public static final void getException(Exception ex){
        String type = ex.getClass().getSimpleName();
    }

}
