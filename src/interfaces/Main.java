package interfaces;

public class Main implements RInterface, KInterface {
//    @Override
//    public void runMeWrapper() {
//        System.out.println("New behav for rumMeWrapper()");
//
//    }

    @Override
    public void runMeWrapper() {
        KInterface.super.runMeWrapper();
    }

    @Override
    public void fn1() {

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.runMeWrapper();

        RInterface.staticMethod();
        m.runMeWrapper();
//        Crazy Shit where sis aVoidMethod() come from :)
        LInterface l = () -> System.out.println("hi");
        l.aVoidMethod();
        l.hi();
        LInterface.staticMethod();


    }


}
