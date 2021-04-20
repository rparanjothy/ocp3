package interfaces;

public interface RInterface {
//    Can have a private Method with definintion
    private void runMe(){
        System.out.println("I am running..");
    };
// can have a default method wiht body
    default void runMeWrapper(){
        runMe();
    }
//Cant have default sans body
//    default void emptyMe();

//    Can have static var but needs to be initialized
    static int staticInt=-1;

//Static should have a body
    static void staticMethod(){
        System.out.println("I am a static method and I have body"+staticInt);
    };

    void fn1();

}
