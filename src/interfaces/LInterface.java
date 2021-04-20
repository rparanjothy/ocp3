package interfaces;

@FunctionalInterface
public interface LInterface {
    void aVoidMethod();

    default void hi() {
        System.out.println("I Am hi a default method");
    }

    static void staticMethod() {
        System.out.println("I am a static method and I have body");
    }

};
