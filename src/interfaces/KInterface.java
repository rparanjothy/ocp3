package interfaces;

public interface KInterface {
    default void runMeWrapper(){
        System.out.println("I am from KInterface");
    }
}
